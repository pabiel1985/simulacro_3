public class MantenimientoCorrectivo extends OrdenTrabajo implements MaquinaUrgencia {
    private int nivelUrgencia;

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(int nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    public MantenimientoCorrectivo(String descripcion, String maquina, String fecha, int nivelUrgencia) {
        super(descripcion, maquina, fecha);
        this.nivelUrgencia = nivelUrgencia;
    }

    @Override
    public String toString() {
        return "MantenimientoCorrectivo{" +
                "nivelUrgencia=" + nivelUrgencia +
                "} " + super.toString();
    }

    @Override
    public double calcualarPrecio() {
        return 8000 + (nivelUrgencia * 2500);
    }

    @Override
    public boolean esPrioridad() {
        if (nivelUrgencia >= 4) {
            return true;
        } else {
            return false;
        }
    }

}
