package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Videojuego_punto4;

public class PruebaJuego {
    public static void main(String[] args) {
        ListaJuego partida = new ListaJuego();

        System.out.println("--- Configurando Partida ---");
        partida.agregarJugador("Alice");
        partida.agregarJugador("Bob");
        partida.agregarJugador("Charlie");
        partida.agregarJugador("Diana");
        
        partida.mostrarJugadores();

        System.out.println("\n--- Probando turnos (Sentido Horario) ---");
        partida.pasarSiguienteTurno(); // Bob
        partida.pasarSiguienteTurno(); // Charlie
        partida.mostrarJugadores();

        System.out.println("\n--- Probando turnos (Sentido Antihorario) ---");
        partida.volverTurnoAnterior(); // Bob
        partida.volverTurnoAnterior(); // Alice
        partida.volverTurnoAnterior(); // Diana (Aquí se nota la circularidad doble)
        partida.mostrarJugadores();

        System.out.println("\n--- Expulsando a un jugador en medio (Bob) ---");
        partida.expulsarJugador("Bob");
        partida.mostrarJugadores();

        System.out.println("\n--- Expulsando al jugador con el turno actual (Diana) ---");
        System.out.println("El turno debería pasar automáticamente a Alice.");
        partida.expulsarJugador("Diana");
        partida.mostrarJugadores();
        
        System.out.println("\n--- Verificando que el círculo sigue intacto ---");
        partida.pasarSiguienteTurno(); // Charlie
        partida.pasarSiguienteTurno(); // Alice (Vuelta al inicio)
        partida.volverTurnoAnterior(); // Charlie (Vuelta al final)
        partida.mostrarJugadores();
    }
}
