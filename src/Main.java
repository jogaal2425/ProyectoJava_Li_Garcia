import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("JoLi Hotel", "Calle Principal 123", "123456789");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        do {
            System.out.println("\n--- Menú de Gestión del Hotel ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Gestionar Habitaciones");
            System.out.println("3. Reservar Habitaciones");
            System.out.println("4. Generar Informe");
            System.out.println("5. Ver Clientes Registrados");
            System.out.println("6. Gestionar Empleados");
            System.out.println("7. Gestionar Servicios Adicionales");
            System.out.println("8. Listar Reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1: // Registrar Cliente
                    System.out.println("Selecciona el tipo de cliente (1. Particular, 2. Empresa): ");
                    int tipoCliente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduce DNI del cliente: ");
                    String dni = scanner.nextLine();
                    System.out.print("Introduce nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce email del cliente: ");
                    String email = scanner.nextLine();

                    if (tipoCliente == 1) {
                        hotel.agregarCliente(new ClienteParticular(dni, nombre, email));
                    } else if (tipoCliente == 2) {
                        hotel.agregarCliente(new ClienteEmpresa(dni, nombre, email));
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 2: // Gestionar Habitaciones
                    System.out.println("1. Agregar habitación\n2. Listar habitaciones");
                    int subOpcion = scanner.nextInt();
                    scanner.nextLine();

                    if (subOpcion == 1) {
                        System.out.print("Introduce el número de habitación: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Introduce el tipo de habitación: ");
                        String tipoHabitacion = scanner.nextLine();
                        System.out.print("Introduce el estado de la habitación: ");
                        String estadoHabitacion = scanner.nextLine();

                        hotel.agregarHabitacion(new Habitacion(numero, tipoHabitacion, estadoHabitacion));
                    } else if (subOpcion == 2) {
                        hotel.listarHabitaciones();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 3: // Reservar Habitaciones
                    hotel.listarHabitaciones();
                    System.out.print("Introduce el número de la habitación a reservar: ");
                    int numeroHabitacion = scanner.nextInt();
                    scanner.nextLine();
                    Habitacion habitacionReserva = hotel.buscarHabitacionPorNumero(numeroHabitacion);

                    if (habitacionReserva != null) {
                        System.out.print("Introduce el DNI del cliente: ");
                        String dniCliente = scanner.nextLine();
                        Cliente clienteReserva = hotel.buscarClientePorDni(dniCliente);

                        if (clienteReserva != null) {
                            System.out.print("Introduce la fecha de inicio (dd/mm/yyyy): ");
                            String fechaInicio = scanner.nextLine();
                            System.out.print("Introduce la fecha de fin (dd/mm/yyyy): ");
                            String fechaFin = scanner.nextLine();

                            try {
                                Calendar fechaInicioCal = Calendar.getInstance();
                                Calendar fechaFinCal = Calendar.getInstance();
                                fechaInicioCal.setTime(sdf.parse(fechaInicio));
                                fechaFinCal.setTime(sdf.parse(fechaFin));

                                hotel.agregarReserva(new Reserva(clienteReserva, habitacionReserva, fechaInicioCal, fechaFinCal));
                            } catch (ParseException e) {
                                System.out.println("Error al parsear las fechas.");
                            }
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                    } else {
                        System.out.println("Habitación no encontrada.");
                    }
                    break;

                case 4: // Generar Informe
                    hotel.generarInforme();
                    break;

                case 5: // Ver Clientes Registrados
                    hotel.listarClientes();
                    break;

                case 6: // Gestionar Empleados
                    System.out.println("1. Agregar empleado\n2. Listar empleados");
                    int subOpcionEmp = scanner.nextInt();
                    scanner.nextLine();

                    if (subOpcionEmp == 1) {
                        System.out.print("Introduce el ID del empleado: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Introduce el nombre del empleado: ");
                        String nombreEmp = scanner.nextLine();
                        System.out.print("Introduce el puesto del empleado: ");
                        String puesto = scanner.nextLine();

                        hotel.agregarEmpleado(new Empleado(id, nombreEmp, puesto));
                    } else if (subOpcionEmp == 2) {
                        hotel.listarEmpleados();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 7: // Gestionar Servicios Adicionales
                    System.out.println("1. Agregar servicio\n2. Listar servicios");
                    int subOpcionServ = scanner.nextInt();
                    scanner.nextLine();

                    if (subOpcionServ == 1) {
                        System.out.print("Introduce el nombre del servicio: ");
                        String nombreServ = scanner.nextLine();
                        System.out.print("Introduce el precio del servicio: ");
                        double precio = scanner.nextDouble();

                        hotel.agregarServicio(new ServicioAdicional(nombreServ, precio));
                    } else if (subOpcionServ == 2) {
                        hotel.listarServicios();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 8:
                    hotel.listarReservas();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}