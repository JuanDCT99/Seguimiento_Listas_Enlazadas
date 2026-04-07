package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Panaderia_Punto1;

/**
 * Nodo que representa un cliente en la fila de la panadería.
 */
public class Nodo {
    private int numeroTurno;
    private Nodo siguiente;

    public Nodo(int numeroTurno) {
        this.numeroTurno = numeroTurno;
        this.siguiente = null;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
