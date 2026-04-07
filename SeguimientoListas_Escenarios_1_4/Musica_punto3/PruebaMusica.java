package estructuras2026.ListasEnlazadas.Seguimiento_Listas.Musica_punto3;

public class PruebaMusica {
    public static void main(String[] args) {
        ListaMusica miPlaylist = new ListaMusica();

        System.out.println("--- Creando Playlist ---");
        miPlaylist.agregarCancion("Bohemian Rhapsody");
        miPlaylist.agregarCancion("Imagine");
        miPlaylist.agregarCancion("Hotel California");
        
        miPlaylist.mostrarLista();

        System.out.println("\n--- Probando Circularidad (Avanzar 5 veces con solo 3 canciones) ---");
        for (int i = 0; i < 5; i++) {
            System.out.println(miPlaylist.siguienteCancion());
        }

        System.out.println("\n--- Eliminando la canción actual ('Bohemian Rhapsody') ---");
        miPlaylist.eliminarCancion("Bohemian Rhapsody");
        miPlaylist.mostrarLista();
        System.out.println(miPlaylist.siguienteCancion());

        System.out.println("\n--- Eliminando el 'ultimo' ('Hotel California') ---");
        miPlaylist.eliminarCancion("Hotel California");
        miPlaylist.mostrarLista();

        System.out.println("\n--- Verificando circularidad con una sola canción ---");
        System.out.println(miPlaylist.siguienteCancion());
        System.out.println(miPlaylist.siguienteCancion());

        System.out.println("\n--- Vaciando la lista ---");
        miPlaylist.eliminarCancion("Imagine");
        miPlaylist.mostrarLista();
    }
}
