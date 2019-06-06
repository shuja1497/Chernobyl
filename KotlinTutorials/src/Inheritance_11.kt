/**
 * Created by shuja1497 on 6/4/19.
 */
fun main(args: Array<String>){

    println("========= 1st-part ==========")
    val enemy   = Enemy("test enemy", 10, 3)
    println(enemy)
    enemy.takeDamage(4)
    println(enemy)
    enemy.takeDamage(10)
    println(enemy)
    println()

    println("========= 2nd-part ==========")
    val uglyTroll = Troll("Ugly Troll")
    println(uglyTroll)
    uglyTroll.takeDamage(30)
    println(uglyTroll)
    println()

    println("========= 3rd-part ==========")
    val vlad   = Vampire("Vlad")
    println(vlad)
    vlad.takeDamage(8)
    println(vlad)
    println()

    println("========= 4th-part ==========")
    val dracula = VampireKing("dracula")
    println(dracula)
    dracula.takeDamage(8)
    println(dracula)
    println()
}
