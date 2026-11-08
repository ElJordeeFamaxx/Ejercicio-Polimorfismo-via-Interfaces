
/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Dashboard: componente del diseño MVC e interfaces.
 */
import java.util.*;
import java.util.function.Consumer;

public class Dashboard {
    // Única colección que almacena objetos Widget; no se expone al exterior.
    private final List<Widget> widgets = new ArrayList<>();

    public void agregar(Widget w) {
        Objects.requireNonNull(w, "Widget nulo");
        if (buscar(w.getId()).isPresent())
            throw new IllegalArgumentException("ID repetido.");
        if (buscar(w.getNombre()).isPresent())
            throw new IllegalArgumentException("Nombre repetido.");
        widgets.add(w);
    }

    public Optional<Widget> buscar(int id) {
        return widgets.stream().filter(w -> w.getId() == id).findFirst();
    }

    public Optional<Widget> buscar(String nombre) {
        if (nombre == null)
            return Optional.empty();
        return widgets.stream().filter(w -> w.getNombre().equalsIgnoreCase(nombre.trim())).findFirst();
    }

    public void ordenar() {
        Collections.sort(widgets);
    }

    public void paraCada(Consumer<Widget> accion) {
        widgets.forEach(accion);
    }

    public void actualizar() {
        for (Widget w : widgets)
            if (w.isActivo() && w instanceof Actualizable)
                ((Actualizable) w).actualizar();
    }
}