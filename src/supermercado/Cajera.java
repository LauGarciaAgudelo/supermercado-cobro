package supermercado;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a cashier that processes a customer's purchase.
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

        String horaInicio = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("\n[" + horaInicio + "] "
                + nombre
                + " inicia el cobro del cliente: "
                + cliente.getNombre());

        long tiempoInicio = System.currentTimeMillis();

        for (Producto producto : cliente.getProductos()) {
            procesarProducto(producto);
        }

        long tiempoFin = System.currentTimeMillis();
        tiempoTotalCobro = tiempoFin - tiempoInicio;

        String horaFin = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("\n[" + horaFin + "] "
                + nombre
                + " finalizó el cobro de "
                + cliente.getNombre());

        System.out.println(nombre
                + " total compra: $"
                + cliente.calcularTotalCompra());

        System.out.println(nombre
                + " tiempo total de cobro: "
                + tiempoTotalCobro / 1000.0
                + " segundos");
    }

    private void procesarProducto(Producto producto) {

        try {

            String horaActual = LocalTime.now()
                    .format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            System.out.println(
                    "[" + horaActual + "] "
                            + nombre
                            + " procesando producto: "
                            + producto.getNombre()
                            + " | Precio: $"
                            + producto.getPrecio()
                            + " | Tiempo: "
                            + producto.getTiempoProcesamiento()
                            + " segundos"
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