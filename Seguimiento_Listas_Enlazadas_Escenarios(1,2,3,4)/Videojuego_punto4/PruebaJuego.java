
public class PruebaJuego {
    public static void main(String[] args) {
        ListaJuego partida = new ListaJuego();

        System.out.println("--- Configurando Partida ---");
        partida.agregarJugador("Juan David");
        partida.agregarJugador("Camilo");
        partida.agregarJugador("Erwin");
        partida.agregarJugador("Jhan Carlos");
        
        partida.mostrarJugadores();

        System.out.println("\n--- Probando turnos ---");
        partida.pasarSiguienteTurno(); // Juan David
        partida.pasarSiguienteTurno(); // Camilo
        partida.mostrarJugadores();

        System.out.println("\n--- Probando turnos aplicando la referencia al elemento anterior ---");
        partida.volverTurnoAnterior(); // Erwin
        partida.volverTurnoAnterior(); // Camilo
        partida.volverTurnoAnterior(); // Juan David (Aquí se nota la circularidad doble)
        partida.mostrarJugadores();

        System.out.println("\n--- Expulsando a un jugador en medio (Erwin) ---");
        partida.expulsarJugador("Erwin");
        partida.mostrarJugadores();

        System.out.println("\n--- Expulsando al jugador con el turno actual (Jhan Carlos) ---");
        System.out.println("El turno debería pasar automáticamente a Alice.");
        partida.expulsarJugador("Jhan Carlos");
        partida.mostrarJugadores();
        
        System.out.println("\n--- Verificando que el círculo sigue intacto ---");
        partida.pasarSiguienteTurno(); // Camilo
        partida.pasarSiguienteTurno(); // Juan David
        partida.volverTurnoAnterior(); // Camilo
        partida.mostrarJugadores();
    }
}
