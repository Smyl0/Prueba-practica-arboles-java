/**
 * Clase que representa a un estudiante en el árbol binario de búsqueda.
 * La cédula es la clave de comparación del BST.
 */
public class Estudiante {
    private String cedula;
    private String apellidos;
    private String nombres;
    private double notaFinal;
    private String carrera;
    private int nivel;

    public Estudiante(String cedula, String apellidos, String nombres,
                      double notaFinal, String carrera, int nivel) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.notaFinal = notaFinal;
        this.carrera = carrera;
        this.nivel = nivel;
    }

    // Getters
    public String getCedula()    { return cedula; }
    public String getApellidos() { return apellidos; }
    public String getNombres()   { return nombres; }
    public double getNotaFinal() { return notaFinal; }
    public String getCarrera()   { return carrera; }
    public int    getNivel()     { return nivel; }

    /** Muestra los datos del estudiante en consola. */
    public void mostrar() {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.printf ("│  Cédula  : %-30s│%n", cedula);
        System.out.printf ("│  Nombre  : %-30s│%n", apellidos + " " + nombres);
        System.out.printf ("│  Nota    : %-30.2f│%n", notaFinal);
        System.out.printf ("│  Carrera : %-30s│%n", carrera);
        System.out.printf ("│  Nivel   : %-30d│%n", nivel);
        System.out.println("└─────────────────────────────────────────┘");
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %s | Nota: %.2f | %s - Nivel %d",
                cedula, apellidos, nombres, notaFinal, carrera, nivel);
    }
}
