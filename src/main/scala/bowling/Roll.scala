package bowling

case class Roll(val first: Int, val second: Int){
    def isStrike(): Boolean = {
        first == 10
    }

    def isSpare(): Boolean = {
        first + second == 10 && first != 10
    }
}

object Roll{
    def empty: Roll = {
        Roll(0,0)
    }

    def onePin: Roll = {
        Roll(1,1)
    }

    def strike: Roll = {
        Roll(10,0)
    }
}