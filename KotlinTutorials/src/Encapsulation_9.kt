/**
 * Created by shuja1497 on 6/4/19.
 */
fun main(args: Array<String>){

    val inst1 = Player("inst1",8, 4)
    val inst2 = Player("inst2",5, 2, 1000)

    val sword = Weapon("Sword", 10)
    val spear = Weapon("Spear", 24)

    inst1.weapon = sword
    inst1.show()

    inst2.weapon = inst1.weapon
    inst2.show()

    inst1.weapon = spear

    inst1.show()
    inst2.show()

    val redPotion = Loot("Red Potion", LootType.POTION, 10.00)
    val chestArmor  = Loot("+3 Chest Armor", LootType.ARMOR, 50.00)

    inst1.getLoot(redPotion)
    inst1.getLoot(chestArmor)
    inst1.showInventory()

    inst1.getLoot(Loot("Ring of Protection +2", LootType.RING, 40.00))
    inst1.getLoot(Loot("Invisibility Potion", LootType.POTION, 30.00))
    inst1.showInventory()

    if (inst1.dropLoot(redPotion)){
        inst1.showInventory()
    }else{
        println("You don't have a ${redPotion.name}")
    }

}
