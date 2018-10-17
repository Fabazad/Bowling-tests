package bowling

case class Bowling(val score: Int = 0, val needToDouble: Int = 0){
    def addRoll(roll: Roll, last: Boolean = false): Bowling = {
        val newScore: Int = if(needToDouble == 2)  
                                if(roll.isStrike) 
                                    if(last) score + roll.first*2
                                    else score + roll.first*3
                                else score + roll.first*2 + roll.second*2
                            else if(needToDouble == 1) score + roll.first*2
                            else if(roll.isStrike) score + roll.first
                            else score + roll.first + roll.second
        
        println(score)
        if(roll.isStrike) this.copy(score = newScore, needToDouble = 2)
        else if (roll.isSpare) this.copy(score = newScore, needToDouble = 1)
        else this.copy(score = newScore, needToDouble = 0)
    }

    def addSameRolls(roll: Roll): Bowling = {
        def addSameRollsBis(roll: Roll, acc: Int, bowling: Bowling): Bowling = {
            if(acc == 0)
                if(roll.isStrike) bowling.addRoll(roll, true)
                else bowling
            else addSameRollsBis(roll, acc - 1, bowling.addRoll(roll))
        }
        addSameRollsBis(roll, 10, this)
    }
}

object Bowling {
}
