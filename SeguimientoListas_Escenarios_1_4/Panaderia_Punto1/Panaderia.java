package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Panaderia_Punto1;

/**
 * Clase que gestiona la fila de la panadería usando una Cola (Lista Simplemente Enlazada).
 */
public class Panaderia {

    private Nodo inicio; // Primer cliente en la fila (Frente)
    private Nodo fin;    // Último cliente en la fila (Final)
    private int contadorTurnos; 

    public Panaderia() {
        this.inicio = null;
        this.fin = null;
        this.contadorTurnos = 0;
    }

    /**
     * Agrega un nuevo cliente al final de la fila. (Operación Enqueue)
     */
    public int agregarCliente() {
        contadorTurnos++;
        Nodo nuevoCliente = new Nodo(contadorTurnos);
        
        if (inicio == null) {
            inicio = nuevoCliente;
            fin = nuevoCliente;
        } else {
            fin.setSiguiente(nuevoCliente);
            fin = nuevoCliente;
        }
        return contadorTurnos;
    }

    /**
     * Atiende al primer cliente de la fila. (Operación Dequeue)
     */
    public int atenderCliente() {
        if (inicio == null) {
            System.out.println("No hay clientes en la fila para atender.");
            return -1; 
        }
        
        int numeroTurnoAtendido = inicio.getNumeroTurno();
        inicio = inicio.getSiguiente();
        
        if (inicio == null) {
            fin = null; // Si se vacía, el puntero final también debe ser null
        }
        return numeroTurnoAtendido;
    }

    /**
     * Muestra quién es el próximo en ser atendido sin sacarlo de la fila. (Operación Peek)
     */
    public void consultarSiguienteCliente() {
        if (inicio == null) {
            System.out.println("No hay clientes en la fila.");
        } else {
            System.out.println("El siguiente cliente a atender tiene el número de turno: " + inicio.getNumeroTurno());
        }
    }

    /**
     * Recorre la fila y muestra todos los turnos actuales.
     */
    public void mostrarFila() {
        if (inicio == null) {
            System.out.println("La fila está vacía.");
            return;
        }
        
        Nodo actual = inicio;
        System.out.print("Clientes en la fila: [");
        while (actual != null) {
            System.out.print(actual.getNumeroTurno());
            if (actual.getSiguiente() != null) {
                System.out.print(", ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println("]");
    }
}
