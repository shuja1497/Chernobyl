fun main(args: Array<String>){

    val lives = 3

    val isGameOver = lives < 1

    if (isGameOver){
        println("Game Over!")
    }else{
        println(" Still Alive!")
    }

    println("How old are you?: ")
    val age  = readLine()!!.toInt()
    println("Age is $age")

    var message: String
    message = if (age < 18){
        "Not eligible to vote!"
    } else if(age == 100){
        "Congratulations"
    } else{
        "You can vote!"
    }

    message = when {
        age < 18 -> "Not eligible to vote!"
        age == 100 -> "Congratulations"
        else -> "You can vote!"
    }

    println(message)

}
