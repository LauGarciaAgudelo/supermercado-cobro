package supermercado;

/**
 * Clase que representa un producto comprado por un cliente.
 */
public class Producto {
    private String nombre;
    private double precio;
    private int tiempoProcesamiento;

    public Producto(String nombre, double precio, int tiempoProcesamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoProcesamiento = tiempoProcesamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

    @Override
    public String toString() {
        return nombre + " - Precio: $" + precio + " - Tiempo: " + tiempoProcesamiento + " segundos";
    }
}