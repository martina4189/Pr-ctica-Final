import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Scanner;


public class Metodos {

    Scanner sc = new Scanner(System.in);
    Validaciones v = new Validaciones();

    // MÉTODOS PARA CLIENTES 

    public Clientes IngresarCliente(Clientes c) {
        System.out.print("Cédula: ");
        c.setCedula(v.ValidaCedula(sc));

        System.out.print("Nombre: ");
        c.setNombre(v.ValidaCadena(sc, 1));

        System.out.print("Apellido: ");
        c.setApellido(v.ValidaCadena(sc, 1));

        System.out.print("Teléfono: ");
        c.setTelefono(v.ValidaTelefono(sc));

        System.out.print("Dirección: ");
        c.setDireccion(sc.nextLine().trim());

        System.out.print("Licencia: ");
        c.setLicenciaConducir(sc.nextLine().trim());

        return c;
    }

    private boolean esNombreValido(String s) {
        return s != null && !s.isBlank() && v.esSoloLetrasEspacios(s, 0);
    }

    private boolean esTelefonoValido(String s) {
        return s != null && s.length() >= 7 && s.length() <= 15 && v.esSoloDigitos(s, 0);
    }

    public void ModificarCliente(Clientes c) {
        System.out.print("Nuevo nombre (" + c.getNombre() + "): ");
        String n = sc.nextLine().trim();
        if (!n.isEmpty() && esNombreValido(n)) {
            c.setNombre(n);
        }

        System.out.print("Nuevo apellido (" + c.getApellido() + "): ");
        String a = sc.nextLine().trim();
        if (!a.isEmpty() && esNombreValido(a)) {
            c.setApellido(a);
        }

        System.out.print("Nuevo teléfono (" + c.getTelefono() + "): ");
        String t = sc.nextLine().trim();
        if (!t.isEmpty() && esTelefonoValido(t)) {
            c.setTelefono(t);
        }

        System.out.print("Nueva dirección (enter para dejar igual): ");
        String d = sc.nextLine().trim();
        if (!d.isEmpty()) {
            c.setDireccion(d);
        }

        System.out.print("Nueva licencia (enter para dejar igual): ");
        String l = sc.nextLine().trim();
        if (!l.isEmpty()) {
            c.setLicenciaConducir(l);
        }
    }

    public Clientes BuscarPorCedula(LinkedList<Clientes> lista, String cedula) {
        for (Clientes c : lista) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public void EliminarPorCedula(LinkedList<Clientes> lista, String cedula) {
        lista.removeIf(c -> c.getCedula().equals(cedula));
    }

    public void MostrarClientes(LinkedList<Clientes> lista) {
        if (lista.isEmpty()) {
            System.out.println("📭 No hay clientes.");
            return;
        }
        for (Clientes c : lista) {
            System.out.println(c);
        }
    }

    // MÉTODOS PARA VEHÍCULOS 

  public Vehiculos IngresarVehiculo() {
    // Tipo de vehículo
    System.out.println("1. Sedán");
    System.out.println("2. SUV");
    System.out.print("Opción: ");
    String opTipo = sc.nextLine().trim();

    
    System.out.print("Placa: ");
    String placa = v.ValidaCadena(sc, 2);   // alfanumérica

    System.out.print("Marca: ");
    String marca = v.ValidaCadena(sc, 1);   // solo letras/espacios

    System.out.print("Modelo (año): ");
    int modelo = v.ValidarEntero(sc);

    System.out.print("Precio por día: ");
    float precio = v.ValidarFloat(sc);

    // Estado del vehículo: 1 disponible, 2 alquilado
    String estado = "";
    while (true) {
        System.out.println("Estado del vehículo:");
        System.out.println("1. Disponible");
        System.out.println("2. Alquilado");
        System.out.print("Opción: ");
        String opEstado = sc.nextLine().trim();

        if (opEstado.equals("1")) {
            estado = "disponible";
            break;
        } else if (opEstado.equals("2")) {
            estado = "alquilado";
            break;
        } else {
            System.out.println(" Opción inválida.");
        }
    }

    // Carro Sedán
    if (opTipo.equals("1")) {
        // Combustible
        String comb = "";
        while (true) {
            System.out.println("Tipo de combustible:");
            System.out.println("1. Gasolina");
            System.out.println("2. Diésel");
            System.out.println("3. Eléctrico");
            System.out.print("Opción: ");
            String opComb = sc.nextLine().trim();

            if (opComb.equals("1")) { comb = "gasolina"; break; }
            if (opComb.equals("2")) { comb = "diesel";   break; }
            if (opComb.equals("3")) { comb = "electrico";break; }

            System.out.println(" Opción inválida.");
        }

        // Transmisión
        String trans = "";
        while (true) {
            System.out.println("Transmisión:");
            System.out.println("1. Manual");
            System.out.println("2. Automática");
            System.out.print("Opción: ");
            String opTrans = sc.nextLine().trim();

            if (opTrans.equals("1")) { trans = "manual";     break; }
            if (opTrans.equals("2")) { trans = "automatica"; break; }

            System.out.println(" Opción inválida.");
        }

        CarroSedan cs = new CarroSedan(placa, marca);
        cs.setModelo(modelo);
        cs.setPrecioDia(precio);
        cs.setEstado(estado);
        cs.setTipoCombustible(comb);
        cs.setTransmision(trans);
        return cs;
    }

    // Camioneta SUV
    else if (opTipo.equals("2")) {
        // Tracción
        String trac = "";
        while (true) {
            System.out.println("Tracción:");
            System.out.println("1. 4x2");
            System.out.println("2. 4x4");
            System.out.print("Opción: ");
            String opTrac = sc.nextLine().trim();

            if (opTrac.equals("1")) { trac = "4x2"; break; }
            if (opTrac.equals("2")) { trac = "4x4"; break; }

            System.out.println(" Opción inválida.");
        }

        System.out.print("Capacidad maletero (L): ");
        float mal = v.ValidarFloat(sc);

        CamionetaSuv suv = new CamionetaSuv(placa, marca);
        suv.setModelo(modelo);
        suv.setPrecioDia(precio);
        suv.setEstado(estado);
        suv.setTraccion(trac);
        suv.setCapacidadMaletero(mal);
        return suv;
    }

    // ====== Tipo genérico si eligen otra cosa ======
    else {
        System.out.println("⚠ Tipo no reconocido, se registrará como vehículo genérico.");
        return new Vehiculos(estado, marca, modelo, placa, precio);
    }
}


    public void ModificarVehiculo(Vehiculos v) {
        System.out.print("Nuevo precio (" + v.getPrecioDia() + "): ");
        String p = sc.nextLine().trim();
        if (!p.isEmpty()) {
            try {
                float nuevo = Float.parseFloat(p);
                if (nuevo > 0) {
                    v.setPrecioDia(nuevo);
                }
            } catch (Exception e) {
                System.out.println("Valor inválido, se mantiene el precio anterior.");
            }
        }
    }

    public Vehiculos BuscarPorPlaca(LinkedList<Vehiculos> lista, String placa) {
        for (Vehiculos v : lista) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public void EliminarPorPlaca(LinkedList<Vehiculos> lista, String placa) {
        lista.removeIf(v -> v.getPlaca().equals(placa));
    }

    public void MostrarVehiculos(LinkedList<Vehiculos> lista) {
        if (lista.isEmpty()) {
            System.out.println(" No hay vehículos.");
            return;
        }
        for (Vehiculos v : lista) {
            System.out.println(v);
        }
    }
}

// MÉTODOS PARA CONTRATOS 

class MetodoContratos {

    Scanner sc = new Scanner(System.in);
    Validaciones v = new Validaciones();

    public Contrato IngresarContrato(String idContrato, String cedulaCliente, String placaVehiculo, float precioDiario) {

    LocalDate fechaIniDate;
    LocalDate fechaFinDate;
    String fechaInicio;
    String fechaFin;

    while (true) {
        // FECHA INICIO
        System.out.print("Ingrese fecha de inicio (YYYY-MM-DD): ");
        fechaInicio = sc.nextLine().trim();
        if (!v.esFormatoFechaValido(fechaInicio)) {
            System.out.println("Formato inválido. Intente de nuevo.");
            continue;
        }
        fechaIniDate = LocalDate.parse(fechaInicio);

        // FECHA FIN
        System.out.print("Ingrese fecha de fin (YYYY-MM-DD): ");
        fechaFin = sc.nextLine().trim();
        if (!v.esFormatoFechaValido(fechaFin)) {
            System.out.println("Formato inválido. Intente de nuevo.");
            continue;
        }
        fechaFinDate = LocalDate.parse(fechaFin);

        // CÁLCULO AUTOMÁTICO DE DÍAS
        long dias = ChronoUnit.DAYS.between(fechaIniDate, fechaFinDate);

        if (dias <= 0) {
            System.out.println(" La fecha de fin debe ser posterior a la fecha de inicio.");
            System.out.println("   Vuelva a ingresar las fechas.\n");
            continue;   // vuelve a pedir ambas fechas
        }

        int totalDias = (int) dias;
        System.out.println(" Cantidad de días de alquiler: " + totalDias);

        float total = totalDias * precioDiario;

        return new Contrato(cedulaCliente, placaVehiculo,fechaInicio,fechaFin,totalDias, total,idContrato);
    }
}


    public void ModificarContrato(Contrato c, float precioDiario) {
        System.out.print("Nuevos días (" + c.getTotalDias() + "): ");
        String d = sc.nextLine().trim();
        if (!d.isEmpty()) {
            try {
                int nd = Integer.parseInt(d);
                if (nd > 0) {
                    c.setTotalDias(nd);
                    c.setValorTotal(nd * precioDiario);
                }
            } catch (Exception e) {
                System.out.println("Valor inválido, no se modificó el contrato.");
            }
        }
    }

    public void FinalizarContrato(Contrato c) {
        c.setActivo(false);
    }

    public Contrato BuscarPorId(LinkedList<Contrato> lista, String id) {
        for (Contrato c : lista) {
            if (c.getIdContrato().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void EliminarPorCliente(LinkedList<Contrato> lista, String cedula) {
        lista.removeIf(c -> c.getCedulaCliente().equals(cedula));
    }

    public void EliminarPorVehiculo(LinkedList<Contrato> lista, String placa) {
        lista.removeIf(c -> c.getPlacaVehiculo().equals(placa));
    }

    public boolean ClienteTieneContratoActivo(LinkedList<Contrato> lista, String cedula) {
        for (Contrato c : lista) {
            if (c.getCedulaCliente().equals(cedula) && c.isActivo()) {
                return true;
            }
        }
        return false;
    }

    public boolean VehiculoEstaAlquilado(LinkedList<Contrato> lista, String placa) {
        for (Contrato c : lista) {
            if (c.getPlacaVehiculo().equals(placa) && c.isActivo()) {
                return true;
            }
        }
        return false;
    }

    public void MostrarContratos(LinkedList<Contrato> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay contratos.");
            return;
        }

        System.out.println("Contratos activos:");
        for (Contrato c : lista) {
            if (c.isActivo()) {
                System.out.println(c);
            }
        }

        System.out.println("\nContratos finalizados:");
        for (Contrato c : lista) {
            if (!c.isActivo()) {
                System.out.println(c);
            }
        }
    }
}

        

    