
public class PruebaMusica {
    public static void main(String[] args) {
        ListaMusica miPlaylist = new ListaMusica();

        System.out.println("--- Creando Lista de reproducción ---");
        miPlaylist.agregarCancion("Imitadora - Romeo Santos");
        miPlaylist.agregarCancion("Dardos - Prince Royce, Romeo Santos");
        miPlaylist.agregarCancion("Bloodline - Alex Warren)");
        miPlaylist.agregarCancion("Carry you home - Alex Warren");

        miPlaylist.mostrarLista();

        System.out.println("\n--- Probando La lista circular simplemente enlazada (Avanzar 5 veces con solo 3 canciones) ---");
        for (int i = 0; i < 5; i++) {
            System.out.println(miPlaylist.siguienteCancion());
        }

        System.out.println("\n--- Eliminando la canción actual ('Imitadora - Romeo Santos') ---");
        miPlaylist.eliminarCancion("Imitadora - Romeo Santos");
        miPlaylist.mostrarLista();
        System.out.println(miPlaylist.siguienteCancion());

        System.out.println("\n--- Eliminando el 'ultimo' ('Carry you home - Alex Warren') ---");
        miPlaylist.eliminarCancion("Carry you home - Alex Warren");
        miPlaylist.mostrarLista();

        System.out.println("\n--- Verificando circularidad con una sola canción ---");
        System.out.println(miPlaylist.siguienteCancion());
        System.out.println(miPlaylist.siguienteCancion());

        System.out.println("\n--- Vaciando la lista ---");
        miPlaylist.eliminarCancion("Dardos - Prince Royce, Romeo Santos");
        miPlaylist.mostrarLista();
    }
}
