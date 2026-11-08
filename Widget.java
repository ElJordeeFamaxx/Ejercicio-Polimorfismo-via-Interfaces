
/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Widget: componente del diseño MVC e interfaces.
 */
import java.util.Objects;

public abstract class Widget implements Renderizable, Comparable<Widget> {
    private final int id;
    private final String nombre;
    private final int memoriaKB;
    private boolean activo = true;

    protected Widget(int id, String nombre, int memoriaKB) {
        if (id <= 0 || nombre == null || nombre.trim().isEmpty() || memoriaKB < 0)
            throw new IllegalArgumentException("ID, nombre o memoria inválidos.");
        this.id = id;
        this.nombre = nombre.trim();
        this.memoriaKB = memoriaKB;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMemoriaKB() {
        return memoriaKB;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String configuracion() {
        return toString() + "\nTipo: " + getClass().getSimpleName()
                + "\nActivo: " + activo + "\nInteractivo: " + (this instanceof Interactivo)
                + "\nActualizable: " + (this instanceof Actualizable) + "\n" + renderizar();
    }

    // Desempate estable por ID; la memoria estimada permanece inmutable.
    @Override
    public int compareTo(Widget otro) {
        int c = Integer.compare(memoriaKB, otro.memoriaKB);
        return c == 0 ? Integer.compare(id, otro.id) : c;
    }

    // Identidad por ID; Dashboard rechaza IDs repetidos.
    @Override
    public final boolean equals(Object o) {
        return o instanceof Widget && id == ((Widget) o).id;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + memoriaKB + " KB";
    }
}
