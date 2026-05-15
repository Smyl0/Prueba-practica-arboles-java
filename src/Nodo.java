/*
 * Nodo del árbol binario de búsqueda.
 * Contiene un Estudiante y referencias al hijo izquierdo y derecho.
 */
public class Nodo {
    Estudiante estudiante;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.izquierdo  = null;
        this.derecho    = null;
    }
}
