import java.util.Scanner;

public class Validaciones {

    public String ValidaCedula(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            if (s.length() >= 5 && s.length() <= 12 && esSoloDigitos(s, 0)) {
                return s;
            }
            System.out.print("Inválido (5-12 dígitos, solo números): ");
        }
    }

    public String ValidaTelefono(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            if (s.length() >= 7 && s.length() <= 15 && esSoloDigitos(s, 0)) {
                return s;
            }
            System.out.print("Inválido (7-15 dígitos, solo números): ");
        }
    }

    // tipo 1: solo letras y espacios; tipo 2: alfanumérico
    public String ValidaCadena(Scanner sc, int tipo) {
        while (true) {
            String s = sc.nextLine().trim();
            if (tipo == 1 && !s.isEmpty() && esSoloLetrasEspacios(s, 0)) {
                return s;
            }
            if (tipo == 2 && !s.isEmpty() && esAlfanumerico(s, 0)) {
                return s;
            }
            System.out.print("Inválido: ");
        }
    }

    public int ValidarEntero(Scanner sc) {
        while (true) {
            try {
                String entrada = sc.nextLine().trim();

                if (!entrada.matches("\\d+")) {
                    System.out.println("Error: debe ingresar solo números.");
                    System.out.print("Ingrese un número entero: ");
                    continue;
                }

                int valor = Integer.parseInt(entrada);

                if (valor <= 0) {
                    System.out.println("Debe ingresar un número mayor que 0.");
                    System.out.print("Ingrese un número entero: ");
                    continue;
                }

                return valor;

            } catch (Exception e) {
                System.out.println("Error, intente nuevamente.");
                System.out.print("Ingrese un número entero: ");
            }
        }
    }

    public float ValidarFloat(Scanner sc) {
        while (true) {
            try {
                String entrada = sc.nextLine().trim();
                float f = Float.parseFloat(entrada);
                if (f > 0) {
                    return f;
                }
                System.out.println("Debe ser un número positivo.");
                System.out.print("Número positivo: ");
            } catch (Exception e) {
                System.out.println("Error, intente nuevamente.");
                System.out.print("Número positivo: ");
            }
        }
    }

    //  VALIDACIONES RECURSIVAS 

    public boolean esSoloDigitos(String s, int i) {
        if (s == null) return false;
        if (i == s.length()) return true;
        return Character.isDigit(s.charAt(i)) && esSoloDigitos(s, i + 1);
    }

    public boolean esSoloLetrasEspacios(String s, int i) {
        if (s == null) return false;
        if (i == s.length()) return true;
        char c = s.charAt(i);
        return (Character.isLetter(c) || c == ' ') && esSoloLetrasEspacios(s, i + 1);
    }

    public boolean esAlfanumerico(String s, int i) {
        if (s == null) return false;
        if (i == s.length()) return true;
        char c = s.charAt(i);
        return Character.isLetterOrDigit(c) && esAlfanumerico(s, i + 1);
    }

    // Valida fecha real usando LocalDate
    public boolean esFormatoFechaValido(String s) {
        if (s == null) return false;
        try {
            java.time.LocalDate.parse(s);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }
}
