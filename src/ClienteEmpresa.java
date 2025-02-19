public class ClienteEmpresa extends Cliente {
    public ClienteEmpresa(String dni, String nombre, String email) {
        super(dni, nombre, email);
    }

    @Override
    public void realizarReserva(Habitacion habitacion) {
        // Lógica para realizar la reserva de una habitación (o servicio especial)
        System.out.println("Escuela " + getNombre() + " ha reservado la habitación " + habitacion.getNumero());
    }
}
