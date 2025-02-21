/**
 * Clase que representa un cliente de empresa en el sistema de gestión hotelera.
 * Hereda de la clase Cliente y sobreescribe el método realizarReserva.
 */
public class ClienteEmpresa extends Cliente {
    /**
     * Constructor de ClienteEmpresa.
     * @param dni DNI o identificador de la empresa.
     * @param nombre Nombre de la empresa.
     * @param telCliente Teléfono de contacto de la empresa.
     * @param email Correo electrónico de la empresa.
     */
    public ClienteEmpresa(String dni, String nombre, int telCliente, String email) {
        super(dni, nombre, telCliente, email);
    }

    /**
     * Realiza la reserva de una habitación para la empresa.
     * @param habitacion La habitación a reservar.
     */
    @Override
    public void realizarReserva(Habitacion habitacion) {
        System.out.println("Escuela " + getNombre() + " ha reservado la habitación " + habitacion.getNumero());
    }
}
