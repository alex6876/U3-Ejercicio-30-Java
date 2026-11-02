Aquí tienes la estructura en formato Markdown lista para el `README.md` de este código de **Simulación de Sistema de Tarjetas de Crédito y Beneficios (Herencia, Sobrescritura y Polimorfismo en Java)**, manteniendo el enfoque exclusivo de **Programación Orientada a Objetos en memoria** (sin bases de datos):

---

# 💳 Simulación de Sistema de Tarjetas de Crédito y Beneficios (Herencia y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema financiero de tarjetas de crédito, implementando una jerarquía de clases mediante herencia para administrar distintos niveles de membresía (tarjetas estándar, Gold y Black) con reglas especializadas para acumulación de millas, comisiones internacionales y seguros de viaje. Pone en práctica conceptos fundamentales de la **Programación Orientada a Objetos (POO)** como la **generalización de atributos protegidos (`protected`)**, la reutilización de constructores mediante `super`, la sobrescritura polimórfica de métodos (`@Override`) y la gestión de transacciones financieras en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base general, sus respectivas subclases especializadas y un punto de ejecución:

* **`TarjetaCredito`**: Clase base que centraliza los atributos y comportamientos comunes de cualquier tarjeta de crédito del sistema.
* **Atributos protegidos (`protected`)**: `numero`, `titular`, `limiteCredito` y `saldoUtilizado`, permitiendo que las clases hijas accedan directamente a la información esencial de la cuenta.
* **Constructor**: Inicializa los datos comunes de la tarjeta y establece el saldo utilizado inicial en cero (`0`).
* **Métodos operativos**:
* `validarCompra(double monto)`: Verifica que el monto sea positivo y que la suma del saldo actual con la nueva compra no supere el límite de crédito autorizado.
* `realizarCompra(double monto)`: Ejecuta la validación, actualiza el saldo utilizado e informa el resultado de la transacción por consola.
* `mostrarEstadoCuenta()`: Imprime de forma detallada el número, titular, límite, saldo utilizado y crédito disponible.




* **`TarjetaGold`**: Extiende de `TarjetaCredito` para modelar tarjetas de categoría intermedia con acumulación de millas y comisiones preferenciales.
* **Atributos privados (`private`)**: `tasaBonificacion` (2%), `comisionInternacional` (3%) y `millasAcumuladas`.
* **Constructor**: Utiliza `super(...)` para inicializar los datos heredados y configura las tasas específicas de la categoría.
* **Sobrescritura (`@Override`)**:
* `realizarCompra(double monto)`: Adapta el comportamiento para acumular millas en función del monto adquirido y la tasa de bonificación, imprimiendo las notificaciones correspondientes.
* `mostrarEstadoCuenta()`: Extiende la visualización mediante `super.mostrarEstadoCuenta()` para agregar la categoría, millas acumuladas y porcentaje de comisión internacional.


* **Método específico**: `calcularComisionInternacional(double monto)` para computar el recargo aplicable en compras al exterior.


* **`TarjetaBlack`**: Extiende de `TarjetaCredito` para modelar tarjetas de alta gama con máxima bonificación de millas, menor comisión internacional y cobertura de seguro de viaje.
* **Atributos privados (`private`)**: `tasaBonificacion` (5%), `comisionInternacional` (1%), `millasAcumuladas` y `seguroViaje` (`true`).
* **Constructor**: Utiliza `super(...)` para configurar los parámetros base y asigna los beneficios exclusivos de la categoría Black.
* **Sobrescritura (`@Override`)**:
* `realizarCompra(double monto)`: Registra la transacción aplicando la tasa de bonificación superior para la acumulación de millas.
* `mostrarEstadoCuenta()`: Reutiliza `super` e incorpora al reporte el estado de la categoría, las millas obtenidas, la comisión internacional reducida y la disponibilidad del seguro de viaje.


* **Método específico**: `calcularComisionInternacional(double monto)` para calcular el recargo preferencial en transacciones internacionales.


* **`Main`**: Punto de entrada del programa. Instancia una tarjeta Gold y una tarjeta Black con sus respectivos límites, simula operaciones de compra exitosas y rechazadas por superar el tope de crédito, consulta comisiones internacionales y genera los estados de cuenta finales por consola.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Validación de Límites de Crédito:** Ninguna tarjeta permite procesar compras que excedan el límite de crédito máximo autorizado, protegiendo la solvencia de la cuenta.
2. **Polimorfismo en Beneficios y Recompensas:** Las subclases sobrescriben el comportamiento de compra para recompensar al usuario con diferentes tasas de acumulación de millas (2% para Gold vs. 5% para Black).
3. **Reutilización Estructural con `super`:** Las tarjetas especializadas delegan la impresión de los datos financieros básicos a la clase base, enriqueciendo el reporte final con sus atributos particulares.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== TARJETA GOLD =====
Compra Gold aprobada.
Millas acumuladas: 400.0
Compra Gold aprobada.
Millas acumuladas: 300.0
Compra Gold rechazada.

--- Estado de cuenta Gold ---
Número: 1001
Titular: Juan Perez
Límite de crédito: $100000.0
Saldo utilizado: $35000.0
Crédito disponible: $65000.0
Categoría: GOLD
Millas acumuladas: 700.0
Comisión internacional: 3.0%

Comisión por compra internacional: $300.0

===== TARJETA BLACK =====
Compra Black aprobada.
Millas acumuladas: 2500.0
Compra Black aprobada.
Millas acumuladas: 1500.0
Compra Black rechazada.

--- Estado de cuenta Black ---
Número: 2001
Titular: Maria Lopez
Límite de crédito: $200000.0
Saldo utilizado: $80000.0
Crédito disponible: $120000.0
Categoría: BLACK
Millas acumuladas: 4000.0
Comisión internacional: 1.0%
Seguro de viaje: Incluido

Comisión por compra internacional: $100.0

```

---

## 🚀 Conceptos de Programación Aplicados

* **Jerarquía Financiera:** Modelado de productos bancarios mediante una arquitectura limpia de herencia (`TarjetaCredito` como superclase de `TarjetaGold` y `TarjetaBlack`).
* **Sobrescritura de Métodos (`@Override`):** Implementación de reglas de negocio diferenciadas para la ejecución de compras y la presentación de estados de cuenta según el nivel de membresía.
* **Diseño Modular:** Clara separación entre la lógica del dominio financiero y la ejecución de casos de prueba simulados en el cliente (`Main`).
