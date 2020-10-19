import kotlin.math.*

open class LogarithmFunctions{
    companion object{
        val EPS = 1e-8
    }

    private val wrongValue = Double.NaN

    private fun check(x: Double, eps: Double) = (x.isInfinite() || x.isNaN() || x <= 0 || eps.isInfinite() || eps.isNaN())


    /**
     * when x < 1, we can use first expansion, but if x > 1, this expansion go wrong
     */
    open fun ln(x : Double, eps: Double) : Double {
        return if (check(x,eps)){
            wrongValue
        } else  {
            var sum = 0.0
            var i = 1
            var sign = 1.0

            var u : Double

            // ln(x) = ln(u+1) when u = x-1
            if (x < 2){
                u = x - 1.0
                //nextValue = u
            } else{
                // ln(x)  = -1 * ln(1/n)  = ln(u) when u = 1/n -> z = u-1 -> ln(z+1)
                u = 1.0/x -1.0
                //nextValue = u
                sign = -1.0
            }
            var nextValue = u
            // find ln(x+1)
            while (abs(nextValue) >= eps){
                sum += nextValue/(i++)
                nextValue *= -u

            }
            sum*sign
        }
    }

    open fun log_2(x : Double, eps: Double) = ln(x,eps) / ln(2.0,eps)

    open fun log_3(x : Double, eps: Double) = ln(x,eps) / ln(3.0,eps)

    open fun log_5(x : Double, eps: Double) = ln(x,eps) / ln(5.0,eps)

    open fun log_10(x : Double, eps: Double) = ln(x,eps) / ln(10.0,eps)
}
/*
fun main(){
    val lf = LogarithmFunctions()
    val eps = 1e-8
    val x = 0.2354
    println((abs(lf.ln(x,eps) - ln(x))) < eps)
    println(lf.ln(x,eps))
    println(ln(x))
}*/