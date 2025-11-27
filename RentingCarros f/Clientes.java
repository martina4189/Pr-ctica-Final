public class Clientes {

    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Direccion;
    private String LicenciaConducir;

    public Clientes() {
    }

    public Clientes(String cedula, String nombre, String apellido,
                    String telefono, String direccion, String licenciaConducir) {
        this.Cedula = cedula;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Telefono = telefono;
        this.Direccion = direccion;
        this.LicenciaConducir = licenciaConducir;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getLicenciaConducir() {
        return LicenciaConducir;
    }

    public void setLicenciaConducir(String LicenciaConducir) {
        this.LicenciaConducir = LicenciaConducir;
    }

    @Override
    public String toString() {
        return "Cédula: " + Cedula
             + " | Nombre: " + Nombre + " " + Apellido
             + " | Tel: " + Telefono;
    }
}
