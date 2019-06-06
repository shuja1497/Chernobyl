fun main(args: Array<String>){

    val inst1 = Player("inst1",8, 4)
    val inst2 = Player("inst2",5, 2, 1000)

    inst1.show()
    inst2.show()

    println(inst1.weapon.name.toUpperCase())
    println(inst1.weapon.damagingPower)

    val axe = Weapon("Axe", 12)
    inst2.weapon = axe
    println(inst2.weapon.name)
    println(axe.name)

    axe.damagingPower = 24
    println(axe.damagingPower)
    println(inst2.weapon.damagingPower) // both pointing to the same axe object

    println(inst2.showWeapon())

    inst2.weapon = Weapon("Sword", 10)
    println(inst2.showWeapon())
}
