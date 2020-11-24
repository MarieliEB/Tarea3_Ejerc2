package BL;

import java.time.LocalDate;

/** Clase para la creacion de AhorroProgramado extiende de Cuenta
 * @author  Elizabeth Espinoza
 * @version  1.0
 **/

public class AhorroProgramado extends Cuenta {

    public AhorroProgramado(int numCuenta, double saldo, LocalDate fechaApertura, Cliente propietario) {
        super(numCuenta, saldo, fechaApertura, propietario);
    }

    public AhorroProgramado() {
    }
}
