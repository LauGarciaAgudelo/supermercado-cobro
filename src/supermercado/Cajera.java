package supermercado;

/**
 * Clase que representa a una cajera que procesa la compra de un cliente.
 */
public class Cajera implements Runnable {

    private String nombre;
    private ClienteProducto cliente;
    private long tiempoTotalCobro;

    public Cajera(String nombre, ClienteProducto cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("\n" + nombre + " inicia el cobro del cliente: " + cliente.getNombre());

        long tiempoInicio = System.currentTimeMillis();

        for (Producto producto : cliente.getProductos()) {
            procesarProducto(producto);
        }

        long tiempoFin = System.currentTimeMillis();
        tiempoTotalCobro = tiempoFin - tiempoInicio;

        System.out.println(nombre + " finalizó el cobro de " + cliente.getNombre());
        System.out.println("Total compra: $" + cliente.calcularTotalCompra());
        System.out.println("Tiempo total de cobro: " + tiempoTotalCobro / 1000.0 + " segundos");
    }

    private void procesarProducto(Producto producto) {
        try {
            System.out.println(
                    nombre + " procesando producto: " + producto.getNombre()
                            + " | Precio: $" + producto.getPrecio()
                            + " | Tiempo: " + producto.getTiempoProcesamiento() + " segundos"
            );

            Thread.sleep(producto.getTiempoProcesamiento() * 1000L);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error: el proceso de cobro fue interrumpido.");
        }
    }

    public long getTiempoTotalCobro() {
        return tiempoTotalCobro;
    }
}