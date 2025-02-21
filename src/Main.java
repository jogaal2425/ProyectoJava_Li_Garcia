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
            scanner.nextLine();

            switch (opcion) {
                case 1: // Registrar Cliente
                    System.out.println("Selecciona el tipo de cliente (1. Particular, 2. Empresa): ");
                    int tipoCliente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduce DNI del cliente: ");
                    String dni = scanner.nextLine();
                    System.out.print("Introduce nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce telefono del cliente: ");
                    int telCliente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduce email del cliente: ");
                    String email = scanner.nextLine();

                    if (tipoCliente == 1) {
                        hotel.agregarCliente(new ClienteParticular(dni, nombre, telCliente, email));
                    } else if (tipoCliente == 2) {
                        hotel.agregarCliente(new ClienteEmpresa(dni, nombre, telCliente, email));
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 2: // Gestionar Habitaciones
                    System.out.println("1. Agregar habitación\n2. Listar habitaciones\n3. Volver atrás");
                    int subOpcion = scanner.nextInt();
                    scanner.nextLine();

                    if (subOpcion == 1) {
                        System.out.print("Introduce el número de habitación: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Selecciona el tipo de habitación: 1. Individual | 2. Doble | 3. Suite");
                        int tipo = scanner.nextInt();
                        System.out.print("Introduce el precio de la habitación: ");
                        double precio = scanner.nextDouble();

                        Habitacion.TipoHabitacion tipoHabitacion = null;
                        switch (tipo) {
                            case 1:
                                tipoHabitacion = Habitacion.TipoHabitacion.INDIVIDUAL;
                                break;
                            case 2:
                                tipoHabitacion = Habitacion.TipoHabitacion.DOBLE;
                                break;
                            case 3:
                                tipoHabitacion = Habitacion.TipoHabitacion.SUITE;
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }

                        if (tipoHabitacion != null) {
                            hotel.agregarHabitacion(new Habitacion(numero, tipoHabitacion, precio));
                        }
                    } else if (subOpcion == 2) {
                        hotel.listarHabitaciones();
                    } else if (subOpcion == 3) {
                        System.out.println("Volviendo al menú principal...");
                        break;
                    }else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 3: // Reservar Habitaciones
                    hotel.listarHabitaciones();
                    System.out.print("Introduce el número de la habitación a reservar: ");
                    int numeroHabitacion = scanner.nextInt();
                    scanner.nextLine();
                    Habitacion habitacionReserva = hotel.buscarHabitacionPorNumero(numeroHabitacion);

                    if (habitacionReserva != null && habitacionReserva.disponibilidad()) {
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
                                habitacionReserva.reservar();

                                System.out.println("¿Desea agregar un servicio adicional? (1. Sí | 2. No)");
                                int opcionServicio = scanner.nextInt();
                                scanner.nextLine();

                                if (opcionServicio == 1) {
                                    hotel.listarServicios();
                                    System.out.print("Seleccione el ID del servicio a agregar: ");
                                    int servicioSeleccionado = scanner.nextInt();
                                    scanner.nextLine();

                                    if (servicioSeleccionado > 0 && servicioSeleccionado <= hotel.getServicios().size()) {
                                        ServicioAdicional servicio = hotel.getServicios().get(servicioSeleccionado - 1);
                                        clienteReserva.solicitarServicio(servicio);
                                    } else {
                                        System.out.println("Opción de servicio no válida.");
                                    }
                                }
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

                case 4:
                    hotel.generarInforme();
                    break;

                case 5:
                    hotel.listarClientes();
                    System.out.println("¿Quieres eliminar un cliente? (1. Sí | 2. No)");
                    int opcionEliminar = scanner.nextInt();
                    scanner.nextLine();
                    if (opcionEliminar == 1) {
                        System.out.print("Introduce el DNI del cliente a eliminar: ");
                        String dniEliminar = scanner.nextLine();
                        hotel.eliminarCliente(dniEliminar);
                    }
                    break;

                case 6:
                    System.out.println("1. Agregar empleado\n2. Listar empleados\n3. Volver atrás");
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
                    } else if (subOpcionEmp == 3) {
                        System.out.println("Volviendo al menú principal...");
                        break;
                    }else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 7:
                    System.out.println("1. Agregar servicio\n2. Listar servicios\n3. Volver atrás");
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
                    } else if (subOpcionServ == 3) {
                        System.out.println("Volviendo al menú principal...");
                        break;
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