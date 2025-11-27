public class Contrato {

    private String idContrato;
    private String CedulaCliente;
    private String PlacaVehiculo;
    private String FechaInicio;
    private String FechaFin;
    private int TotalDias;
    private float ValorTotal;
    private boolean Activo = true;

    public Contrato(String CedulaCliente,
                    String PlacaVehiculo,
                    String FechaInicio,
                    String FechaFin,
                    int TotalDias,
                    float ValorTotal,
                    String idContrato) {
        this.CedulaCliente = CedulaCliente;
        this.PlacaVehiculo = PlacaVehiculo;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.TotalDias = TotalDias;
        this.ValorTotal = ValorTotal;
        this.idContrato = idContrato;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public void setCedulaCliente(String CedulaCliente) {
        this.CedulaCliente = CedulaCliente;
    }

    public String getPlacaVehiculo() {
        return PlacaVehiculo;
    }

    public void setPlacaVehiculo(String PlacaVehiculo) {
        this.PlacaVehiculo = PlacaVehiculo;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public int getTotalDias() {
        return TotalDias;
    }

    public void setTotalDias(int TotalDias) {
        this.TotalDias = TotalDias;
    }

    public float getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(float ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    @Override
    public String toString() {
        String estado = Activo ? "Activo" : "Finalizado";
        return "Contrato: " + idContrato +
               " | Cliente: " + CedulaCliente +
               " | Vehículo: " + PlacaVehiculo +
               " | Inicio: " + FechaInicio +
               " | Fin: " + FechaFin +
               " | Días: " + TotalDias +
               " | Total: $" + String.format("%.2f", ValorTotal) +
               " | Estado: " + estado;
    }
}
