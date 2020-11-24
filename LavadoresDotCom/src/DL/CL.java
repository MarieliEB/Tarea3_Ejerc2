package DL;

import BL.*;
import BL.Ahorro;

import java.util.ArrayList;

/** Clase para el manejo de la logica del proyecto
 * @author  Elizabeth Espinoza
 * @version  1.0
 **/

public class CL {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Corriente> corrientes = new ArrayList<>();
    ArrayList<Ahorro> ahorros  = new ArrayList<>();
    ArrayList<AhorroProgramado> programados = new ArrayList<>();
    ArrayList<Movimiento> movimientos = new ArrayList<>();

    public void registrarCliente(Cliente cliente){clientes.add(cliente);}
    public void registrarCuentaCorriente(Corriente corriente){corrientes.add(corriente);}
    public void registrarCuentaAhorros(Ahorro ahorro){ahorros.add(ahorro);}
    public void registrarCuentaProgramado(AhorroProgramado ahorroProgramado){programados.add(ahorroProgramado);}
    public void registrarMovimiento(Movimiento movimiento){movimientos.add(movimiento);}



    public ArrayList<Cliente> listaDeClientes(){return clientes;}
    public ArrayList<Corriente> listaDeCorrientes(){return corrientes;}
    public ArrayList<Ahorro> listaDeAhorros(){return ahorros;}
    public ArrayList<AhorroProgramado> listaDeProgramados(){return programados;}

    public boolean clienteExiste(int pId){
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getid() == pId) {
                System.out.println(listaDeClientes().get(i));
               /* int id = listaDeClientes().get(i).getid();
                System.out.println("lista" + id);*/
                return true;
            }
            break;
        }
        return false;
    } // Fin de cliente existe

    public Cliente traerCliente(int pId){
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getid() == pId) {
                return clientes.get(i);
            }
        }
        return null;
    } // Fin de traer cliente

    public int poseeCuentasCorrientes(int pId){
        int cont=0;
        for (int i = 0; i < corrientes.size(); i++) {
            if (corrientes.get(i).getPropietario().getid() == pId) {
                cont++;
            }
        }
        return cont;
    } // Fin posee cuentas corrientes

    public int poseeCuentasAhorro(int pId){
        int cont=0;
        for (int i = 0; i < ahorros.size(); i++) {
            if (ahorros.get(i).getPropietario().getid() == pId) {
                cont++;
            }
        }
     return cont;
    } // Fin posee cuentas de ahorro

    public int poseeCuentasAhorroProgramado(int pId){
        int cont=0;
        for (int i = 0; i < programados.size(); i++) {
            if (programados.get(i).getPropietario().getid() == pId) {
                cont++;
            }
        }
        return cont;
    } // Fin posee cuentas de ahorro programado



} // ***** FIN *****
