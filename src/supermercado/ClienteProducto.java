package supermercado;

import java.util.List;

/**
 * Clase que representa un cliente con un carrito de compras.
 */
public class ClienteProducto {

    private final String nombre;
    private final List<Producto> productos;

    public ClienteProducto(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Calcula el valor total de la compra.
     */
    public double calcularTotalCompra() {
        double total = 0;

        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        return total;
    }
}