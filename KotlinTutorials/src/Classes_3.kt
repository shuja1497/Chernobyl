/**
 * Created by shuja1497 on 6/3/19.
 */
fun main(args: Array<String>){

    val shuja  = Player("shuja")
    // shuja is an instance of Player class having all the properties of that class
//    println(shuja.name)
//    println(shuja.lives)
//    println(shuja.level)
//    println(shuja.score)
    shuja.show()

    val tim  = Player("tim", level = 5)
//    tim.level = 5
    tim.show()

    val inst1 = Player("inst1",8, 4)
    val inst2 = Player("inst2",5, 2, 1000)

    inst1.show()
    inst2.show()
}
