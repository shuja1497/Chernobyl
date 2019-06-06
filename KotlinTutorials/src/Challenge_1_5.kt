fun main(args: Array<String>){

    val inst1 = Player("inst1",8, 4)
    val inst2 = Player("inst2",5, 2, 1000)

    val axe = Weapon("Axe", 12)
    val sword = Weapon("Sword", 10)
    val spear = Weapon("Spear", 24)

    inst1.weapon = sword
    inst1.show()

    inst2.weapon = inst1.weapon
    inst2.show()

    inst1.weapon = spear

    inst1.show()
    inst2.show()


}
