package BL;

import java.time.LocalDate;

public class Movimiento {
    private LocalDate fecha;
    private String tipo;
    private double monto;
    private String descripcion;
    private Cuenta cuentaMovida;

    public Movimiento(LocalDate fecha, String tipo, double monto, String descripcion, Cuenta cuentaMovida) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.cuentaMovida = cuentaMovida;
    }

    public Movimiento(LocalDate fecha, String tipo, double monto, String descripcion) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cuenta getCuentaMovida() {
        return cuentaMovida;
    }

    public void setCuentaMovida(Cuenta cuentaMovida) {
        this.cuentaMovida = cuentaMovida;
    }

    @Override
    public String toString() {
        return "Movimiento: " + "\n" +
                "Fecha=" + fecha + "\n" +
                "Descripcion='" + descripcion + "\n" +
                "Monto=" + monto + "\n" +
                "Tipo='" + tipo + "\n" +
                "Cuenta asociada=" + cuentaMovida + "\n";
    }
}
