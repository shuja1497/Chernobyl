/**
 * Created by shuja1497 on 6/2/19.
 */
class Player(val name: String, var lives: Int = 3, var level: Int = 1, var score: Int = 0) {

    // a player can change a weapon so var
    var weapon: Weapon = Weapon("Fist", 1)

    private val inventory = ArrayList<Loot>()

    fun show(){

        if(lives > 0){
            println("$name is still alive!")
        }else{
            println("$name is dead!")
        }
    }

    override fun toString(): String {

        // now this will be returned instead of object with hashcode

        return """
            name:  $name
            lives: $lives
            level: $level
            score: $score
            weapon: $weapon)
            """
    }

    fun getLoot(item: Loot){
        // Encapsulation: Hiding the inside working of a class
        // inventory is encapsulated
        inventory.add(item)
    }

    fun dropLoot(item: Loot): Boolean{
        return if(inventory.contains(item)){
            inventory.remove(item)
            true
        }else{
            false
        }
    }

    fun dropLoot(lootName: String): Boolean{
        return inventory.removeIf { it.name == lootName }
    }

    fun showWeapon(){
        println("""
            player : $name
            weapon name: ${weapon.name}
            weapon damaging power: ${weapon.damagingPower})
            """)
    }

    fun showInventory(){
        println("Inventory:")
        inventory.forEach {
            println("-->> $it")
        }
    }
}