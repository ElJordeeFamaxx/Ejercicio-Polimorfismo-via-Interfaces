/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Controlador: componente del diseño MVC e interfaces.
 */
public class Controlador {
    private final Dashboard modelo;
    private final VistaDashboard vista;

    public Controlador(Dashboard modelo, VistaDashboard vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void listar() {
        vista.limpiar();
        modelo.paraCada(w -> {
            if (w.isActivo())
                vista.agregar(w, w);
        });
    }

    public void buscar(int id) {
        mostrar(modelo.buscar(id));
    }

    public void buscar(String nombre) {
        mostrar(modelo.buscar(nombre));
    }

    private void mostrar(java.util.Optional<Widget> w) {
        vista.mostrar(w.map(Widget::configuracion).orElse("No se encontró el widget."));
    }

    public void ordenar() {
        modelo.ordenar();
        listar();
    }

    private String ejecutar(Interactivo i) {
        return i.alHacerClic();
    }

    public void clic(int id) {
        java.util.Optional<Widget> encontrado = modelo.buscar(id);
        if (!encontrado.isPresent()) {
            vista.mostrar("No se encontró el widget.");
            return;
        }
        Widget w = encontrado.get();
        if (!w.isActivo()) {
            vista.mostrar("El widget está inactivo.");
            return;
        }
        if (w instanceof Interactivo) {
            vista.mostrar(ejecutar((Interactivo) w));
            listar();
        } else
            vista.mostrar("Este widget es informativo y no admite clics.");
    }

    public void actualizar() {
        modelo.actualizar();
        listar();
    }
}
