import java.util.LinkedList;
import java.util.Queue;

/*
 * Árbol Binario de Búsqueda (BST) para gestionar estudiantes.
 * La clave de ordenamiento es la cédula del estudiante.
 * Funciones implementadas:
 *   insertarEstudiante, buscarEstudiante, eliminarEstudiante,
 *   recorridoInorden, recorridoPreorden, recorridoPostorden, recorridoPorNiveles,
 *   contarNodos, calcularAltura, buscarNotaMayor, buscarNotaMenor,
 *   mostrarAprobados, mostrarReprobados
 */
public class ArbolBST {

    private Nodo raiz;

    public ArbolBST() {
        raiz = null;
    }

    // 1. Insertar estudiante

    /** Inserta un nuevo estudiante en el árbol (la cédula debe ser única). */
    public void insertarEstudiante(Estudiante e) {
        raiz = insertarRec(raiz, e);
    }

    private Nodo insertarRec(Nodo nodo, Estudiante e) {
        if (nodo == null) {
            System.out.println("✔ Estudiante " + e.getNombres() + " " + e.getApellidos() + " insertado correctamente.");
            return new Nodo(e);
        }

        int cmp = e.getCedula().compareTo(nodo.estudiante.getCedula());

        if (cmp < 0) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, e);
        } else if (cmp > 0) {
            nodo.derecho = insertarRec(nodo.derecho, e);
        } else {
            System.out.println(" Ya existe un estudiante con la cédula: " + e.getCedula());
        }
        return nodo;
    }

    // 2. Buscar estudiante

    /** Busca un estudiante por cédula. Devuelve null si no existe. */
    public Estudiante buscarEstudiante(String cedula) {
        Nodo resultado = buscarRec(raiz, cedula);
        if (resultado == null) {
            System.out.println(" No se encontró estudiante con cédula: " + cedula);
            return null;
        }
        System.out.println(" Estudiante encontrado:");
        resultado.estudiante.mostrar();
        return resultado.estudiante;
    }

    private Nodo buscarRec(Nodo nodo, String cedula) {
        if (nodo == null) return null;

        int cmp = cedula.compareTo(nodo.estudiante.getCedula());
        if (cmp == 0) return nodo;
        if (cmp <  0) return buscarRec(nodo.izquierdo, cedula);
        return           buscarRec(nodo.derecho,    cedula);
    }

    // 3. Eliminar estudiante

    /** Elimina el estudiante con la cédula dada del árbol. */
    public void eliminarEstudiante(String cedula) {
        if (buscarRec(raiz, cedula) == null) {
            System.out.println(" No se encontró estudiante con cédula: " + cedula);
            return;
        }
        raiz = eliminarRec(raiz, cedula);
        System.out.println(" Estudiante con cédula " + cedula + " eliminado correctamente.");
    }

    private Nodo eliminarRec(Nodo nodo, String cedula) {
        if (nodo == null) return null;

        int cmp = cedula.compareTo(nodo.estudiante.getCedula());

        if (cmp < 0) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, cedula);
        } else if (cmp > 0) {
            nodo.derecho = eliminarRec(nodo.derecho, cedula);
        } else {
            // Nodo encontrado — tres casos:
            // Caso 1: Nodo hoja (sin hijos)
            if (nodo.izquierdo == null && nodo.derecho == null) return null;

            // Caso 2: Un solo hijo
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho   == null) return nodo.izquierdo;

            // Caso 3: Dos hijos → buscar sucesor inorden (mínimo del subárbol derecho)
            Nodo sucesor = minimoNodo(nodo.derecho);
            nodo.estudiante = sucesor.estudiante;
            nodo.derecho    = eliminarRec(nodo.derecho, sucesor.estudiante.getCedula());
        }
        return nodo;
    }

    /** Devuelve el nodo con la cédula mínima en el subárbol dado. */
    private Nodo minimoNodo(Nodo nodo) {
        while (nodo.izquierdo != null) nodo = nodo.izquierdo;
        return nodo;
    }

    // 4. Recorridos

    /** Recorrido Inorden: Izquierdo → Raíz → Derecho (ordena por cédula). */
    public void recorridoInorden() {
        System.out.println("\n══════════ RECORRIDO INORDEN ══════════");
        if (raiz == null) { System.out.println("El árbol está vacío."); return; }
        inordenRec(raiz);
        System.out.println("═══════════════════════════════════════\n");
    }

    private void inordenRec(Nodo nodo) {
        if (nodo == null) return;
        inordenRec(nodo.izquierdo);
        System.out.println(nodo.estudiante);
        inordenRec(nodo.derecho);
    }

    /* Recorrido Preorden: Raíz → Izquierdo → Derecho. */
    public void recorridoPreorden() {
        System.out.println("\n══════════ RECORRIDO PREORDEN ══════════");
        if (raiz == null) { System.out.println("El árbol está vacío."); return; }
        preordenRec(raiz);
        System.out.println("════════════════════════════════════════\n");
    }

    private void preordenRec(Nodo nodo) {
        if (nodo == null) return;
        System.out.println(nodo.estudiante);
        preordenRec(nodo.izquierdo);
        preordenRec(nodo.derecho);
    }

    /** Recorrido Postorden: Izquierdo → Derecho → Raíz. */
    public void recorridoPostorden() {
        System.out.println("\n══════════ RECORRIDO POSTORDEN ══════════");
        if (raiz == null) { System.out.println("El árbol está vacío."); return; }
        postordenRec(raiz);
        System.out.println("═════════════════════════════════════════\n");
    }

    private void postordenRec(Nodo nodo) {
        if (nodo == null) return;
        postordenRec(nodo.izquierdo);
        postordenRec(nodo.derecho);
        System.out.println(nodo.estudiante);
    }

    /** Recorrido por Niveles (BFS) usando una Queue. */
    public void recorridoPorNiveles() {
        System.out.println("\n══════════ RECORRIDO POR NIVELES (BFS) ══════════");
        if (raiz == null) { System.out.println("El árbol está vacío."); return; }

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        int nivel = 1;

        while (!cola.isEmpty()) {
            int tamañoNivel = cola.size();
            System.out.println("  ── Nivel " + nivel + " ──");

            for (int i = 0; i < tamañoNivel; i++) {
                Nodo actual = cola.poll();
                System.out.println("    " + actual.estudiante);

                if (actual.izquierdo != null) cola.add(actual.izquierdo);
                if (actual.derecho   != null) cola.add(actual.derecho);
            }
            nivel++;
        }
        System.out.println("═════════════════════════════════════════════════\n");
    }

    // 5. Funciones avanzadas

    /** Cuenta el total de nodos (estudiantes) en el árbol. */
    public int contarNodos() {
        int total = contarRec(raiz);
        System.out.println("Total de estudiantes en el árbol: " + total);
        return total;
    }

    private int contarRec(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + contarRec(nodo.izquierdo) + contarRec(nodo.derecho);
    }

    /** Calcula la altura del árbol (número de niveles). */
    public int calcularAltura() {
        int altura = alturaRec(raiz);
        System.out.println(" Altura del árbol: " + altura + " niveles.");
        return altura;
    }

    private int alturaRec(Nodo nodo) {
        if (nodo == null) return 0;
        int altIzq = alturaRec(nodo.izquierdo);
        int altDer = alturaRec(nodo.derecho);
        return 1 + Math.max(altIzq, altDer);
    }

    /** Busca y muestra el estudiante con la nota más alta. */
    public void buscarNotaMayor() {
        if (raiz == null) { System.out.println("El árbol está vacío."); return; }
        Nodo resultado = notaMayorRec(raiz, raiz);
        System.out.println("\n Estudiante con mayor nota:");
        resultado.estudiante.mostrar();
    }

    private Nodo notaMayorRec(Nodo nodo, Nodo mayor) {
        if (nodo == null) return mayor;
        if (nodo.estudiante.getNotaFinal() > mayor.estudiante.getNotaFinal()) mayor = nodo;
        Nodo deIzq = notaMayorRec(nodo.izquierdo, mayor);
        return        notaMayorRec(nodo.derecho,    deIzq);
    }

    /** Busca y muestra el estudiante con la nota más baja. */
    public void buscarNotaMenor() {
        if (raiz == null) { System.out.println("El árbol está vacío."); return; }
        Nodo resultado = notaMenorRec(raiz, raiz);
        System.out.println("\n Estudiante con menor nota:");
        resultado.estudiante.mostrar();
    }

    private Nodo notaMenorRec(Nodo nodo, Nodo menor) {
        if (nodo == null) return menor;
        if (nodo.estudiante.getNotaFinal() < menor.estudiante.getNotaFinal()) menor = nodo;
        Nodo deIzq = notaMenorRec(nodo.izquierdo, menor);
        return        notaMenorRec(nodo.derecho,    deIzq);
    }

    /** Muestra todos los estudiantes con nota >= 7.0 (aprobados). */
    public void mostrarAprobados() {
        System.out.println("\n ESTUDIANTES APROBADOS (nota ≥ 7.0):");
        System.out.println("─────────────────────────────────────────");
        int[] contador = {0};
        aprobadosRec(raiz, contador);
        if (contador[0] == 0) System.out.println("  No hay estudiantes aprobados.");
        System.out.println("Total aprobados: " + contador[0] + "\n");
    }

    private void aprobadosRec(Nodo nodo, int[] contador) {
        if (nodo == null) return;
        aprobadosRec(nodo.izquierdo, contador);
        if (nodo.estudiante.getNotaFinal() >= 7.0) {
            System.out.println("  " + nodo.estudiante);
            contador[0]++;
        }
        aprobadosRec(nodo.derecho, contador);
    }

    /** Muestra todos los estudiantes con nota < 7.0 (reprobados). */
    public void mostrarReprobados() {
        System.out.println("\n ESTUDIANTES REPROBADOS (nota < 7.0):");
        System.out.println("─────────────────────────────────────────");
        int[] contador = {0};
        reprobadosRec(raiz, contador);
        if (contador[0] == 0) System.out.println("  No hay estudiantes reprobados.");
        System.out.println("Total reprobados: " + contador[0] + "\n");
    }

    private void reprobadosRec(Nodo nodo, int[] contador) {
        if (nodo == null) return;
        reprobadosRec(nodo.izquierdo, contador);
        if (nodo.estudiante.getNotaFinal() < 7.0) {
            System.out.println("  " + nodo.estudiante);
            contador[0]++;
        }
        reprobadosRec(nodo.derecho, contador);
    }

    /** Indica si el árbol está vacío. */
    public boolean estaVacio() {
        return raiz == null;
    }
}
