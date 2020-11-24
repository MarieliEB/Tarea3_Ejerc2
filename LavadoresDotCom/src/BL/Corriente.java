package BL;

import java.time.LocalDate;

/** Clase para la creacion de cuenta Corriente extiende de Cuenta
 * @author  Elizabeth Espinoza
 * @version  1.0
 **/

public class Corriente extends Cuenta {

    public Corriente(int numCuenta, double saldo, LocalDate fechaApertura, Cliente propietario) {
        super(numCuenta, saldo, fechaApertura, propietario);
    }
    public Corriente(){

    }
}
