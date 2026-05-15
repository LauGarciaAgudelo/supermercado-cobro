# Simulación de Cobro en un Supermercado

## Descripción del proyecto

Este proyecto consiste en una aplicación desarrollada en Java que simula el proceso de cobro en un supermercado utilizando programación concurrente y multihilos.

La aplicación permite crear múltiples clientes y cajeras trabajando simultáneamente, simulando el procesamiento de compras en tiempo real.

El objetivo principal es aplicar los conceptos de concurrencia vistos en el curso de Desarrollo de Software Seguro, utilizando `Runnable`, `ExecutorService` y manejo de hilos en Java.

---

# Funcionalidades implementadas

## Gestión de productos

Cada producto contiene:

* Nombre
* Precio
* Tiempo de procesamiento

## Gestión de clientes

Cada cliente posee:

* Nombre
* Lista de productos
* Cálculo automático del valor total de la compra

## Gestión de cajeras

Cada cajera:

* Procesa clientes concurrentemente
* Simula el tiempo de cobro de cada producto
* Muestra información detallada del proceso
* Calcula el tiempo total de atención

## Concurrencia

La aplicación utiliza:

* `Runnable`
* `ExecutorService`
* `Thread.sleep()`
* Pool de hilos (`FixedThreadPool`)

Esto permite ejecutar múltiples procesos de cobro al mismo tiempo.

## Registro de tiempo

La simulación incluye timestamps en consola para evidenciar el procesamiento concurrente de las cajeras.

---

# Estructura del proyecto

```text
supermercado-cobro/
 └── src/
     └── supermercado/
         ├── Main.java
         ├── Producto.java
         ├── ClienteProducto.java
         └── Cajera.java
```

---

# Explicación de clases

## Producto.java

Representa un producto del supermercado.

Atributos:

* nombre
* precio
* tiempoProcesamiento

Responsabilidades:

* Almacenar información de cada producto
* Retornar datos mediante getters

---

## ClienteProducto.java

Representa un cliente con una lista de productos.

Responsabilidades:

* Gestionar productos comprados
* Calcular el total de la compra

---

## Cajera.java

Representa una cajera del supermercado.

Responsabilidades:

* Implementar `Runnable`
* Procesar productos
* Simular tiempos de cobro
* Mostrar timestamps
* Calcular tiempos de atención

---

## Main.java

Clase principal de la aplicación.

Responsabilidades:

* Crear clientes
* Crear productos
* Configurar cajeras
* Ejecutar concurrencia mediante `ExecutorService`
* Mostrar resumen general de la simulación

---

# Tecnologías utilizadas

* Java
* Visual Studio Code
* Git
* GitHub

---

# Conceptos aplicados

* Programación orientada a objetos
* Concurrencia
* Multihilos
* Runnable
* ExecutorService
* Manejo de excepciones
* Buenas prácticas de programación
* Simulación de procesos concurrentes

---

# Cómo ejecutar el proyecto

## Compilar

```bash
javac -d out src/supermercado/Main.java src/supermercado/Producto.java src/supermercado/ClienteProducto.java src/supermercado/Cajera.java
```

## Ejecutar

```bash
java -cp out supermercado.Main
```

---

# Ejemplo de salida

```text
[10:21:01] Cajera 1 procesando producto: Arroz
[10:21:01] Cajera 2 procesando producto: Pan
[10:21:02] Cajera 3 procesando producto: Shampoo
```

Esto demuestra la ejecución concurrente de múltiples cajeras.

---

# Evidencias solicitadas

## Repositorio Git

El proyecto se encuentra versionado utilizando Git y almacenado en GitHub.

## Video explicativo

El video muestra:

* Explicación del código
* Funcionamiento de la concurrencia
* Ejecución de la simulación
* Explicación de clases y responsabilidades

---

# Conclusiones

* La programación concurrente permite ejecutar múltiples procesos de manera simultánea.
* ExecutorService facilita la administración eficiente de hilos.
* Java proporciona herramientas robustas para implementar concurrencia de forma segura.
* El proyecto permitió aplicar conceptos de orientación a objetos, concurrencia y manejo de excepciones.
* La simulación representa un escenario realista del proceso de cobro en supermercados.

---

# Autor

Laura Vanessa García Agudelo 

Tecnología en Desarrollo de Software

IUDigital de Antioquia
