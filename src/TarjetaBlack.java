public class TarjetaBlack extends TarjetaCredito {

    private double tasaBonificacion;
    private double comisionInternacional;
    private double millasAcumuladas;
    private boolean seguroViaje;

    public TarjetaBlack(String numero, String titular, double limiteCredito) {

        super(numero, titular, limiteCredito);

        this.tasaBonificacion = 0.05;
        this.comisionInternacional = 0.01;
        this.millasAcumuladas = 0;
        this.seguroViaje = true;
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

            System.out.println("Compra Black aprobada.");
            System.out.println("Millas acumuladas: " + monto * tasaBonificacion);

        } else {

            System.out.println("Compra Black rechazada.");
        }
    }

    public double calcularComisionInternacional(double monto) {

        return monto * comisionInternacional;
    }

    @Override
    public void mostrarEstadoCuenta() {

        super.mostrarEstadoCuenta();

        System.out.println("Categoría: BLACK");
        System.out.println("Millas acumuladas: " + millasAcumuladas);
        System.out.println("Comisión internacional: " + (comisionInternacional * 100) + "%");
        System.out.println("Seguro de viaje: " + (seguroViaje ? "Incluido" : "No incluido"));
    }
}