import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Enum.Estados;

public class GestorOrden {
    public List<OrdenTrabajo> ordenTrabajolist;

    public GestorOrden() {
        ordenTrabajolist = new ArrayList<>();
    }

    public boolean nuevaOrdenTrabajo(OrdenTrabajo orden) {
        if (!ordenTrabajolist.contains(orden)) {
            return ordenTrabajolist.add(orden);
        }
        return false;
    }

    public OrdenTrabajo buscarOrdenTrabajo(int numeroOrden) {
        OrdenTrabajo auxOrdenTrabajo = null;
        for (OrdenTrabajo orden : ordenTrabajolist) {
            if (orden.getNumeroOrden() == numeroOrden) {
                auxOrdenTrabajo = orden;
                break;
            }
        }
        return auxOrdenTrabajo;
    }

    public boolean cambiarEstadoOrdenTrabajo(int numeroOrden, Estados estado) {
        boolean cambiado = false;
        for (OrdenTrabajo orden : ordenTrabajolist) {
            if (orden.getNumeroOrden() == numeroOrden) {
                orden.setEstado(estado);
                cambiado = true;
                break;
            }
        }
        return cambiado;
    }

    public ArrayList<OrdenTrabajo> listarPorEstado(Estados estado) {
        ArrayList<OrdenTrabajo> listaOrdenTrabajo = new ArrayList<>();
        for (OrdenTrabajo orden : ordenTrabajolist) {
            if (orden.getEstado() == estado) {
                listaOrdenTrabajo.add(orden);
            }
        }
        return listaOrdenTrabajo;
    }

    /// Al final del día necesito saber cuánto dinero representan todas las órdenes cargadas.
    public double calcualTotal() {
        double total = 0;
        for (OrdenTrabajo orden : ordenTrabajolist) {
            total += orden.calcualarPrecio();
        }
        return total;
    }

    /// Y también quiero poder preguntarle cuál es la orden más cara.
    public OrdenTrabajo ordenMasCara() {
        return Collections.max(ordenTrabajolist);
    }

    /// Por último, necesito poder pedir el listado de cierre, con las órdenes ordenadas desde la más cara hasta la más barata."

    public ArrayList<OrdenTrabajo> ordenarMaxorMenor() {
        ArrayList<OrdenTrabajo> listaOrdenTrabajo = new ArrayList<>(ordenTrabajolist);
        Collections.sort(listaOrdenTrabajo,Collections.reverseOrder());
        return listaOrdenTrabajo;
    }

}

