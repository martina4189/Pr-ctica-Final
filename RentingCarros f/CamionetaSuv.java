public class CamionetaSuv extends Vehiculos {

    private String Traccion;          // "4x2" o "4x4"
    private float CapacidadMaletero;  // en litros

    // Constructor sencillo usado al registrar
    public CamionetaSuv(String placa, String marca) {
        super("disponible", marca, 0, placa, 0f);
    }

    // Constructor completo opcional
    public CamionetaSuv(float capacidadMaletero, String traccion,
                        String estado, String marca,
                        int modelo, String placa, float precioDia) {
        super(estado, marca, modelo, placa, precioDia);
        this.CapacidadMaletero = capacidadMaletero;
        this.Traccion = traccion;
    }

    public String getTraccion() {
        return Traccion;
    }

    public void setTraccion(String Traccion) {
        this.Traccion = Traccion;
    }

    public float getCapacidadMaletero() {
        return CapacidadMaletero;
    }

    public void setCapacidadMaletero(float CapacidadMaletero) {
        this.CapacidadMaletero = CapacidadMaletero;
    }

    @Override
    public String toString() {
        return super.toString()
             + " | Tipo: SUV"
             + " | Tracción: " + Traccion
             + " | Maletero: " + CapacidadMaletero + "L";
    }
}
