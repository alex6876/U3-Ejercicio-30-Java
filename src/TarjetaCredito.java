public class TarjetaCredito {

    protected String numero;
    protected String titular;
    protected double limiteCredito;
    protected double saldoUtilizado;

    public TarjetaCredito(String numero, String titular, double limiteCredito) {
        this.numero = numero;
        this.titular = titular;
        this.limiteCredito = limiteCredito;
        this.saldoUtilizado = 0;
    }

    public boolean validarCompra(double monto) {
        return monto > 0 && (saldoUtilizado + monto) <= limiteCredito;
    }

    public void realizarCompra(double monto) {

        if (validarCompra(monto)) {

            saldoUtilizado += monto;

            System.out.println("Compra aprobada por: $" + monto);

        } else {

            System.out.println("Compra rechazada. Límite de crédito insuficiente.");
        }
    }

    public void mostrarEstadoCuenta() {

        System.out.println("Número: " + numero);
        System.out.println("Titular: " + titular);
        System.out.println("Límite de crédito: $" + limiteCredito);
        System.out.println("Saldo utilizado: $" + saldoUtilizado);
        System.out.println("Crédito disponible: $" + (limiteCredito - saldoUtilizado));
    }
}