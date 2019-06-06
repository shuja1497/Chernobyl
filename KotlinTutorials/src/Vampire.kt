/**
 * Created by shuja1497 on 6/4/19.
 */
open class Vampire(name: String) : Enemy(name, 20, 3) {

    override fun takeDamage(damage: Int) {
        // vampire takes half the damage
        super.takeDamage(damage / 2)
    }
}