import TrigonometricFunctions.Companion.EPS
import java.io.File
import java.io.FileNotFoundException
import java.io.FileWriter
import kotlin.math.PI
import kotlin.math.pow
import kotlin.random.Random


open class Functions(var tf : TrigonometricFunctions = TrigonometricFunctions(), var lf: LogarithmFunctions = LogarithmFunctions()){

    private val CSV_HEADER = "x,sin(x),cos(x),tan(x),cot(x),sec(x),ln(x),log_2,log_3,log_5,log_10,F(X)\n"
    private val FILENAME = "output.csv"

    open fun compute(x : Double) = if (x<=0) firstFunction(x) else secondFunction(x)

    //solve from left -> right
    // x <= 0 : (((((sec(x) * cot(x)) ^ 2) + cot(x)) - tan(x)) + (tan(x) ^ 2))
    open fun firstFunction(x: Double) : Double {
        val firstParenthesis = tf.sec(x, EPS) * tf.cot(x,EPS)
        val secondParenthesis = firstParenthesis * firstParenthesis
        val thirdParenthesis = secondParenthesis + tf.cot(x,EPS)
        val fourthParenthesis = thirdParenthesis - tf.tan(x,EPS)
        val fifthParenthesis = tf.tan(x,EPS) * tf.tan(x,EPS)
        if (fifthParenthesis.isNaN() || secondParenthesis.isNaN() || thirdParenthesis.isNaN() || fourthParenthesis.isNaN() || fifthParenthesis.isNaN()) return Double.NaN
        return fourthParenthesis + fifthParenthesis
    }

    //x > 0 : (((((ln(x) - ln(x)) / log_10(x)) ^ 3) - (log_2(x) + (ln(x) ^ 3))) * ((log_3(x) / log_2(x)) - ((log_2(x) - log_3(x)) / (ln(x) + log_5(x)))))
    open fun secondFunction(x: Double) : Double{
        return (((((lf.ln(x,EPS) - lf.ln(x,EPS)) / lf.log_10(x,EPS)).pow(3)) -
                (lf.log_2(x,EPS) + (lf.ln(x,EPS).pow(3))))
                * ((lf.log_3(x,EPS) / lf.log_2(x,EPS)) - ((lf.log_2(x,EPS) - lf.log_3(x,EPS)) / (lf.ln(x,EPS) + lf.log_5(x,EPS)))))
    }


    inline fun Double.format(digits: Int) = "%.${digits}g".format(this)

    fun createSCV(from: Double, to: Double, step: Double) {
        var fileWriter = try {
            FileWriter(FILENAME)
        } catch (e: FileNotFoundException) {
            File(FILENAME).createNewFile()
            FileWriter(FILENAME)
        }
        fileWriter.append(CSV_HEADER)
        var cur = from
        while (cur < to) {
            fileWriter.append(
                "${cur}," +
                        "${tf.sin(cur, EPS)}," +
                        "${tf.cos(cur,EPS)}," +
                        "${tf.tan(cur, EPS)}," +
                        "${tf.cot(cur, EPS)}," +
                        "${tf.sec(cur, EPS)}," +
                        "${lf.ln(cur, EPS)}," +
                        "${lf.log_2(cur, EPS)}," +
                        "${lf.log_3(cur, EPS)},"+
                        "${lf.log_5(cur, EPS)}," +
                        "${lf.log_10(cur, EPS)}," +
                        "${compute(cur)}\n"
            )
            cur += step
        }
        fileWriter.flush()
        fileWriter.close()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val functions = Functions(TrigonometricFunctions(), LogarithmFunctions())
            functions.createSCV(- 2 * PI, 13.0, 0.01)
            println("The data was written")
        }
    }
}

