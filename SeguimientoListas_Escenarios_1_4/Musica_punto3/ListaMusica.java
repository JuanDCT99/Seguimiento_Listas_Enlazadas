package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Musica_punto3;

/**
 * Gestor de lista de reproducción continua (Lista Circular Simplemente Enlazada).
 */
public class ListaMusica {
    private NodoMusica ultimo;        // Referencia al último nodo (su siguiente es el primero)
    private NodoMusica cancionActual; // Canción que se está reproduciendo

    public ListaMusica() {
        this.ultimo = null;
        this.cancionActual = null;
    }

    /**
     * Agrega una canción al final de la lista circular.
     */
    public void agregarCancion(String nombre) {
        NodoMusica nuevo = new NodoMusica(nombre);
        
        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.setSiguiente(ultimo); // Se apunta a sí mismo (circularidad)
            cancionActual = ultimo;      // Empezamos con esta canción
        } else {
            nuevo.setSiguiente(ultimo.getSiguiente()); // El nuevo apunta al inicio
            ultimo.setSiguiente(nuevo);               // El actual último apunta al nuevo
            ultimo = nuevo;                           // El nuevo ahora es el último
        }
        System.out.println("Canción agregada: " + nombre);
    }

    /**
     * Avanza a la siguiente canción. Nunca termina debido a la circularidad.
     */
    public String siguienteCancion() {
        if (cancionActual == null) return "Lista vacía";
        
        cancionActual = cancionActual.getSiguiente();
        return "Reproduciendo ahora: " + cancionActual.getNombreCancion();
    }

    /**
     * Elimina una canción por su nombre.
     */
    public void eliminarCancion(String nombre) {
        if (ultimo == null) return;

        NodoMusica actual = ultimo.getSiguiente(); // Empezamos por el inicio
        NodoMusica anterior = ultimo;
        boolean encontrado = false;

        // Recorremos la lista circular
        do {
            if (actual.getNombreCancion().equalsIgnoreCase(nombre)) {
                encontrado = true;
                break;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != ultimo.getSiguiente());

        if (encontrado) {
            if (actual == ultimo && actual.getSiguiente() == actual) {
                // Caso: Es el único nodo en la lista
                ultimo = null;
                cancionActual = null;
            } else {
                // Caso: Reenlazar nodos para saltar el eliminado
                anterior.setSiguiente(actual.getSiguiente());
                
                // Si eliminamos el último, debemos actualizar la referencia 'ultimo'
                if (actual == ultimo) {
                    ultimo = anterior;
                }
                // Si eliminamos la que se está reproduciendo, pasamos a la siguiente
                if (actual == cancionActual) {
                    cancionActual = anterior.getSiguiente();
                }
            }
            System.out.println("Canción eliminada: " + nombre);
        } else {
            System.out.println("No se encontró la canción: " + nombre);
        }
    }

    /**
     * Muestra toda la secuencia de la lista circular una sola vez.
     */
    public void mostrarLista() {
        if (ultimo == null) {
            System.out.println("La lista de reproducción está vacía.");
            return;
        }

        System.out.print("Lista de reproducción: [ ");
        NodoMusica temporal = ultimo.getSiguiente(); // Inicio
        do {
            if (temporal == cancionActual) {
                System.out.print(">" + temporal.getNombreCancion() + "< ");
            } else {
                System.out.print(temporal.getNombreCancion() + " ");
            }
            temporal = temporal.getSiguiente();
        } while (temporal != ultimo.getSiguiente());
        System.out.println("] (Circular)");
    }
}
