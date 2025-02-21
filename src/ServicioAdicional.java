public class ServicioAdicional {
    private static int contadorId = 1;  // Contador estático para generar IDs únicos
    private int id;  // Campo para almacenar el ID del servicio
    private String nombre;
    private double precio;

    // Constructor
    public ServicioAdicional(String nombre, double precio) {
        this.id = contadorId++;  // Asignar el ID y luego incrementar el contador
        this.nombre = nombre;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}