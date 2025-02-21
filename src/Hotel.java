import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Hotel {
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Empleado> empleados;
    private ArrayList<Reserva> reservas;
    private ArrayList<ServicioAdicional> servicios;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Constructor
    public Hotel(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.habitaciones = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        if (habitaciones.contains(habitacion)) {
            System.out.println("Error: La habitación ya existe.");
            return;
        }
        habitaciones.add(habitacion);
        System.out.println("Habitación " + habitacion.getTipo() + " agregada al hotel.");
    }

    public void listarHabitaciones() {
        System.out.println("--- Listado de Habitaciones ---");
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
            return;
        }
        for (Habitacion habitacion : habitaciones) {
            System.out.println("Número: " + habitacion.getNumero() +
                    " | Tipo: " + habitacion.getTipo() +
                    " | Precio: " + habitacion.getPrecio());
        }
    }

    public Habitacion buscarHabitacionPorNumero(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    // Métodos para gestionar empleados
    public void agregarEmpleado(Empleado empleado) {
        if (empleados.contains(empleado)) {
            System.out.println("Error: El empleado ya está registrado.");
            return;
        }
        empleados.add(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " agregado al hotel.");
    }

    public void listarEmpleados() {
        System.out.println("--- Listado de Empleados ---");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado empleado : empleados) {
            System.out.println("ID: " + empleado.getId() +
                    " | Nombre: " + empleado.getNombre() +
                    " | Puesto: " + empleado.getPuesto());
        }
    }

    public void agregarReserva(Reserva reserva) {
        if (reservas.contains(reserva)) {
            System.out.println("Error: La reserva ya existe.");
            return;
        }
        reservas.add(reserva);
        System.out.println("Reserva agregada para el cliente: " + reserva.getCliente().getNombre());
    }

    public void listarClientes() {
        System.out.println("--- Listado de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente cliente : clientes) {
            System.out.println("DNI: " + cliente.getDni() +
                    " | Nombre: " + cliente.getNombre() +
                    " | TelCliente: " + cliente.getTelCliente() +
                    " | Email: " + cliente.getEmail());
        }
    }

    public void listarReservas() {
        System.out.println("--- Listado de Reservas ---");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente().getNombre() +
                    " | Habitación: " + reserva.getHabitacion().getNumero() +
                    " | Fecha Inicio: " + sdf.format(reserva.getFechaInicio().getTime()) +
                    " | Fecha Fin: " + sdf.format(reserva.getFechaFin().getTime()));
        }
    }

    // Métodos para gestionar servicios adicionales
    public void agregarServicio(ServicioAdicional servicio) {
        if (servicios.contains(servicio)) {
            System.out.println("Error: El servicio ya existe.");
            return;
        }
        servicios.add(servicio);
        System.out.println("Servicio adicional " + servicio.getNombre() + " agregado.");
    }

    public void listarServicios() {
        System.out.println("--- Listado de Servicios Adicionales ---");
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios registrados.");
            return;
        }
        for (ServicioAdicional servicio : servicios) {
            System.out.println("ID: " + servicio.getId() +
                    " | Nombre: " + servicio.getNombre() +
                    " | Precio: " + servicio.getPrecio());
        }
    }

    public void generarInforme() {
        System.out.println("--- Informe General del Hotel ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Total de Habitaciones: " + habitaciones.size());
        System.out.println("Total de Empleados: " + empleados.size());
        System.out.println("Total de Reservas Activas: " + reservas.size());
        System.out.println("Total de Servicios Adicionales: " + servicios.size());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public ArrayList<ServicioAdicional> getServicios() {
        return servicios;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente agregado: " + cliente.getNombre());
    }

    public void eliminarCliente(String dni) {
        Cliente cliente = buscarClientePorDni(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente con DNI " + dni + " eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public Cliente buscarClientePorDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }
}
