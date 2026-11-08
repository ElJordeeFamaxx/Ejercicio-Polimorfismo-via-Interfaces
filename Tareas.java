/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Tareas: componente del diseño MVC e interfaces.
 */
public class Tareas extends Widget implements Interactivo {
    private int pendientes;

    public Tareas(int id, String nombre, int kb, int pendientes) {
        super(id, nombre, kb);
        if (pendientes < 0)
            throw new IllegalArgumentException("Cantidad negativa.");
        this.pendientes = pendientes;
    }

    @Override
    public String renderizar() {
        return "Tareas pendientes: " + pendientes;
    }

    @Override
    public String alHacerClic() {
        if (pendientes == 0)
            return "No quedan tareas pendientes.";
        pendientes--;
        return "Tarea completada. Restantes: " + pendientes;
    }
}