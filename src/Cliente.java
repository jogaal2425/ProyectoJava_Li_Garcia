import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa a un cliente del hotel.
 * Puede ser extendida para crear tipos específicos de clientes (particular o empresa).
 */
public abstract class Cliente {
    private String dni;
    private String nombre;
    private int telCliente;
    private String email;
    private List<ServicioAdicional> serviciosSolicitados;

    /**
     * Constructor de la clase Cliente.
     * @param dni Identificación del cliente.
     * @param nombre Nombre del cliente.
     * @param telCliente Teléfono del cliente.
     * @param email Correo electrónico del cliente.
     */
    // Constructor
    public Cliente(String dni, String nombre, int telCliente, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.telCliente = telCliente;
        this.email = email;
        this.serviciosSolicitados = new ArrayList<>();
    }
    /**
     * Método abstracto para realizar una reserva.
     * Debe ser implementado por las subclases.
     * @param habitacion Habitación a reservar.
     */

    // Métodos abstractos
    public abstract void realizarReserva(Habitacion habitacion);

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelCliente() {
        return telCliente;
    }
    public void setTelCliente(int telCliente) {
        this.telCliente = telCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Solicita un servicio adicional para el cliente.
     * @param servicio Servicio adicional a agregar.
     */
    public void solicitarServicio(ServicioAdicional servicio) {
        serviciosSolicitados.add(servicio);
        System.out.println("Servicio " + servicio.getNombre() + " agregado al cliente " + nombre);
    }

    /**
     * Obtiene la lista de servicios solicitados por el cliente.
     * @return Lista de servicios adicionales.
     */
    public List<ServicioAdicional> getServiciosSolicitados() {
        return serviciosSolicitados;
    }
}
