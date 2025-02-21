/**
 * Interfaz que define los métodos para clases que pueden ser reservadas.
 */
public interface Reservable {
    /**
     * Verifica la disponibilidad.
     * @return true si está disponible, false en caso contrario.
     */
    boolean disponibilidad();
    /**
     * Realiza la reserva.
     */
    void reservar();
}