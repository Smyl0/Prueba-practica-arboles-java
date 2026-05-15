import java.util.Scanner;

/*
   Sistema Académico UTA — Árbol Binario de Búsqueda en Java  
   Asignatura : Estructura de Datos                           
   Punto de entrada del programa.
   Gestiona el menú interactivo y la interacción con el usuario.
 */
public class Main {

    private static final Scanner sc  = new Scanner(System.in);
    private static final ArbolBST arbol = new ArbolBST();

    public static void main(String[] args) {
        // Cargar datos de ejemplo para facilitar las pruebas
        cargarDatosEjemplo();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción");
            procesarOpcion(opcion);
        } while (opcion != 14);

        System.out.println("\n Saliendo del sistema. ¡Hasta pronto!\n");
        sc.close();
    }

    // MENÚ

    private static void mostrarMenu() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA ACADÉMICO UNIVERSIDAD TEC. AMBATO  ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1.  Insertar estudiante                     ║");
        System.out.println("║  2.  Buscar estudiante por cédula            ║");
        System.out.println("║  3.  Eliminar estudiante                     ║");
        System.out.println("║  4.  Recorrido Inorden                       ║");
        System.out.println("║  5.  Recorrido Preorden                      ║");
        System.out.println("║  6.  Recorrido Postorden                     ║");
        System.out.println("║  7.  Recorrido por niveles (BFS)             ║");
        System.out.println("║  8.  Contar estudiantes                      ║");
        System.out.println("║  9.  Calcular altura del árbol               ║");
        System.out.println("║  10. Mostrar estudiante con mayor nota       ║");
        System.out.println("║  11. Mostrar estudiante con menor nota       ║");
        System.out.println("║  12. Mostrar estudiantes aprobados           ║");
        System.out.println("║  13. Mostrar estudiantes reprobados          ║");
        System.out.println("║  14. Salir                                   ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1  -> insertar();
            case 2  -> buscar();
            case 3  -> eliminar();
            case 4  -> arbol.recorridoInorden();
            case 5  -> arbol.recorridoPreorden();
            case 6  -> arbol.recorridoPostorden();
            case 7  -> arbol.recorridoPorNiveles();
            case 8  -> arbol.contarNodos();
            case 9  -> arbol.calcularAltura();
            case 10 -> arbol.buscarNotaMayor();
            case 11 -> arbol.buscarNotaMenor();
            case 12 -> arbol.mostrarAprobados();
            case 13 -> arbol.mostrarReprobados();
            case 14 -> {}  // salir — manejado en el bucle principal
            default -> System.out.println("⚠ Opción no válida. Intente de nuevo.");
        }
    }

    // Acciones del menu

    /* Lee los datos del estudiante desde la consola y lo inserta. */
    private static void insertar() {
        System.out.println("\n── Insertar estudiante ──");

        String cedula = leerTextoNoVacio("Cedula");
        // Validar que la cédula tenga exactamente 10 dígitos
        while (!cedula.matches("\\d{10}")) {
            System.out.println("La cédula debe tener exactamente 10 dígitos numéricos.");
            cedula = leerTextoNoVacio("Cedula");
        }

        String apellidos = leerTextoNoVacio("Apellidos");
        String nombres   = leerTextoNoVacio("Nombres");

        double nota = -1;
        while (nota < 0 || nota > 10) {
            nota = leerDouble("Nota final (0 - 10)");
            if (nota < 0 || nota > 10) System.out.println(" La nota debe estar entre 0 y 10.");
        }

        String carrera = leerTextoNoVacio("Carrera");

        int nivel = 0;
        while (nivel < 1 || nivel > 10) {
            nivel = leerEntero("Nivel (1 - 10)");
            if (nivel < 1 || nivel > 10) System.out.println(" El nivel debe estar entre 1 y 10.");
        }

        arbol.insertarEstudiante(new Estudiante(cedula, apellidos, nombres, nota, carrera, nivel));
    }

    /* Lee una cédula y busca el estudiante. */
    private static void buscar() {
        System.out.println("\n── Buscar estudiante ──");
        String cedula = leerTextoNoVacio("Cedula del estudiante");
        arbol.buscarEstudiante(cedula);
    }

    /* Lee una cédula y elimina el estudiante. */
    private static void eliminar() {
        System.out.println("\n── Eliminar estudiante ──");
        String cedula = leerTextoNoVacio("Cedula del estudiante a eliminar");
        arbol.eliminarEstudiante(cedula);
    }

    // Utilidades de lectura

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print("» " + mensaje + ": ");
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Ingrese un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print("» " + mensaje + ": ");
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println(" Ingrese un número decimal válido.");
            }
        }
    }

    private static String leerTextoNoVacio(String mensaje) {
        String texto = "";
        while (texto.isBlank()) {
            System.out.print("» " + mensaje + ": ");
            texto = sc.nextLine().trim();
            if (texto.isBlank()) System.out.println("⚠ Este campo no puede estar vacío.");
        }
        return texto;
    }

    // Datos de ejemplo

    /*
     * Inserta 8 estudiantes de ejemplo para demostrar el funcionamiento del sistema.
     * Cédulas en distintos órdenes para que el árbol no sea degenerado.
     */
    private static void cargarDatosEjemplo() {
        System.out.println("Cargando datos de ejemplo...\n");

        arbol.insertarEstudiante(new Estudiante("1804567890", "Torres Medina",   "Carlos Alberto",  8.5,  "Ing. Sistemas",    3));
        arbol.insertarEstudiante(new Estudiante("1801234567", "Perez Lopez",     "Maria Jose",      9.0,  "Ing. Civil",       5));
        arbol.insertarEstudiante(new Estudiante("1807654321", "Flores Castillo", "Juan Sebastian",  5.5,  "Ing. Industrial",  1));
        arbol.insertarEstudiante(new Estudiante("1803456789", "Naranjo Vega",    "Ana Lucia",       7.0,  "Ing. Sistemas",    2));
        arbol.insertarEstudiante(new Estudiante("1809876543", "Salazar Mora",    "Diego Andrés",    3.5,  "Ing. Electrónica", 1));
        arbol.insertarEstudiante(new Estudiante("1802345678", "Guevara Ruiz",    "Valeria Estefania",6.8, "Ing. Civil",       4));
        arbol.insertarEstudiante(new Estudiante("1806543210", "Calle Suárez",    "Luis Fernando",  10.0,  "Ing. Industrial",  6));
        arbol.insertarEstudiante(new Estudiante("1805432109", "Barriga Almeida", "Sofía Valentina", 7.5,  "Ing. Sistemas",    3));

        System.out.println("\n Datos de ejemplo cargados exitosamente.\n");
    }
}
