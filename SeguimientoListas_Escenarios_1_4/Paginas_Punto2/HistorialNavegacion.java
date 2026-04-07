package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Paginas_Punto2;

/**
 * Gestor de historial de navegación usando una Lista Doblemente Enlazada.
 */
public class HistorialNavegacion {
    private NodoWeb inicio;       // Primer página visitada (Raíz del historial)
    private NodoWeb paginaActual; // Dónde se encuentra el usuario en este momento

    public HistorialNavegacion() {
        this.inicio = null;
        this.paginaActual = null;
    }

    /**
     * Navega a una nueva URL. 
     * Si el usuario está en medio del historial (ha retrocedido), se "poda" el futuro.
     */
    public void visitarPagina(String url) {
        NodoWeb nuevoNodo = new NodoWeb(url);

        if (inicio == null) {
            // Primer página que se visita en la sesión
            inicio = nuevoNodo;
            paginaActual = nuevoNodo;
        } else {
            // PODA: Si hay páginas adelante, el nuevo nodo corta esa rama del futuro
            paginaActual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(paginaActual);
            
            // La nueva página ahora es la actual
            paginaActual = nuevoNodo;
        }
        System.out.println("Visitando: " + url);
    }

    /**
     * Retrocede a la página anterior en el historial (Equivalente al botón Atrás).
     */
    public void retroceder() {
        if (paginaActual != null && paginaActual.getAnterior() != null) {
            paginaActual = paginaActual.getAnterior();
            System.out.println("Retrocediendo a: " + paginaActual.getUrl());
        } else {
            System.out.println("No hay más páginas para retroceder.");
        }
    }

    /**
     * Avanza a la página siguiente si existe (Equivalente al botón Adelante).
     */
    public void avanzar() {
        if (paginaActual != null && paginaActual.getSiguiente() != null) {
            paginaActual = paginaActual.getSiguiente();
            System.out.println("Avanzando a: " + paginaActual.getUrl());
        } else {
            System.out.println("No hay más páginas en el futuro.");
        }
    }

    /**
     * Muestra el historial completo desde el inicio, resaltando la página actual.
     */
    public void mostrarHistorial() {
        if (inicio == null) {
            System.out.println("Historial vacío.");
            return;
        }

        System.out.print("Historial: [ ");
        NodoWeb temporal = inicio;
        while (temporal != null) {
            if (temporal == paginaActual) {
                System.out.print("*" + temporal.getUrl() + "* "); // Marca la página actual
            } else {
                System.out.print(temporal.getUrl() + " ");
            }
            
            if (temporal.getSiguiente() != null) {
                System.out.print("<-> ");
            }
            temporal = temporal.getSiguiente();
        }
        System.out.println("]");
    }
}
