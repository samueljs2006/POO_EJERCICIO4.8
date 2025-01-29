class Libro(val titulo: String, val autor: String, val paginas: Int, val calificacion: Int) {
    override fun toString(): String {
        return "Título: $titulo, Autor: $autor, Páginas: $paginas, Calificación: $calificacion"
    }
}

class ConjuntoLibros(private val capacidad: Int) {
    private val libros = mutableListOf<Libro>()

    fun agregarLibro(libro: Libro) {
        if (libros.size < capacidad) {
            if (!libros.any { it.titulo == libro.titulo }) {
                libros.add(libro)
                println("Libro agregado: ${libro.titulo}")
            } else {
                println("El libro ya existe en la colección.")
            }
        } else {
            println("No hay espacio para más libros.")
        }
    }

    fun eliminarPorTitulo(titulo: String) {
        val removido = libros.removeIf { it.titulo == titulo }
        if (removido) println("Libro con título '$titulo' eliminado.")
        else println("No se encontró un libro con ese título.")
    }

    fun eliminarPorAutor(autor: String) {
        val removido = libros.removeIf { it.autor == autor }
        if (removido) println("Libros del autor '$autor' eliminados.")
        else println("No se encontraron libros de ese autor.")
    }

    fun mostrarMayorYMenorCalificacion() {
        if (libros.isEmpty()) {
            println("No hay libros en la colección.")
            return
        }
        val maxCalificacion = libros.maxByOrNull { it.calificacion }
        val minCalificacion = libros.minByOrNull { it.calificacion }
        println("Libro con mayor calificación: $maxCalificacion")
        println("Libro con menor calificación: $minCalificacion")
    }

    fun mostrarContenido() {
        if (libros.isEmpty()) {
            println("No hay libros en la colección.")
        } else {
            libros.forEach { println(it) }
        }
    }
}

fun main() {
    val conjunto = ConjuntoLibros(5)

    val libro1 = Libro("El principito", "Antoine de Saint-Exupéry", 96, 9)
    val libro2 = Libro("1984", "George Orwell", 328, 10)

    conjunto.agregarLibro(libro1)
    conjunto.agregarLibro(libro2)

    conjunto.mostrarContenido()

    conjunto.eliminarPorTitulo("1984")
    conjunto.eliminarPorAutor("Antoine de Saint-Exupéry")

    conjunto.mostrarContenido()

    val libro3 = Libro("Cien años de soledad", "Gabriel García Márquez", 417, 10)
    conjunto.agregarLibro(libro3)

    conjunto.mostrarContenido()
}
