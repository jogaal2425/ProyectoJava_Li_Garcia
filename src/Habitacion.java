public class Habitacion implements Reservable {
    private int numero;
    private TipoHabitacion tipo;
    private boolean disponible;
    private double precio;

    public enum TipoHabitacion {
        INDIVIDUAL, DOBLE, SUITE
    }
    // Constructor
    public Habitacion(int numero, TipoHabitacion tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = true;
    }

    @Override
    public boolean disponibilidad() {
        return disponible;
    }

    @Override
    public void reservar() {
        if (disponible) {
            disponible = false;
            System.out.println("Habitación " + numero + " reservada.");
        } else {
            System.out.println("La habitación " + numero + " ya está ocupada.");
        }
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}