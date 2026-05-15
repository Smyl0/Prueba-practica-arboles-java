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

## 🗂 Estructura del proyecto

```
prueba-practica-arboles-cpp-java/
└── java/
    ├── Estudiante.java   # Modelo de datos del estudiante
    ├── Nodo.java         # Nodo del árbol BST
    ├── ArbolBST.java     # Lógica del árbol (insertar, buscar, eliminar, recorridos...)
    └── Main.java         # Punto de entrada — menú interactivo
```

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
```

---

## 📌 Funciones implementadas

| Función | Descripción |
|---|---|
| `insertarEstudiante()` | Inserta un nodo nuevo en el BST según la cédula |
| `buscarEstudiante()` | Búsqueda O(log n) por cédula |
| `eliminarEstudiante()` | Eliminación con los 3 casos del BST (hoja, 1 hijo, 2 hijos) |
| `recorridoInorden()` | Iz → Raíz → Der (lista ordenada por cédula) |
| `recorridoPreorden()` | Raíz → Iz → Der |
| `recorridoPostorden()` | Iz → Der → Raíz |
| `recorridoPorNiveles()` | BFS con Queue — muestra nivel por nivel |
| `contarNodos()` | Cuenta total de estudiantes (recursivo) |
| `calcularAltura()` | Altura del árbol en niveles (recursivo) |
| `buscarNotaMayor()` | Recorre todo el árbol buscando la nota más alta |
| `buscarNotaMenor()` | Recorre todo el árbol buscando la nota más baja |
| `mostrarAprobados()` | Estudiantes con nota ≥ 7.0 |
| `mostrarReprobados()` | Estudiantes con nota < 7.0 |

---

## 🖥 Menú del sistema

```
╔══════════════════════════════════════════════╗
║   SISTEMA ACADÉMICO — UNIVERSIDAD TEC. AMBATO  ║
╠══════════════════════════════════════════════╣
║  1.  Insertar estudiante                     ║
║  2.  Buscar estudiante por cédula            ║
║  3.  Eliminar estudiante                     ║
║  4.  Recorrido Inorden                       ║
║  5.  Recorrido Preorden                      ║
║  6.  Recorrido Postorden                     ║
║  7.  Recorrido por niveles (BFS)             ║
║  8.  Contar estudiantes                      ║
║  9.  Calcular altura del árbol               ║
║  10. Mostrar estudiante con mayor nota       ║
║  11. Mostrar estudiante con menor nota       ║
║  12. Mostrar estudiantes aprobados           ║
║  13. Mostrar estudiantes reprobados          ║
║  14. Salir                                   ║
╚══════════════════════════════════════════════╝
```

---

## 🔧 Conceptos técnicos aplicados

- **Árbol Binario de Búsqueda (BST):** inserción, búsqueda y eliminación O(log n)
- **Recursividad:** todos los recorridos y funciones avanzadas usan recursión
- **BFS con Queue:** `recorridoPorNiveles()` usa `java.util.LinkedList` como cola
- **POO:** clases `Estudiante`, `Nodo`, `ArbolBST` y `Main` desacopladas
- **Validación de datos:** cédula de 10 dígitos, nota 0-10, nivel 1-10
- **Eliminación de 3 casos:**
  1. Nodo hoja → se elimina directamente
  2. Un solo hijo → se reemplaza con el hijo
  3. Dos hijos → se busca el sucesor inorden (mínimo del subárbol derecho)

---

## 👤 Autor

Universidad Técnica de Ambato  
Asignatura: Estructura de Datos
