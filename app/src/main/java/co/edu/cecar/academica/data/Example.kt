package co.edu.cecar.academica.data

fun main() {
    val s1 = Studiant(1, "Luis", 23)
    val s2 = Studiant(1, "Moises", 38)
    val s3 = Studiant(1, "David", 25)
    val students = listOf(s1, s2, s3)
    val filters = students.filter {
        it.edad >= 25
    }
    val employes = filters.map {
        val empls = Employee(it.id, it.name)
        empls
    }
    print("resul = $employes")

}

data class Studiant(
    val id: Int,
    val name: String,
    val edad: Int
)

data class Employee(
    val id: Int,
    val name: String
)