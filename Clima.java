/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Clima: componente del diseño MVC e interfaces.
 */
public class Clima extends Widget implements Actualizable {
    private final String ciudad;
    private double temperatura;

    public Clima(int id, String nombre, int kb, String ciudad, double temperatura) {
        super(id, nombre, kb);
        this.ciudad = ciudad;
        this.temperatura = temperatura;
    }

    @Override
    public String renderizar() {
        return ciudad + ": " + String.format(java.util.Locale.ROOT, "%.1f °C", temperatura) + " (simulado)";
    }

    @Override
    public void actualizar() {
        temperatura = temperatura >= 28 ? 20 : temperatura + 0.5;
    }
}
