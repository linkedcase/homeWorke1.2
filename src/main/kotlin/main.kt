const val PEOPLE = "людям"
const val HUMAN = "человеку"

fun main() {
    val likes: UInt = 201U

    if (likes == 11U) {
        println("Понравилось $likes $PEOPLE")
    } else if (likes % 10U == 1U) {
        println("Понравилось $likes $HUMAN")
    } else print("Понравилось $likes $PEOPLE")
}
