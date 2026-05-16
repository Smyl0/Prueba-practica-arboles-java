# 🌳 Sistema Académico UTA — Árbol Binario de Búsqueda en Java

**Asignatura:** Estructura de Datos  
**Universidad:** Universidad Técnica de Ambato  
**Tema:** Árboles binarios, recorridos y aplicación práctica  
**Lenguaje:** Java (POO)

---

## 📋 Descripción

Sistema académico que gestiona estudiantes mediante un **Árbol Binario de Búsqueda (BST)**.  
Cada estudiante contiene: cédula (clave), apellidos, nombres, nota final, carrera y nivel.  
La cédula es la clave de comparación del BST (orden lexicográfico).

---

## 🖥️ Menú principal del sistema

![Menú Principal](Capturas_Ejecucion/Menu_Principal.png)

---

## 🗂 Estructura del proyecto
prueba-practica-arboles-cpp-java/
└── java/
├── Estudiante.java # Modelo de datos del estudiante
├── Nodo.java # Nodo del árbol BST
├── ArbolBST.java # Lógica del árbol (insertar, buscar, eliminar, recorridos...)
└── Main.java # Punto de entrada — menú interactivo

---

## ⚙️ Compilación y ejecución

### Requisitos
- Java JDK 17 o superior  
- Terminal / CMD

### Pasos

```bash
# 1. Entrar a la carpeta del proyecto
cd java/

# 2. Compilar todos los archivos
javac *.java

# 3. Ejecutar
java Main
📌 Funciones implementadas (con capturas)
Función	Descripción	Captura
insertarEstudiante()	Inserta un nodo nuevo en el BST según la cédula	https://Capturas_Ejecucion/Opcion_1.png
buscarEstudiante()	Búsqueda O(log n) por cédula	https://Capturas_Ejecucion/Opcion_2.png
eliminarEstudiante()	Eliminación con los 3 casos del BST	https://Capturas_Ejecucion/Opcion_3.png
recorridoInorden()	Iz → Raíz → Der (ordenado por cédula)	https://Capturas_Ejecucion/Opcion_4.png
recorridoPreorden()	Raíz → Iz → Der	https://Capturas_Ejecucion/Opcion_5.png
recorridoPostorden()	Iz → Der → Raíz	https://Capturas_Ejecucion/Opcion_6.png
recorridoPorNiveles()	BFS con Queue — nivel por nivel	https://Capturas_Ejecucion/Opcion_7.png
contarNodos()	Cuenta total de estudiantes	https://Capturas_Ejecucion/Opcion_8.png
calcularAltura()	Altura del árbol en niveles	https://Capturas_Ejecucion/Opcion_9.png
buscarNotaMayor()	Estudiante con nota más alta	https://Capturas_Ejecucion/Opcion_10.png
buscarNotaMenor()	Estudiante con nota más baja	https://Capturas_Ejecucion/Opcion_11.png
mostrarAprobados()	Estudiantes con nota ≥ 7.0	https://Capturas_Ejecucion/Opcion_12.png
mostrarReprobados()	Estudiantes con nota < 7.0	https://Capturas_Ejecucion/Opcion_13.png
salir()	Finaliza el programa	https://Capturas_Ejecucion/Opcion_14.png
🧪 Datos de ejemplo precargados
https://Capturas_Ejecucion/Cargar_Datos_Prueba.png

🔧 Conceptos técnicos aplicados
Árbol Binario de Búsqueda (BST): inserción, búsqueda y eliminación O(log n)

Recursividad: todos los recorridos y funciones avanzadas usan recursión

BFS con Queue: recorridoPorNiveles() usa java.util.LinkedList

POO: clases desacopladas

Validación de datos: cédula (10 dígitos), nota (0-10), nivel (1-10)

👤 Autor
Estudiante — Universidad Técnica de Ambato
Asignatura: Estructura de Datos
