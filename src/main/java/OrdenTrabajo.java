import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

import Enum.Estados;


public abstract class OrdenTrabajo implements Comparable<OrdenTrabajo> {
    private int numeroOrden;
    private static int contadorOrden = 1;
    private String descripcion;
    private String maquina;
    private String fecha;
    private Estados estado = Estados.PENDIENTE;


    public int getNumeroOrden() {
        return numeroOrden;
    }

    public static int getContadorOrden() {
        return contadorOrden;
    }

    public static void setContadorOrden(int contadorOrden) {
        OrdenTrabajo.contadorOrden = contadorOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public OrdenTrabajo(String descripcion, String maquina, String fecha) {
        this.numeroOrden = contadorOrden++;
        this.descripcion = descripcion;
        this.maquina = maquina;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "OrdenTrabajo{" +
                "numeroOrden=" + numeroOrden +
                ", descripcion='" + descripcion + '\'' +
                ", maquina='" + maquina + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado=" + estado +
                '}';
    }

    public double calcualarPrecio() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrdenTrabajo that)) return false;
        return numeroOrden == that.numeroOrden && Objects.equals(descripcion, that.descripcion) && Objects.equals(maquina, that.maquina) && Objects.equals(fecha, that.fecha) && estado == that.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroOrden, descripcion, maquina, fecha, estado);
    }

    @Override
    public int compareTo(OrdenTrabajo o){
        return Double.compare(o.calcualarPrecio(), calcualarPrecio());
    }
}
