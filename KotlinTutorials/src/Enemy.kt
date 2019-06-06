/**
 * Created by shuja1497 on 6/4/19.
 */

// koltin classes cannot be extended by default so in order to make them extended we need to make it open

open class Enemy(val name: String, var hitPoints: Int, var lives: Int){

    open fun takeDamage(damage: Int){
        val remainingHitPoints  = hitPoints - damage

        if(remainingHitPoints > 0){
            hitPoints = remainingHitPoints
            println("$name took $damage points of damage and $hitPoints left")
        }else{
            lives -= 1
            if(lives > 0) {
                println("$name lost a life")
            }else{
                println("$name is dead")
            }
        }
    }

    override fun toString(): String {
        return "name: $name, hitPoints: $hitPoints, lives: $lives "
    }
}