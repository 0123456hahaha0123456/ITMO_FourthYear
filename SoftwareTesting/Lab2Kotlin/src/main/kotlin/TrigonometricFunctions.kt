import kotlin.math.*;

open class TrigonometricFunctions{
    companion object{
        val EPS = 1e-8
    }
    private val wrongValue = Double.NaN

    private fun check(x: Double, eps: Double) = (x.isInfinite() || x.isNaN() || eps.isInfinite() || eps.isNaN())

    open fun sin(x : Double, eps : Double) : Double{
        return if (check(x,eps)){
            wrongValue
        }else{
            var sum = 0.0
            var i = 1
            var nextValue = x
            var sign = 1
            while (abs(nextValue) > eps/100){
                sum += sign * nextValue
                nextValue *= x * x / (i*2 * (i*2 + 1))
                i++
                sign *= -1
            }
            sum
        }
    }

    open fun sec(x : Double, eps: Double) = if (!check(x,eps)) 1/cos(x,eps) else wrongValue

    open fun cos(x : Double, eps : Double) = if (!check(x,eps)) sin(x + PI/2, eps) else wrongValue

    open fun cot(x : Double, eps : Double) = if (!check(x,eps)) cos(x,eps)/sin(x,eps) else wrongValue

    open fun tan(x : Double, eps : Double) = if (!check(x,eps)) sin(x,eps)/cos(x,eps) else wrongValue
}


fun main(){
    val lf = TrigonometricFunctions()
    val eps = 1e-8
    println(1.0/Double.NaN)
}