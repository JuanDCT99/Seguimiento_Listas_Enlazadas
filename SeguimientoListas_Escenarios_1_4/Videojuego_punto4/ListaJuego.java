package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Videojuego_punto4;

/**
 * Gestor de turnos de un videojuego (Lista Circular Doblemente Enlazada).
 */
public class ListaJuego {
    private NodoJugador inicio;      // Referencia al primer jugador del ciclo
    private NodoJugador turnoActual; // Jugador que tiene el turno en este momento

    public ListaJuego() {
        this.inicio = null;
        this.turnoActual = null;
    }

    /**
     * Agrega un nuevo jugador al final del ciclo.
     */
    public void agregarJugador(String nombre) {
        NodoJugador nuevo = new NodoJugador(nombre);

        if (inicio == null) {
            inicio = nuevo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(inicio);
            turnoActual = inicio;
        } else {
            NodoJugador ultimo = inicio.getAnterior(); // En circular doble, el anterior del inicio es el último

            // Enlazamos el nuevo nodo
            nuevo.setSiguiente(inicio);
            nuevo.setAnterior(ultimo);

            // Reajustamos los punteros de los extremos
            inicio.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
        }
        System.out.println("Jugador '" + nombre + "' ha entrado a la partida.");
    }

    /**
     * Pasa el turno al siguiente jugador (Sentido horario).
     */
    public void pasarSiguienteTurno() {
        if (turnoActual != null) {
            turnoActual = turnoActual.getSiguiente();
            System.out.println("Es el turno de: " + turnoActual.getNombre());
        }
    }

    /**
     * Vuelve el turno al jugador anterior (Sentido antihorario).
     */
    public void volverTurnoAnterior() {
        if (turnoActual != null) {
            turnoActual = turnoActual.getAnterior();
            System.out.println("Turno devuelto a: " + turnoActual.getNombre());
        }
    }

    /**
     * Expulsa a un jugador de la partida.
     */
    public void expulsarJugador(String nombre) {
        if (inicio == null) return;

        NodoJugador actual = inicio;
        boolean encontrado = false;

        // Buscar el jugador en el ciclo
        do {
            if (actual.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                break;
            }
            actual = actual.getSiguiente();
        } while (actual != inicio);

        if (encontrado) {
            // Caso: Es el único jugador
            if (actual.getSiguiente() == actual) {
                inicio = null;
                turnoActual = null;
            } else {
                // Reenlazar a los vecinos
                NodoJugador anterior = actual.getAnterior();
                NodoJugador siguiente = actual.getSiguiente();

                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);

                // Si eliminamos el inicio, mover la referencia al siguiente
                if (actual == inicio) {
                    inicio = siguiente;
                }
                // Si eliminamos al que tiene el turno, pasarlo al siguiente
                if (actual == turnoActual) {
                    turnoActual = siguiente;
                }
            }
            System.out.println("Jugador '" + nombre + "' ha sido expulsado.");
        } else {
            System.out.println("No se encontró al jugador: " + nombre);
        }
    }

    /**
     * Muestra todos los jugadores sentados en la mesa virtual.
     */
    public void mostrarJugadores() {
        if (inicio == null) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }

        System.out.print("Mesa (Circular Doble): [ ");
        NodoJugador temp = inicio;
        do {
            if (temp == turnoActual) {
                System.out.print("*" + temp.getNombre() + "* "); // Marca el turno actual
            } else {
                System.out.print(temp.getNombre() + " ");
            }
            temp = temp.getSiguiente();
        } while (temp != inicio);
        System.out.println("]");
    }
}
