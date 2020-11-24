package UI;

import TL.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Controller ctrl = new Controller();

    public static void main(String[] args)
            throws java.io.IOException {
        mostrarMenu();
    }

    public static void mostrarMenu() throws IOException {
        int opcion;
        opcion = -1;
        do {
            out.println("1. Registrar nuevo cliente");
            out.println("2. Listar clientes");
            out.println("3. Crear cuenta");
            out.println("0. Salir");
            out.println("Digite la opión que desee ");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    public static void procesarOpcion(int pOpcion)
            throws java.io.IOException {
        switch (pOpcion) {

            case 1:
                registrarNuevoCliente();
                break;
            case 2:
                listarClientes();
                break;
            case 3:
                crearCuenta();
                break;
            case 0:
                out.println("Adiós");
                break;
            default:
                out.println("Opción inválida");
        }
    }

    public static void registrarNuevoCliente()
        throws java.io.IOException{

        out.println("Digite la identificación del cliente");
        int id = Integer.parseInt(in.readLine());
        System.out.println("Digite el nombre y apellido del cliente");
        String nombre = in.readLine();
        System.out.println("Digite la dirección del cliente");
        String direccion = in.readLine();

        boolean registro = ctrl.registrarCliente(id, nombre, direccion);

        if(registro){
            System.out.println("Usuario registrado exitosamente");
        }else {
            System.out.println("El usuario ya se encuentra registrado con anterioridad");
        }
    } // Fin de registrar nuevo cliente

    public static void crearCuenta()
        throws java.io.IOException{
        System.out.println("Ingrese el número de cédula del cliente al que desea crearle una cuenta");
        int id = Integer.parseInt(in.readLine());
        if(ctrl.clienteExiste(id)){
            LocalDate fechaApertura = LocalDate.now();

            System.out.println("Digite el tipo de cuenta que desea abrir");
            System.out.println("1- Corriente");
            System.out.println("2- Ahorros");
            System.out.println("3. Ahorro programado");
            int tipo = Integer.parseInt(in.readLine());

            int poseeCuentas = ctrl.poseeCuenta(id, tipo);
            if (poseeCuentas==-1){
                System.out.println("Opción inválida");
            }else {
                System.out.println("El cliente posee " + poseeCuentas + " cuentas de tipo " + ctrl.tipoCuenta(tipo));
                System.out.println("Para continuar el proceso de apertura de cuenta es necesario realizar un depósito" +
                        "de mínimo 50 000 colones");
                System.out.println("¿Desea continua el proceso? (Si/No)");
                String continuar = in.readLine();

                if (continuar.toLowerCase().equals("si")){
                    String descripcionDeposito = "Depósito de apertura de cuenta";
                    System.out.println("Ingrese la cantidad de dinero que desea depositar");
                    double cantidad = Integer.parseInt(in.readLine());
                    if(cantidad < 50000.0){
                        System.out.println("Su deposito debe de ser mayor o igual a 50 000 colones");
                    }else {
                        ctrl.registrarCuenta(id, fechaApertura, tipo, descripcionDeposito, cantidad);
                        System.out.println("La cuenta ha sido creada");
                    }

                }else {
                    System.out.println("Se ha suspendido el proceso, la cuenta no fue creada");
                }
            }
        }else{
            System.out.println("El cliente no se encuentra registrado. Debe estar registrado antes de asociarle una cuenta");
        }
    }

    public static void listarClientes() {

        for (String dato : ctrl.listarClientes()) {
            out.println(dato);
        }
    }// Fin de listar clientes


    public static void realizarDeposito()
        throws java.io.IOException{

        System.out.println("Digite el número de cédula del cliente");
        int cedula = Integer.parseInt(in.readLine());
        System.out.println("Digite el número de cuenta al cuál desea depositar el dinero");
        int numCuenta = Integer.parseInt(in.readLine());
        System.out.println("Digite la cantidad que desea depositar");
        double cantidad = Integer.parseInt(in.readLine());
        System.out.println("Añada una descripcion a su depósito: ");
        String descripcion = in.readLine();
        LocalDate fechaDeposito = LocalDate.now();

        boolean transaccion = ctrl.depositarDinero(cedula, numCuenta, cantidad, descripcion, fechaDeposito);

    }


} // ***** Fin *****