public class TarjetaGold extends TarjetaCredito {

    private double tasaBonificacion;
    private double comisionInternacional;
    private double millasAcumuladas;

    public TarjetaGold(String numero, String titular, double limiteCredito) {

        super(numero, titular, limiteCredito);

        this.tasaBonificacion = 0.02;
        this.comisionInternacional = 0.03;
        this.millasAcumuladas = 0;
    }

    @Override
    public boolean validarCompra(double monto) {

        return monto > 0 && (saldoUtilizado + monto) <= limiteCredito;
    }

    @Override
    public void realizarCompra(double monto) {

        if (validarCompra(monto)) {

            saldoUtilizado += monto;

            millasAcumuladas += monto * tasaBonificacion;

            System.out.println("Compra Gold aprobada.");
            System.out.println("Millas acumuladas: " + monto * tasaBonificacion);

        } else {

            System.out.println("Compra Gold rechazada.");
        }
    }

    public double calcularComisionInternacional(double monto) {

        return monto * comisionInternacional;
    }

    @Override
    public void mostrarEstadoCuenta() {

        super.mostrarEstadoCuenta();

        System.out.println("Categoría: GOLD");
        System.out.println("Millas acumuladas: " + millasAcumuladas);
        System.out.println("Comisión internacional: " + (comisionInternacional * 100) + "%");
    }
}