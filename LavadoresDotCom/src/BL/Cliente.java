package BL;

import java.util.ArrayList;

/** Clase para la creacion de Clientes
 * @author  Elizabeth Espinoza
 * @version  1.0
 **/

public class Cliente {

    private int id;
    private String nombre;
    private String direccion;
    private ArrayList<Cuenta> listaDeCuentas = new ArrayList<>();

    public Cliente(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaDeCuentas = new ArrayList<>();
    }

    public Cliente(Cuenta nuevaCuenta){
        this.listaDeCuentas.add(nuevaCuenta);
    }

    public Cliente(){

    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cuenta> getListaDeCuentas() {
        return listaDeCuentas;
    }

    public void setListaDeCuentas(ArrayList<Cuenta> listaDeCuentas) {
        this.listaDeCuentas = listaDeCuentas;
    }

    public void addCuenta(Cuenta cuenta) {this.listaDeCuentas.add(cuenta);}

    @Override
    public String toString() {
        String infoCliente= "";
        infoCliente +=  "Cliente: " + "\n" +
                        "Id= " + id + "\n" +
                        "Nombre= " + nombre +  "\n" +
                        "Direccion= " + direccion + "\n";
        infoCliente +=  "******Lista de cuentas****** \n";
        if(listaDeCuentas.size() == 0){
            infoCliente += "No posee cuentas  \n";
        }else {
            infoCliente +=  listaCuentasToString () + "\n";
        }

        return infoCliente;
    }

    public String listaCuentasToString(){
        String infoCuenta= "";
        for (Cuenta cuenta: listaDeCuentas) {
            infoCuenta += cuenta.toString () + "\n";
        }
        return infoCuenta;
    }
}
