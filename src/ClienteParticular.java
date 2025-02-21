/**
 * Clase que representa a un cliente particular del hotel.
 * Extiende la clase abstracta Cliente.
 */
public class ClienteParticular extends Cliente {
    /**
     * Constructor de ClienteParticular.
     * @param dni Identificación del cliente.
     * @param nombre Nombre del cliente.
     * @param telCliente Teléfono del cliente.
     * @param email Correo electrónico del cliente.
     */
    public ClienteParticular(String dni, String nombre, int telCliente, String email) {
        super(dni, nombre, telCliente, email);
    }
    /**
     * Implementación del método abstracto para realizar una reserva.
     * @param habitacion Habitación a reservar.
     */
    @Override
    public void realizarReserva(Habitacion habitacion) {
        System.out.println("Cliente privado " + getNombre() + " ha reservado la habitación " + habitacion.getNumero());
    }
}
