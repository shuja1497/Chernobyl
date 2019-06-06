fun main(args: Array<String>){

    val dracula = VampireKing("dracula")
    println(dracula)

    while (dracula.lives > 0) {

        if (dracula.dodges()){
            continue // skips rest of the block
        }

        if (dracula.runAway()) {
            println("Dracula ran away!")
            break
        } else {
            dracula.takeDamage(8)
        }
    }
    println()
}
