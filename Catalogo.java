/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Catalogo: componente del diseño MVC e interfaces.
 */
public final class Catalogo {
    private Catalogo() {
    }

    public static void cargar(Dashboard d) {
        d.agregar(new Clima(1, "Clima Guatemala", 150, "Guatemala", 22));
        d.agregar(new Clima(2, "Clima Antigua", 140, "Antigua", 20));
        d.agregar(new Reloj(3, "Reloj local", 45, "America/Guatemala"));
        d.agregar(new Reloj(4, "Reloj UTC", 40, "UTC"));
        d.agregar(new Tareas(5, "Tareas de desarrollo", 90, 5));
        d.agregar(new Tareas(6, "Tareas de soporte", 85, 3));
        d.agregar(new Alerta(7, "Alerta de respaldo", 60, "Revisar respaldo diario"));
        d.agregar(new Alerta(8, "Alerta de reunión", 55, "Reunión a las 10:00"));
        d.agregar(new Nota(9, "Bienvenida", 20, "Bienvenido al panel empresarial"));
        d.agregar(new Nota(10, "Recordatorio", 25, "Documentar los cambios del proyecto"));
    }
}