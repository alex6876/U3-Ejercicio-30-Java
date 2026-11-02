public class Main {

    public static void main(String[] args) {

        TarjetaGold gold = new TarjetaGold(
                "1001", "Juan Perez", 100000
        );

        TarjetaBlack black = new TarjetaBlack(
                "2001", "Maria Lopez", 200000
        );

        System.out.println("===== TARJETA GOLD =====");

        gold.realizarCompra(20000);
        gold.realizarCompra(15000);
        gold.realizarCompra(80000);

        System.out.println("\n--- Estado de cuenta Gold ---");
        gold.mostrarEstadoCuenta();

        System.out.println("\nComisión por compra internacional: $"
                + gold.calcularComisionInternacional(10000));

        System.out.println("\n===== TARJETA BLACK =====");

        black.realizarCompra(50000);
        black.realizarCompra(30000);
        black.realizarCompra(150000);

        System.out.println("\n--- Estado de cuenta Black ---");
        black.mostrarEstadoCuenta();

        System.out.println("\nComisión por compra internacional: $"
                + black.calcularComisionInternacional(10000));
    }
}