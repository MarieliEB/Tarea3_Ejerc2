package BL;

import java.time.LocalDate;
import java.util.ArrayList;

/** Clase para la creacion de cuentas
 * @author  Elizabeth Espinoza
 * @version  1.0
 **/

public class Cuenta {

    private int numCuenta;
    private  double saldo;
    private LocalDate fechaApertura;
    private Cliente propietario;
    private ArrayList<Movimiento> listaDeMovimientos = new ArrayList<>();

    public Cuenta(int numCuenta, double saldo, LocalDate fechaApertura, Cliente propietario) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.propietario = propietario;
        this.listaDeMovimientos = new ArrayList<>();
    }

    public Cuenta(Movimiento nuevoMovimiento){
        listaDeMovimientos.add(nuevoMovimiento);
    }

    public Cuenta(){

    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public ArrayList<Movimiento> getListaDeMovimientos() {
        return listaDeMovimientos;
    }

    public void setListaDeMovimientos(ArrayList<Movimiento> listaDeMovimientos) {
        this.listaDeMovimientos = listaDeMovimientos;
    }

    public void addMovimiento(Movimiento movimiento) { this.listaDeMovimientos.add(movimiento); }

    @Override
    public String toString() {
        String infoCuenta= "";

        infoCuenta +=   "Cuenta: " + "\n" +
                        "Numero de cuenta= " + numCuenta + "\n" +
                        "Saldo= " + saldo+ "\n" +
                        "Fecha de apertura= " + fechaApertura + "\n" +
                        "Propietario= " + propietario + "\n";
        infoCuenta +=   "******Lista de movimientos****** \n";

        if(listaDeMovimientos.size() == 0){
            System.out.println("No hay movimientos asociados \n");
        }else{
            infoCuenta +=  listaMovimientosToString () + "\n";
        }
        return infoCuenta;
    }

    public String listaMovimientosToString(){
        String infoMovimiento= "";
        for (Movimiento mov: listaDeMovimientos) {
            infoMovimiento += mov.toString () + "\n";
        }
        return infoMovimiento;
    }
}
