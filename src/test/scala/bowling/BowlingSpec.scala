package bowling

import org.scalatest.{FunSpec, Matchers}

class BowlingSpec extends FunSpec with Matchers {
    describe("A Bowling") {
        describe("when only one empty roll") {
            it("should have score of 0") {
                assert(Bowling().addRoll(Roll.empty).score == 0)
            }
        }

        describe("when only empty rolls") {
            it("should have score of 0") {
                assert(Bowling().addSameRolls(Roll.empty).score == 0)
            }
        }

        describe("when only Strike") {
            it("should have score of 300") {
                assert(Bowling().addSameRolls(Roll.strike).score == 300)
            }
        }

        describe("when only rolls of 1 pin") {
            it("should have score of 20") {
                assert(Bowling().addSameRolls(Roll.onePin).score == 20)
            }
        }
        
    }
}
