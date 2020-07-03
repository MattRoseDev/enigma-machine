import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.io.Source

object Enigma {
    var plain = ""
    def main(args: Array[String]): Unit = {
        if(args.length > 0) {
            args.map(arg => {
                plain += arg
            })
            var result = enigma(plain)
            println(result)
        }
    }

    var alphabet = Source.fromFile("alphabet.txt").getLines.mkString
    var rotors =  Source.fromFile("todayRotors.enigma").getLines.toArray

    def reflector(char: Char): Char = {
        return alphabet(alphabet.length - alphabet.indexOf(char) - 1)
    }

    def enigmaOneChar(char: Char): Char = {
        var char1 = rotors(0)(alphabet.indexOf(char))
        var char2 = rotors(1)(alphabet.indexOf(char1))
        var char3 = rotors(2)(alphabet.indexOf(char2))
        var reflected = reflector(char3)
        char3 = alphabet(rotors(2).indexOf(reflected))
        char2 = alphabet(rotors(1).indexOf(char3))
        char1 = alphabet(rotors(0).indexOf(char2))

        return char1
    }

    def enigma(plain: String): String = {
        var cipher: String = ""
        
        plain.map(char => {
            rotateRotors()
            cipher += enigmaOneChar(char)
        })
        return cipher
    }

    var state = 0

    def rotateRotors(): Unit = {
        rotors(0) = rotors(0).substring(1) + rotors(0)(0)
        if(state % 26 == 0) 
            rotors(1) = rotors(1).substring(1) + rotors(1)(0)
        if(state % (26 * 26) == 0) 
            rotors(2) = rotors(2).substring(1) + rotors(2)(0)
    }
}
