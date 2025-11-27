public class CarroSedan extends Vehiculos {

    private String TipoCombustible;  // "gasolina", "diesel", "electrico"
    private String Transmision;      // "manual" o "automatica"

    // Constructor sencillo usado al registrar
    public CarroSedan(String placa, String marca) {
        super("disponible", marca, 0, placa, 0f);
    }

    // Constructor completo opcional
    public CarroSedan(String tipoCombustible, String transmision,
                      String estado, String marca,
                      int modelo, String placa, float precioDia) {
        super(estado, marca, modelo, placa, precioDia);
        this.TipoCombustible = tipoCombustible;
        this.Transmision = transmision;
    }

    public String getTipoCombustible() {
        return TipoCombustible;
    }

    public void setTipoCombustible(String TipoCombustible) {
        this.TipoCombustible = TipoCombustible;
    }

    public String getTransmision() {
        return Transmision;
    }

    public void setTransmision(String Transmision) {
        this.Transmision = Transmision;
    }

    @Override
    public String toString() {
        return super.toString()
             + " | Tipo: Sedán"
             + " | Combustible: " + TipoCombustible
             + " | Transmisión: " + Transmision;
    }
}
