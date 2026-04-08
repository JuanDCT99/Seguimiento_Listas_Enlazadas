public class PruebaPanaderia {
    public static void main(String[] args) {
        Panaderia miPanaderia = new Panaderia();

        System.out.println("--- Inicio de jornada en la Panadería ---");
        miPanaderia.agregarCliente(); // Turno 1
        miPanaderia.agregarCliente(); // Turno 2
        miPanaderia.agregarCliente(); // Turno 3
        
        miPanaderia.mostrarFila();
        miPanaderia.consultarSiguienteCliente();

        System.out.println("\nAtendiendo al cliente: " + miPanaderia.atenderCliente());
        miPanaderia.mostrarFila();

        System.out.println("Llega un nuevo cliente...");
        miPanaderia.agregarCliente(); // Turno 4
        miPanaderia.mostrarFila();

        System.out.println("\nAtendiendo a todos...");
        miPanaderia.atenderCliente();
        miPanaderia.atenderCliente();
        miPanaderia.atenderCliente();
        
        miPanaderia.mostrarFila();
    }
}
