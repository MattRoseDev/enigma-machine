import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.util.Random
import scala.io.Source
import java.io.File

object Rotor {
    var alphabet = ""
    var rotors = ArrayBuffer()
    def main(args: Array[String]): Unit = {
        if(args.length > 0 && args(0) == "generate") generate()
    }

    def generate(): Unit = {
        alphabet = Source.fromFile("alphabet.txt").getLines.mkString

        var writer = new PrintWriter(new File("todayRotors.enigma"))
        for(i <- 0 to 2) {
            writer.write(makeRotor())
            writer.write("\n")
        }
        writer.close()
    }

    def makeRotor(): String = {
        var array = ArrayBuffer[String]()
        alphabet.map(char => {
            array.append(char.toString())
        })
        
        return Random.shuffle(array).mkString
    }
}
