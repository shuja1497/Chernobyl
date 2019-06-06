/**
 * Created by shuja1497 on 6/3/19.
 */
// damagingPower can be increased using some magical spell so var
class Weapon(val name: String, var damagingPower: Int){

    override fun toString(): String {
        return """
            weapon name : $name
            weapon damagingPower: $damagingPower
            """
    }
}