public class Habitacion {
    private int numero;
    private String tipo;
    private String estado;

    // Constructor
    public Habitacion(int numero, String tipo, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}