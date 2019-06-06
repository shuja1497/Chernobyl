/**
 * Created by shuja1497 on 6/3/19.
 */

enum class LootType{
    POTION, RING, ARMOR
}

class Loot(val name: String, val type: LootType, val value: Double){

    override fun toString(): String {
        return """
            loot name: $name
            loot type: $type
            loot value: $value
            """
    }
}