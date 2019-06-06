fun main(args: Array<String>){

    for (i in 1..5){ // including 5
        println("$i squared is ${i*i}")
    }

    println("****")
    for (i in 1 until 5){ // excluding 5
        println("$i squared is ${i*i}")
    }

    println("****")
    for (i in 5 downTo 0){ // excluding 5
        println("$i squared is ${i*i}")
    }

    println("****")
    for (i in 5 downTo 0 step 2){ // excluding 5
        println("$i squared is ${i*i}")
    }

    println("****")
    for (i in 3..100 step 3){
        if(i%5 == 0){
            println(i)
        }
    }

}
