import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private String dni;
    private String nombre;
    private int telCliente;
    private String email;
    private List<ServicioAdicional> serviciosSolicitados;

    // Constructor
    public Cliente(String dni, String nombre, int telCliente, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.telCliente = telCliente;
        this.email = email;
        this.serviciosSolicitados = new ArrayList<>();
    }

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

    public void solicitarServicio(ServicioAdicional servicio) {
        serviciosSolicitados.add(servicio);
        System.out.println("Servicio " + servicio.getNombre() + " agregado al cliente " + nombre);
    }

    public List<ServicioAdicional> getServiciosSolicitados() {
        return serviciosSolicitados;
    }
}
