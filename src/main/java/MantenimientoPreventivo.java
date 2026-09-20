public class MantenimientoPreventivo extends OrdenTrabajo{
    private int horas;

    public double getPrecio() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "MantenimientoPreventivo{" +
                "Horas=" + horas +
                "} " + super.toString();
    }

    public MantenimientoPreventivo(String descripcion, String maquina, String fecha, int horas) {
        super(descripcion, maquina, fecha);
        this.horas = horas;
    }

    @Override
    public double calcualarPrecio() {
        return 5000 + (horas * 3000);
    }
}


