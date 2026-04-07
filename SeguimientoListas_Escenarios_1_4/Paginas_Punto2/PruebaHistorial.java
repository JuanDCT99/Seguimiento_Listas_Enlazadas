package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Paginas_Punto2;

public class PruebaHistorial {
    public static void main(String[] args) {
        HistorialNavegacion miNavegador = new HistorialNavegacion();

        System.out.println("--- Inicio de navegación ---");
        miNavegador.visitarPagina("google.com");
        miNavegador.visitarPagina("facebook.com");
        miNavegador.visitarPagina("youtube.com");
        
        miNavegador.mostrarHistorial(); // [ google.com <-> facebook.com <-> *youtube.com* ]

        System.out.println("\n--- Probando botones Atrás ---");
        miNavegador.retroceder(); // facebook
        miNavegador.retroceder(); // google
        miNavegador.mostrarHistorial(); // [ *google.com* <-> facebook.com <-> youtube.com ]

        System.out.println("\n--- Probando botón Adelante ---");
        miNavegador.avanzar(); // facebook
        miNavegador.mostrarHistorial(); // [ google.com <-> *facebook.com* <-> youtube.com ]

        System.out.println("\n--- Probando la PODA (Acción crítica) ---");
        System.out.println("Estamos en facebook.com y visitaremos instagram.com.");
        System.out.println("Se espera que youtube.com desaparezca del historial.");
        miNavegador.visitarPagina("instagram.com");
        
        miNavegador.mostrarHistorial(); // [ google.com <-> facebook.com <-> *instagram.com* ]

        System.out.println("\n--- Verificando que no haya futuro tras la poda ---");
        miNavegador.avanzar(); // No hay más páginas en el futuro.
    }
}
