import TrigonometricFunctions.Companion.EPS
import kotlin.math.PI
import kotlin.math.pow


open class Functions(var tf : TrigonometricFunctions, var lf: LogarithmFunctions){

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

}