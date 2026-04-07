package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Paginas_Punto2;

/**
 * Nodo para una Lista Doblemente Enlazada que representa una página en el historial.
 */
public class NodoWeb {
    private String url;
    private NodoWeb siguiente;
    private NodoWeb anterior;

    public NodoWeb(String url) {
        this.url = url;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NodoWeb getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoWeb siguiente) {
        this.siguiente = siguiente;
    }

    public NodoWeb getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoWeb anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Página: " + url;
    }
}
