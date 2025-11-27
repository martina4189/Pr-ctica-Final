public class Vehiculos {

    private String Placa;
    private String Marca;
    private int Modelo;
    private float PrecioDia;
    private String Estado; // "disponible" o "alquilado"

    public Vehiculos(String Estado, String Marca, int Modelo, String Placa, float PrecioDia) {
        this.Estado = Estado;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Placa = Placa;
        this.PrecioDia = PrecioDia;
    }

    public Vehiculos() {
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }

    public float getPrecioDia() {
        return PrecioDia;
    }

    public void setPrecioDia(float PrecioDia) {
        this.PrecioDia = PrecioDia;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Placa: " + Placa +
               " | Marca: " + Marca +
               " | Modelo: " + Modelo +
               " | Precio/día: " + PrecioDia +
               " | Estado: " + Estado;
    }
}
