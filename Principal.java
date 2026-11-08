
/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Principal: componente del diseño MVC e interfaces.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Principal extends JFrame implements VistaDashboard {
    private final DefaultTableModel tablaModelo = new DefaultTableModel(
            new String[] { "ID", "Nombre", "Memoria KB", "Contenido" }, 0) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    private final JTable tabla = new JTable(tablaModelo);
    private final JTextArea detalle = new JTextArea(6, 50);
    private final JTextField consulta = new JTextField(17);
    private final JComboBox<String> criterio = new JComboBox<>(new String[] { "ID", "Nombre" });
    private final Controlador controlador;

    public Principal() {
        super("Dashboard modular | Ejercicio 6");
        Dashboard modelo = new Dashboard();
        Catalogo.cargar(modelo);
        controlador = new Controlador(modelo, this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel menu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        agregarBoton(menu, "Listar activos", () -> controlador.listar());
        menu.add(criterio);
        menu.add(consulta);
        agregarBoton(menu, "Buscar", this::buscar);
        agregarBoton(menu, "Ordenar por KB", () -> controlador.ordenar());
        agregarBoton(menu, "Interactuar", this::interactuar);
        agregarBoton(menu, "Actualizar", () -> controlador.actualizar());
        agregarBoton(menu, "Salir", this::dispose);
        detalle.setEditable(false);
        detalle.setLineWrap(true);
        detalle.setWrapStyleWord(true);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(menu, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(new JScrollPane(detalle), BorderLayout.SOUTH);
        setSize(1150, 570);
        setLocationRelativeTo(null);
        controlador.listar();
        mostrar("Seleccione un widget y pulse Interactuar. Búsqueda por nombre exacto sin distinguir mayúsculas.");
        // Timer de Swing: modelo y vista se actualizan en el mismo hilo de eventos.
        Timer timer = new Timer(5000, e -> controlador.actualizar());
        timer.start();
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                timer.stop();
            }
        });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void agregarBoton(JPanel panel, String texto, Runnable accion) {
        JButton boton = new JButton(texto);
        boton.addActionListener(e -> accion.run());
        panel.add(boton);
    }

    private void buscar() {
        String texto = consulta.getText().trim();
        if (texto.isEmpty()) {
            mostrar("Ingrese un ID o nombre.");
            return;
        }
        if (criterio.getSelectedIndex() == 0) {
            try {
                controlador.buscar(Integer.parseInt(texto));
            } catch (NumberFormatException e) {
                mostrar("El ID debe ser un número entero válido.");
            }
        } else
            controlador.buscar(texto);
    }

    private void interactuar() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            mostrar("Seleccione una fila primero.");
            return;
        }
        controlador.clic((Integer) tablaModelo.getValueAt(fila, 0));
    }

    @Override
    public void limpiar() {
        tablaModelo.setRowCount(0);
    }

    @Override
    public void agregar(Widget w, Renderizable contenido) {
        // La tabla solo almacena valores de presentación; nunca objetos Widget.
        tablaModelo.addRow(new Object[] { w.getId(), w.getNombre(), w.getMemoriaKB(), contenido.renderizar() });
    }

    @Override
    public void mostrar(String texto) {
        detalle.setText(texto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Principal().setVisible(true));
    }
}
