/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * VistaDashboard: componente del diseño MVC e interfaces.
 */
public interface VistaDashboard {
    void limpiar();

    void agregar(Widget w, Renderizable contenido);

    void mostrar(String texto);
}