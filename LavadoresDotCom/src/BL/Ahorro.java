package BL;

import java.time.LocalDate;
import java.util.ArrayList;

/** Clase para la creacion de Ahorro extiende de Cuenta
 * @author  Elizabeth Espinoza
 * @version  1.0
 **/

public class Ahorro extends Cuenta {

    public Ahorro(int numCuenta, double saldo, LocalDate fechaApertura, Cliente propietario) {
        super(numCuenta, saldo, fechaApertura, propietario);
    }

    public Ahorro(Movimiento nuevoMovimiento) {
        super(nuevoMovimiento);
    }

    public Ahorro() {
    }
}
