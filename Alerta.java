/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Alerta: componente del diseño MVC e interfaces.
 */
public class Alerta extends Widget implements Interactivo {
    private final String mensaje;
    private boolean leida;

    public Alerta(int id, String nombre, int kb, String mensaje) {
        super(id, nombre, kb);
        this.mensaje = mensaje;
    }

    @Override
    public String renderizar() {
        return (leida ? "[LEÍDA] " : "[NUEVA] ") + mensaje;
    }

    @Override
    public String alHacerClic() {
        leida = true;
        return "Alerta marcada como leída.";
    }
}