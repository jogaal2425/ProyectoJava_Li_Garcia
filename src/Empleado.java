/**
 * Clase que representa a un empleado del hotel.
 */
public class Empleado {
    private int id;
    private String nombre;
    private String puesto;

    /**
     * Constructor de la clase Empleado.
     * @param id Identificación del empleado.
     * @param nombre Nombre del empleado.
     * @param puesto Puesto que ocupa en el hotel.
     */

    // Constructor
    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
