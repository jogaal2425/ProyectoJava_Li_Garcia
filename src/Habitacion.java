/**
 * Clase que representa una habitación en el hotel.
 * Implementa la interfaz Reservable para gestionar disponibilidad y reservas.
 */
public class Habitacion implements Reservable {
    private int numero;
    private TipoHabitacion tipo;
    private boolean disponible;
    private double precio;

    /**
     * Enum para los tipos de habitaciones disponibles.
     */
    public enum TipoHabitacion {
        INDIVIDUAL, DOBLE, SUITE
    }

    /**
     * Constructor de la clase Habitacion.
     * @param numero Número de la habitación.
     * @param tipo Tipo de habitación.
     * @param precio Precio por noche de la habitación.
     */
    // Constructor
    public Habitacion(int numero, TipoHabitacion tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = true;
    }

    /**
     * Verifica la disponibilidad de la habitación.
     * @return true si está disponible, false si está ocupada.
     */
    @Override
    public boolean disponibilidad() {
        return disponible;
    }

    /**
     * Reserva la habitación si está disponible.
     */
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

    /**
     * Obtiene el número de la habitación.
     * @return Número de la habitación.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la habitación.
     * @param numero Número de la habitación.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el tipo de habitación.
     * @return Tipo de habitación.
     */
    public TipoHabitacion getTipo() {
        return tipo;
    }
    /**
     * Establece el tipo de habitación.
     * @param tipo Tipo de habitación.
     */
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }
    /**
     * Obtiene el precio por noche de la habitación.
     * @return Precio por noche.
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Establece el precio por noche de la habitación.
     * @param precio Precio por noche.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Verifica si la habitación está disponible.
     * @return true si está disponible, false si no.
     */
    public boolean isDisponible() {
        return disponible;
    }
    /**
     * Establece la disponibilidad de la habitación.
     * @param disponible true si está disponible, false si no.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}