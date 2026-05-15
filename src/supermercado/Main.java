package supermercado;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        long tiempoInicioGeneral = System.currentTimeMillis();

        List<ClienteProducto> clientes = Arrays.asList(
                new ClienteProducto("Cliente 1", Arrays.asList(
                        new Producto("Arroz", 4500, 2),
                        new Producto("Leche", 3800, 1),
                        new Producto("Huevos", 15000, 3)
                )),
                new ClienteProducto("Cliente 2", Arrays.asList(
                        new Producto("Pan", 3000, 1),
                        new Producto("Queso", 12000, 2),
                        new Producto("Cafe", 18000, 2)
                )),
                new ClienteProducto("Cliente 3", Arrays.asList(
                        new Producto("Aceite", 14000, 2),
                        new Producto("Azucar", 5200, 1),
                        new Producto("Sal", 2500, 1),
                        new Producto("Pasta", 4300, 2)
                )),
                new ClienteProducto("Cliente 4", Arrays.asList(
                        new Producto("Pollo", 28000, 3),
                        new Producto("Papa", 7000, 2),
                        new Producto("Tomate", 6000, 1)
                )),
                new ClienteProducto("Cliente 5", Arrays.asList(
                        new Producto("Jabon", 8500, 1),
                        new Producto("Shampoo", 22000, 2),
                        new Producto("Crema dental", 9500, 1),
                        new Producto("Papel higienico", 18000, 2)
                )),
                new ClienteProducto("Cliente 6", Arrays.asList(
                        new Producto("Carne", 35000, 4),
                        new Producto("Yogurt", 7800, 2),
                        new Producto("Cereal", 16500, 2)
                )),
                new ClienteProducto("Cliente 7", Arrays.asList(
                        new Producto("Galletas", 6200, 1),
                        new Producto("Mantequilla", 9500, 2),
                        new Producto("Jugo", 7200, 1)
                )),
                new ClienteProducto("Cliente 8", Arrays.asList(
                        new Producto("Detergente", 26000, 3),
                        new Producto("Suavizante", 19000, 2),
                        new Producto("Esponja", 3500, 1)
                ))
        );

        int totalCajeras = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(totalCajeras);

        for (int i = 0; i < clientes.size(); i++) {
            String nombreCajera = "Cajera " + ((i % totalCajeras) + 1);
            Cajera cajera = new Cajera(nombreCajera, clientes.get(i));
            executorService.execute(cajera);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error: la simulacion fue interrumpida.");
        }

        long tiempoFinGeneral = System.currentTimeMillis();
        long tiempoTotalGeneral = tiempoFinGeneral - tiempoInicioGeneral;

        System.out.println("\n=================================");
        System.out.println("RESUMEN GENERAL DE LA SIMULACION");
        System.out.println("Clientes atendidos: " + clientes.size());
        System.out.println("Cajeras disponibles: " + totalCajeras);
        System.out.println("Tiempo total de todas las compras: "
                + tiempoTotalGeneral / 1000.0 + " segundos");
        System.out.println("=================================");
    }
}