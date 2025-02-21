public class ClienteParticular extends Cliente {

    public ClienteParticular(String dni, String nombre, int telCliente, String email) {
        super(dni, nombre, telCliente, email);
    }

    @Override
    public void realizarReserva(Habitacion habitacion) {
        System.out.println("Cliente privado " + getNombre() + " ha reservado la habitación " + habitacion.getNumero());
    }
}
