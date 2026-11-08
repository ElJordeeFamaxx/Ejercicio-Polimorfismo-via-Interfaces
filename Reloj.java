
/**
 * CC2008 - Ejercicio 6. Dashboard modular.
 * Reloj: componente del diseño MVC e interfaces.
 */
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Reloj extends Widget implements Actualizable {
    private final ZoneId zona;
    private String hora;

    public Reloj(int id, String nombre, int kb, String zona) {
        super(id, nombre, kb);
        this.zona = ZoneId.of(zona);
        actualizar();
    }

    @Override
    public void actualizar() {
        hora = ZonedDateTime.now(zona).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String renderizar() {
        return zona + " | " + hora;
    }
}
