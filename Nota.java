/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Nota: componente del diseño MVC e interfaces.
 */
public class Nota extends Widget {
    private final String texto;

    public Nota(int id, String nombre, int kb, String texto) {
        super(id, nombre, kb);
        this.texto = texto;
    }

    @Override
    public String renderizar() {
        return texto;
    }
}