import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Metodos m = new Metodos();
    public static MetodoContratos mc = new MetodoContratos();

    public static LinkedList<Clientes> vector_clientes = new LinkedList<>();
    public static LinkedList<Vehiculos> vector_vehiculos = new LinkedList<>();
    public static LinkedList<Contrato> vector_contratos = new LinkedList<>();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Vehículos");
            System.out.println("3. Gestión de Contratos");
            System.out.println("4. Imprimir Informe General");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    menuClientes();
                    break;
                case "2":
                    menuVehiculos();
                    break;
                case "3":
                    menuContratos();
                    break;
                case "4":
                    imprimirInforme();
                    break;
                case "5":
                    System.out.println("¡Hasta pronto!");
                    return;
                default:
                    System.out.println(" Opción inválida.");
            }
        }
    }

    // MENÚ CLIENTES 
    public static void menuClientes() {
        while (true) {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Registrar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Buscar");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    Clientes c = new Clientes();
                    vector_clientes.add(m.IngresarCliente(c));
                    break;
                case "2":
                    System.out.print("Cédula a modificar: ");
                    String cedMod = sc.nextLine().trim();
                    Clientes cliMod = m.BuscarPorCedula(vector_clientes, cedMod);
                    if (cliMod != null) {
                        m.ModificarCliente(cliMod);
                        System.out.println(" Cliente actualizado.");
                    } else {
                        System.out.println(" No encontrado.");
                    }
                    break;
                case "3":
                    System.out.print("Cédula a eliminar: ");
                    String cedElim = sc.nextLine().trim();
                    if (m.BuscarPorCedula(vector_clientes, cedElim) != null) {
                        m.EliminarPorCedula(vector_clientes, cedElim);
                        mc.EliminarPorCliente(vector_contratos, cedElim);
                        System.out.println(" Cliente y sus contratos eliminados.");
                    } else {
                        System.out.println(" No encontrado.");
                    }
                    break;
                case "4":
                    System.out.print("Cédula a buscar: ");
                    String cedBusq = sc.nextLine().trim();
                    Clientes cliBusq = m.BuscarPorCedula(vector_clientes, cedBusq);
                    if (cliBusq != null) {
                        System.out.println("🔍 " + cliBusq);
                    } else {
                        System.out.println(" No encontrado.");
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println(" Opción inválida.");
            }
        }
    }

    //  MENÚ VEHÍCULOS 
    public static void menuVehiculos() {
        while (true) {
            System.out.println("\n--- GESTIÓN DE VEHÍCULOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Buscar");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    Vehiculos v = m.IngresarVehiculo();
                    vector_vehiculos.add(v);
                    break;
                case "2":
                    System.out.print("Placa a modificar: ");
                    String placaMod = sc.nextLine().trim();
                    Vehiculos vehMod = m.BuscarPorPlaca(vector_vehiculos, placaMod);
                    if (vehMod != null) {
                        m.ModificarVehiculo(vehMod);
                        System.out.println(" Vehículo actualizado.");
                    } else {
                        System.out.println(" No encontrado.");
                    }
                    break;
                case "3":
                    System.out.print("Placa a eliminar: ");
                    String placaElim = sc.nextLine().trim();
                    if (m.BuscarPorPlaca(vector_vehiculos, placaElim) != null) {
                        m.EliminarPorPlaca(vector_vehiculos, placaElim);
                        mc.EliminarPorVehiculo(vector_contratos, placaElim);
                        System.out.println(" Vehículo y sus contratos eliminados.");
                    } else {
                        System.out.println(" No encontrado.");
                    }
                    break;
                case "4":
                    System.out.print("Placa a buscar: ");
                    String placaBusq = sc.nextLine().trim();
                    Vehiculos vehBusq = m.BuscarPorPlaca(vector_vehiculos, placaBusq);
                    if (vehBusq != null) {
                        System.out.println(" " + vehBusq);
                    } else {
                        System.out.println(" No encontrado.");
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println(" Opción inválida.");
            }
        }
    }

    //  MENÚ CONTRATOS 
    public static void menuContratos() {
        while (true) {
            System.out.println("\n--- GESTIÓN DE CONTRATOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Modificar");
            System.out.println("3. Finalizar");
            System.out.println("4. Buscar");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    // Validar cliente
                    System.out.print("Cédula del cliente: ");
                    String ced = sc.nextLine().trim();
                    Clientes cli = m.BuscarPorCedula(vector_clientes, ced);
                    if (cli == null) {
                        System.out.println(" Cliente no registrado.");
                        break;
                    }
                    if (mc.ClienteTieneContratoActivo(vector_contratos, ced)) {
                        System.out.println("El cliente ya tiene un contrato activo.");
                        break;
                    }

                    // Validar vehículo
                    System.out.print("Placa del vehículo: ");
                    String placa = sc.nextLine().trim();
                    Vehiculos veh = m.BuscarPorPlaca(vector_vehiculos, placa);
                    if (veh == null) {
                        System.out.println(" Vehículo no encontrado.");
                        break;
                    }
                    if (mc.VehiculoEstaAlquilado(vector_contratos, placa)) {
                        System.out.println(" El vehículo ya está alquilado.");
                        break;
                    }

                    // Registrar contrato
                    String id = String.format("CTR%04d", vector_contratos.size() + 1);
                    Contrato cont = mc.IngresarContrato(id, ced, placa, veh.getPrecioDia());
                    vector_contratos.add(cont);
                    veh.setEstado("alquilado");
                    System.out.println(" Contrato registrado:\n" + cont);
                    break;

                case "2":
                    System.out.print("ID del contrato: ");
                    String idMod = sc.nextLine().trim();
                    Contrato contMod = mc.BuscarPorId(vector_contratos, idMod);
                    if (contMod != null && contMod.isActivo()) {
                        Vehiculos v = m.BuscarPorPlaca(vector_vehiculos, contMod.getPlacaVehiculo());
                        mc.ModificarContrato(contMod, v.getPrecioDia());
                        System.out.println(" Contrato actualizado.");
                    } else {
                        System.out.println(" Contrato no encontrado o ya finalizado.");
                    }
                    break;

                case "3":
                    System.out.print("ID del contrato: ");
                    String idFin = sc.nextLine().trim();
                    Contrato contFin = mc.BuscarPorId(vector_contratos, idFin);
                    if (contFin != null && contFin.isActivo()) {
                        mc.FinalizarContrato(contFin);
                        Vehiculos vFin = m.BuscarPorPlaca(vector_vehiculos, contFin.getPlacaVehiculo());
                        if (vFin != null) {
                            vFin.setEstado("disponible");
                        }
                        System.out.println(" Contrato finalizado.");
                    } else {
                        System.out.println("Contrato no encontrado o ya finalizado.");
                    }
                    break;

                case "4":
                    System.out.print("ID del contrato: ");
                    String idBusq = sc.nextLine().trim();
                    Contrato contBusq = mc.BuscarPorId(vector_contratos, idBusq);
                    if (contBusq != null) {
                        System.out.println("🔍 " + contBusq);
                    } else {
                        System.out.println(" No encontrado.");
                    }
                    break;

                case "5":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    //  INFORME GENERAL 
    public static void imprimirInforme() {
        System.out.println("\n=== INFORME GENERAL ===");

        System.out.println("\n CLIENTES:");
        m.MostrarClientes(vector_clientes);

        System.out.println("\n VEHÍCULOS:");
        m.MostrarVehiculos(vector_vehiculos);

        System.out.println("\n CONTRATOS:");
        mc.MostrarContratos(vector_contratos);

        float total = 0;
        for (Contrato c : vector_contratos) {
            total += c.getValorTotal();
        }
        System.out.printf("\n Ingresos totales: $%.2f%n", total);
    }
}




        