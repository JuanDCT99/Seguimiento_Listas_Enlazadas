
/**
 * Nodo para una Lista Circular Simplemente Enlazada que representa una canción.
 */
public class NodoMusica {
    private String nombreCancion;
    private NodoMusica siguiente;

    public NodoMusica(String nombreCancion) {
        this.nombreCancion = nombreCancion;
        this.siguiente = null;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public NodoMusica getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMusica siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Canción: " + nombreCancion;
    }
}
