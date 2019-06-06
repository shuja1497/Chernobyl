fun main(args: Array<String>){
    println("Hello World")
    println("My first kotlin program")
    val name = "Shuja"
    println(name)

    val sal = 15
    val monthly = sal * 4
    println(sal)
    println(monthly)
    println()

    val apples = 6
    val oranges = 5
    val fruits = apples - oranges
    println(fruits)
    println("A quarter of apples is ${apples / 4}") // quotient
    println(apples % 4) // remainder
    println()

    val weeks = 130
    val years = weeks / 52.0
    val yearsInt = weeks / 52
    println(years)
    println(yearsInt)
    println("$weeks weeks in years is $years")
    println("My name is $name")

    println("i can write \$name")

}
