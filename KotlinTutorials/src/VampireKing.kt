import java.util.*

/**
 * Created by shuja1497 on 6/4/19.
 */
class VampireKing(name: String) : Vampire(name) {

    init {
        // executed when instance is created
        hitPoints = 140
    }

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage / 2)
    }

    fun runAway() : Boolean{
        return  lives < 2
    }

    fun dodges(): Boolean{
        val rand = Random()
        val chance = rand.nextInt(6)
        return if (chance > 3){
            println("Dracula dodges")
            true
        }else{
            false
        }
    }
}