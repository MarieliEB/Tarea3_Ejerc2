package TL;


import BL.*;
import DL.CL;

import java.time.LocalDate;
import java.util.ArrayList;

/** Clase controller del proyecto
 * @author  Elizabeth Espinoza
 * @version  1.0
 **/

public class Controller {

    CL logica = new CL();

    public boolean registrarCliente(int pCedula, String pNombre, String pDireccion){
        Cliente cliente = new Cliente(pCedula,pNombre,pDireccion);
        if(!clienteExiste(pCedula)){
            logica.registrarCliente(cliente);
            return true;
        }else{
            return false;
        }
    } // Fin registrar cliente

    public void registrarCuenta(int pCedula, LocalDate pFechaApertura, int tipo, String pDescripcionDeposito, double pCantidad){

        Cliente cliente = traerCliente(pCedula);

        if(tipo==1){
            int numCuenta = 1234567;
            Corriente corriente = new Corriente(numCuenta, pCantidad, pFechaApertura, cliente);
            Movimiento movimiento = new Movimiento(pFechaApertura, "Deposito", pCantidad, pDescripcionDeposito, corriente);
            cliente.addCuenta(corriente);
            logica.registrarCuentaCorriente(corriente);
            logica.registrarMovimiento(movimiento);
            corriente.addMovimiento(movimiento);
        }
        if (tipo==2){
            int numCuenta = logica.listaDeAhorros().size()+1;
            Ahorro ahorro = new Ahorro(numCuenta, pCantidad, pFechaApertura, cliente);
            cliente.addCuenta(ahorro);
            Movimiento movimiento = new Movimiento(pFechaApertura, "Deposito", pCantidad, pDescripcionDeposito, ahorro);
            logica.registrarCuentaAhorros(ahorro);
            logica.registrarMovimiento(movimiento);
            ahorro.addMovimiento(movimiento);
        }
        if (tipo==3){
            int numCuenta = logica.listaDeProgramados().size()+1;
            AhorroProgramado programado = new AhorroProgramado(numCuenta, pCantidad, pFechaApertura, cliente );
            Movimiento movimiento = new Movimiento(pFechaApertura, "Deposito", pCantidad, pDescripcionDeposito, programado);
            cliente.addCuenta(programado);
            logica.registrarCuentaProgramado(programado);
            logica.registrarMovimiento(movimiento);
            programado.addMovimiento(movimiento);
        }

    } // Fin de registrar cuenta

    public Cliente traerCliente(int pcedula){
        Cliente cliente = logica.traerCliente(pcedula);
        return cliente;
    }

/*    public Cuenta traerCuenta(int pNumCuenta){
        Cuenta cuenta = logica.traerCuenta(pNumCuenta);
        return cuenta;
    }*/

    public int poseeCuenta(int pCedula, int pTipo){
        int posee = -1;
        if(pTipo==1){
            posee = logica.poseeCuentasCorrientes(pCedula);
            return posee;
        }
        if(pTipo==2){
            posee = logica.poseeCuentasAhorro(pCedula);
            return posee;
        }
        if(pTipo==3){
            posee = logica.poseeCuentasAhorroProgramado(pCedula);
            return posee;
        }else {
            return posee;
        }
    }

    public String tipoCuenta(int tipo){ // Esta función sólo le pone nombre en String a las cuentas
        String cuenta;
        switch (tipo) {
            case 1:
                cuenta = "Corriente";
                return cuenta;
            case 2:
                cuenta = "Ahorros";
                return cuenta;
            case 3:
                cuenta = "Ahorro programado";
                return cuenta;
            default:
               break;
        }
        return "Error";
    } // Fin de tipo cuenta


    public boolean clienteExiste(int pCedula){
        boolean cliente = logica.clienteExiste(pCedula);
        return cliente;
    } // Fin de existe vendedor



    /********************************************
     *********** Funciones para listar **********
     ********************************************/

    public String[] listarClientes() {
        int i = 0;
        String[] listas;
        int size = logica.listaDeClientes().size();
        listas = new String[size];
        for (Cliente data : logica.listaDeClientes()) {
            listas[i] = data.toString();
            i++;
        }
        return listas;
    } // Fin listar clientes



    /************************************************
     *********** Funciones de movimientos **********
     ********************************************/

    public boolean depositarDinero(int pCedula, int pNumCuenta, double cantidad, String descripcion, LocalDate fechaDeposito){
        boolean depositoCorrecto = false;
        Cliente cliente = traerCliente(pCedula);
        ArrayList<Cuenta> cuentas;
        cuentas = cliente.getListaDeCuentas();
        int size = cliente.getListaDeCuentas().size();
        cuentas = cliente.getListaDeCuentas();


        for (int i = 0; i< size; i++) {
            if(pNumCuenta==cuentas.get(i).getNumCuenta()){
                cuentas.get(i).setSaldo(cantidad);
                Movimiento movimiento = new Movimiento(fechaDeposito,"Deposito", cantidad, descripcion);
                logica.registrarMovimiento(movimiento);
                depositoCorrecto = true;
            }
        }
        return depositoCorrecto;
    }







} // ***** FIN ***** //