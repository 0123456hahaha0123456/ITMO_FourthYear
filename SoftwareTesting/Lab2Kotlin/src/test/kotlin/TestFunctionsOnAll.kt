import kotlin.math.PI;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import kotlin.math.log
import kotlin.math.log10
import kotlin.math.log2

/**
 * This class used to test functions on all basic functions
 */
class TestFunctionsOnAll{
    companion object{
        val eps = 1e-8
        val ERR = 1e-4
        val CIRCLE = PI * 2
        var function : Functions? = null

        @BeforeAll
        @JvmStatic
        fun initMock() {
            val tf = Mockito.mock(TrigonometricFunctions::class.java, Mockito.CALLS_REAL_METHODS)
            val lf = Mockito.mock(LogarithmFunctions::class.java, Mockito.CALLS_REAL_METHODS)
            function = Functions(tf, lf)

            //0
            Mockito.`when`(tf.sin(0.0, eps)).thenReturn(0.0)
            Mockito.`when`(tf.cos(0.0, eps)).thenReturn(1.0)
            Mockito.`when`(tf.tan(0.0, eps)).thenReturn(0.0)
            Mockito.`when`(tf.cot(0.0, eps)).thenReturn(Double.POSITIVE_INFINITY)
            Mockito.`when`(tf.sec(0.0, eps)).thenReturn(1.0)
            // sin(0 + eps)
            Mockito.`when`(tf.sin(0.0 + eps, eps)).thenReturn(0.0)
            Mockito.`when`(tf.cos(0.0 + eps, eps)).thenReturn(1.0)
            Mockito.`when`(tf.tan(0.0 + eps, eps)).thenReturn(0.0)
            Mockito.`when`(tf.cot(0.0 + eps, eps)).thenReturn(Double.POSITIVE_INFINITY)
            Mockito.`when`(tf.sec(0.0 + eps, eps)).thenReturn(1.0)
            // sin(0 - eps)
            Mockito.`when`(tf.sin(0.0 - eps, eps)).thenReturn(0.0)
            Mockito.`when`(tf.cos(0.0 - eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.tan(0.0 - eps, eps)).thenReturn(0.0)
            Mockito.`when`(tf.cot(0.0 - eps, eps)).thenReturn(Double.NEGATIVE_INFINITY)
            Mockito.`when`(tf.sec(0.0 - eps, eps)).thenReturn(-1.0)
            //sin(0 + circle) = sin(360)
            Mockito.`when`(tf.sin(0.0 + CIRCLE, eps)).thenReturn(0.0)
            Mockito.`when`(tf.cos(0.0 + CIRCLE, eps)).thenReturn(1.0)
            Mockito.`when`(tf.tan(0.0 + CIRCLE, eps)).thenReturn(0.0)
            Mockito.`when`(tf.cot(0.0 + CIRCLE, eps)).thenReturn(Double.POSITIVE_INFINITY)
            Mockito.`when`(tf.sec(0.0 + CIRCLE, eps)).thenReturn(1.0)

            //sin 45
            Mockito.`when`(tf.sin(-PI /4, eps)).thenReturn(-0.70710678)
            Mockito.`when`(tf.cos(-PI /4, eps)).thenReturn(0.70710678)
            Mockito.`when`(tf.tan(-PI /4, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cot(-PI /4, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.sec(-PI /4, eps)).thenReturn(1.4142135623)
            // sin(45 + eps)
            Mockito.`when`(tf.sin(-PI /4 - eps, eps)).thenReturn(-0.70710678)
            Mockito.`when`(tf.cos(-PI /4 - eps, eps)).thenReturn(0.70710678)
            Mockito.`when`(tf.tan(-PI /4 - eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cot(-PI /4 - eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.sec(-PI /4 - eps, eps)).thenReturn(1.4142135623)
            // sin(45 - eps)
            Mockito.`when`(tf.sin(-PI /4 + eps, eps)).thenReturn(-0.70710678)
            Mockito.`when`(tf.cos(-PI /4 + eps, eps)).thenReturn(0.70710678)
            Mockito.`when`(tf.tan(-PI /4 + eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cot(-PI /4 + eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.sec(-PI /4 + eps, eps)).thenReturn(1.4142135623)
            //sin(45 + circle)
            Mockito.`when`(tf.sin(-PI /4 - CIRCLE, eps)).thenReturn(-0.70710678)
            Mockito.`when`(tf.cos(-PI /4 - CIRCLE, eps)).thenReturn(0.70710678)
            Mockito.`when`(tf.tan(-PI /4 - CIRCLE, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cot(-PI /4 - CIRCLE, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.sec(-PI /4 - CIRCLE, eps)).thenReturn(1.4142135623)

            //sin 90
            Mockito.`when`(tf.sin(-PI /2, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cos(-PI /2, eps)).thenReturn(0.0)
            Mockito.`when`(tf.tan(-PI /2, eps)).thenReturn(Double.NEGATIVE_INFINITY)
            Mockito.`when`(tf.cot(-PI /2, eps)).thenReturn(0.0)
            Mockito.`when`(tf.sec(-PI /2, eps)).thenReturn(Double.POSITIVE_INFINITY)
            // sin(90 + eps)
            Mockito.`when`(tf.sin(-(PI /2 + eps), eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cos(-(PI /2 + eps), eps)).thenReturn(-0.0)
            Mockito.`when`(tf.tan(-(PI /2 + eps), eps)).thenReturn(Double.POSITIVE_INFINITY)
            Mockito.`when`(tf.cot(-(PI /2 + eps), eps)).thenReturn(-0.0)
            Mockito.`when`(tf.sec(-(PI /2 + eps), eps)).thenReturn(Double.NEGATIVE_INFINITY)
            // sin(90 - eps)
            Mockito.`when`(tf.sin(-(PI /2 - eps), eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cos(-(PI /2 - eps), eps)).thenReturn(0.0)
            Mockito.`when`(tf.tan(-(PI /2 - eps), eps)).thenReturn(Double.NEGATIVE_INFINITY)
            Mockito.`when`(tf.cot(-(PI /2 - eps), eps)).thenReturn(0.0)
            Mockito.`when`(tf.sec(-(PI /2 - eps), eps)).thenReturn(Double.POSITIVE_INFINITY)
            //sin(90 + circle)
            Mockito.`when`(tf.sin(-(PI /2 + CIRCLE), eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cos(-(PI /2 + CIRCLE), eps)).thenReturn(0.0)
            Mockito.`when`(tf.tan(-(PI /2 + CIRCLE), eps)).thenReturn(Double.NEGATIVE_INFINITY)
            Mockito.`when`(tf.cot(-(PI /2 + CIRCLE), eps)).thenReturn(0.0)
            Mockito.`when`(tf.sec(-(PI /2 + CIRCLE), eps)).thenReturn(Double.POSITIVE_INFINITY)


            //sin(-125)
            Mockito.`when`(tf.sin(-25.0/36.0 * PI, eps)).thenReturn(-0.81915204)
            Mockito.`when`(tf.cos(-25.0/36.0 * PI, eps)).thenReturn(-0.57357643)
            Mockito.`when`(tf.tan(-25.0/36.0 * PI, eps)).thenReturn(1.428148007)
            Mockito.`when`(tf.cot(-25.0/36.0 * PI, eps)).thenReturn(0.700207538)
            Mockito.`when`(tf.sec(-25.0/36.0 * PI, eps)).thenReturn(-1.7434467956)
            // sin(-125 + eps)
            Mockito.`when`(tf.sin(-25.0/36.0 * PI + eps, eps)).thenReturn(-0.81915204)
            Mockito.`when`(tf.cos(-25.0/36.0 * PI + eps, eps)).thenReturn(-0.57357643)
            Mockito.`when`(tf.tan(-25.0/36.0 * PI + eps, eps)).thenReturn(1.428148007)
            Mockito.`when`(tf.cot(-25.0/36.0 * PI + eps, eps)).thenReturn(0.700207538)
            Mockito.`when`(tf.sec(-25.0/36.0 * PI + eps, eps)).thenReturn(-1.7434467956)
            // sin(-125 - eps)
            Mockito.`when`(tf.sin(-25.0/36.0 * PI - eps, eps)).thenReturn(-0.81915204)
            Mockito.`when`(tf.cos(-25.0/36.0 * PI - eps, eps)).thenReturn(-0.57357643)
            Mockito.`when`(tf.tan(-25.0/36.0 * PI - eps, eps)).thenReturn(1.428148007)
            Mockito.`when`(tf.cot(-25.0/36.0 * PI - eps, eps)).thenReturn(0.700207538)
            Mockito.`when`(tf.sec(-25.0/36.0 * PI - eps, eps)).thenReturn(-1.7434467956)
            //sin(-125 + circle)
            Mockito.`when`(tf.sin(-25.0/36.0 * PI - CIRCLE, eps)).thenReturn(-0.81915204)
            Mockito.`when`(tf.cos(-25.0/36.0 * PI - CIRCLE, eps)).thenReturn(-0.57357643)
            Mockito.`when`(tf.tan(-25.0/36.0 * PI - CIRCLE, eps)).thenReturn(1.428148007)
            Mockito.`when`(tf.cot(-25.0/36.0 * PI - CIRCLE, eps)).thenReturn(0.700207538)
            Mockito.`when`(tf.sec(-25.0/36.0 * PI - CIRCLE, eps)).thenReturn(-1.7434467956)

            //sin(-225)
            Mockito.`when`(tf.sin(-5.0/4.0 * PI, eps)).thenReturn(0.70710678)
            Mockito.`when`(tf.cos(-5.0/4.0 * PI, eps)).thenReturn(-0.70710678)
            Mockito.`when`(tf.tan(-5.0/4.0 * PI, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cot(-5.0/4.0 * PI, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.sec(-5.0/4.0 * PI, eps)).thenReturn(-1.4142135623)

            // sin(225 + eps)
            Mockito.`when`(tf.sin(-5.0/4.0  * PI + eps, eps)).thenReturn(0.70710678)
            Mockito.`when`(tf.cos(-5.0/4.0  * PI + eps, eps)).thenReturn(-0.70710678)
            Mockito.`when`(tf.sin(-5.0/4.0  * PI + eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cos(-5.0/4.0  * PI + eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.sec(-5.0/4.0 * PI + eps, eps)).thenReturn(-1.4142135623)
            // sin(225 - eps)
            Mockito.`when`(tf.sin(-5.0/4.0 * PI - eps, eps)).thenReturn(0.70710678)
            Mockito.`when`(tf.cos(-5.0/4.0 * PI - eps, eps)).thenReturn(-0.70710678)
            Mockito.`when`(tf.sin(-5.0/4.0 * PI - eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cos(-5.0/4.0 * PI - eps, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.sec(-5.0/4.0 * PI - eps, eps)).thenReturn(-1.4142135623)
            //sin(225 + circle)
            Mockito.`when`(tf.sin(-5.0/4.0  * PI + CIRCLE, eps)).thenReturn(0.70710678)
            Mockito.`when`(tf.cos(-5.0/4.0  * PI + CIRCLE, eps)).thenReturn(-0.70710678)
            Mockito.`when`(tf.sin(-5.0/4.0  * PI + CIRCLE, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.cos(-5.0/4.0  * PI + CIRCLE, eps)).thenReturn(-1.0)
            Mockito.`when`(tf.sec(-5.0/4.0  * PI + CIRCLE, eps)).thenReturn(-1.4142135623)

            //sin(-0.5)
            Mockito.`when`(tf.sin(-0.5, eps)).thenReturn(-0.479425538)
            Mockito.`when`(tf.cos(-0.5, eps)).thenReturn(0.877582562)
            Mockito.`when`(tf.tan(-0.5, eps)).thenReturn(-0.5463024898)
            Mockito.`when`(tf.cot(-0.5, eps)).thenReturn(-1.830487721)
            Mockito.`when`(tf.sec(-0.5, eps)).thenReturn(1.139493927)

            //sin (-1.32)
            Mockito.`when`(tf.sin(-1.32, eps)).thenReturn(-0.9687151001)
            Mockito.`when`(tf.cos(-1.32, eps)).thenReturn(0.248175)
            Mockito.`when`(tf.tan(-1.32, eps)).thenReturn(3.903347787)
            Mockito.`when`(tf.cot(-1.32, eps)).thenReturn(-0.25619034)
            Mockito.`when`(tf.sec(-1.32, eps)).thenReturn(4.0294073944)

            //sin (-13)
            Mockito.`when`(tf.sin(-13.0, eps)).thenReturn(-0.224951054)
            Mockito.`when`(tf.cos(-13.0, eps)).thenReturn(0.974370064)
            Mockito.`when`(tf.tan(-13.0, eps)).thenReturn(-0.2308681911)
            Mockito.`when`(tf.cot(-13.0, eps)).thenReturn(-4.331475874)
            Mockito.`when`(tf.sec(-13.0, eps)).thenReturn(1.0263041077)

            //Mock on ln Function
            Mockito.`when`(lf.ln(0.132, eps)).thenReturn(-2.024953356)
            Mockito.`when`(lf.log_2(0.132, eps)).thenReturn(-2.9213901653036336)
            Mockito.`when`(lf.log_3(0.132, eps)).thenReturn(-1.8431919770811007)
            Mockito.`when`(lf.log_5(0.132, eps)).thenReturn(-1.2581742611824298)
            Mockito.`when`(lf.log_10(0.132, eps)).thenReturn(-0.8794260687941501)

            Mockito.`when`(lf.ln(0.4,eps)).thenReturn(-0.91629073)
            Mockito.`when`(lf.log_2(0.4, eps)).thenReturn(-1.3219280948873622)
            Mockito.`when`(lf.log_3(0.4, eps)).thenReturn(-0.8340437671464696)
            Mockito.`when`(lf.log_5(0.4, eps)).thenReturn(-0.5693234419266069)
            Mockito.`when`(lf.log_10(0.4, eps)).thenReturn(-0.3979400086720376)

            Mockito.`when`(lf.ln(0.5, eps)).thenReturn(-0.69314718)
            Mockito.`when`(lf.log_2(0.5, eps)).thenReturn(-1.0)
            Mockito.`when`(lf.log_3(0.5, eps)).thenReturn(-0.6309297535714574)
            Mockito.`when`(lf.log_5(0.5, eps)).thenReturn(-0.43067655807339306)
            Mockito.`when`(lf.log_10(0.5, eps)).thenReturn(-0.3010299956639812)

            Mockito.`when`(lf.ln(0.897,eps)).thenReturn(-0.108699416)
            Mockito.`when`(lf.log_2(0.897, eps)).thenReturn(-0.15682010974282581)
            Mockito.`when`(lf.log_3(0.897, eps)).thenReturn(-0.09894247319508999)
            Mockito.`when`(lf.log_5(0.897, eps)).thenReturn(-0.06753874510073199)
            Mockito.`when`(lf.log_10(0.897, eps)).thenReturn(-0.0472075569559079)

            Mockito.`when`(lf.ln(1.0,eps)).thenReturn(0.0)
            Mockito.`when`(lf.log_2(1.0, eps)).thenReturn(0.0)
            Mockito.`when`(lf.log_3(1.0, eps)).thenReturn(0.0)
            Mockito.`when`(lf.log_5(1.0, eps)).thenReturn(0.0)
            Mockito.`when`(lf.log_10(1.0, eps)).thenReturn(0.0)

            Mockito.`when`(lf.ln(1.32, eps)).thenReturn(0.2776317366)
            Mockito.`when`(lf.log_2(1.32, eps)).thenReturn(0.40053792958372886)
            Mockito.`when`(lf.log_3(1.32, eps)).thenReturn(0.2527112972082838)
            Mockito.`when`(lf.log_5(1.32, eps)).thenReturn(0.1725022968909634)
            Mockito.`when`(lf.log_10(1.32, eps)).thenReturn(0.12057393120584989)

            Mockito.`when`(lf.ln(1.5, eps)).thenReturn(0.4054651081)
            Mockito.`when`(lf.log_2(1.5, eps)).thenReturn(0.5849625007211562)
            Mockito.`when`(lf.log_3(1.5, eps)).thenReturn(0.3690702464285425)
            Mockito.`when`(lf.log_5(1.5, eps)).thenReturn(0.25192963641259225)
            Mockito.`when`(lf.log_10(1.5, eps)).thenReturn(0.17609125905568124)

            Mockito.`when`(lf.ln(2.0,eps)).thenReturn(0.6931471806)
            Mockito.`when`(lf.log_2(2.0, eps)).thenReturn(1.0)
            Mockito.`when`(lf.log_3(2.0, eps)).thenReturn(0.6309297535714574)
            Mockito.`when`(lf.log_5(2.0, eps)).thenReturn(0.43067655807339306)
            Mockito.`when`(lf.log_10(2.0, eps)).thenReturn(0.3010299956639812)

            Mockito.`when`(lf.ln(5.0, eps)).thenReturn(1.609437912)
            Mockito.`when`(lf.log_2(5.0, eps)).thenReturn(2.321928094887362)
            Mockito.`when`(lf.log_3(5.0, eps)).thenReturn(1.4649735207179269)
            Mockito.`when`(lf.log_5(5.0, eps)).thenReturn(1.0)
            Mockito.`when`(lf.log_10(5.0, eps)).thenReturn(0.6989700043360187)

            Mockito.`when`(lf.ln(132.0,eps)).thenReturn(4.882801923)
            Mockito.`when`(lf.log_2(132.0, eps)).thenReturn(7.044394119358453)
            Mockito.`when`(lf.log_3(132.0, eps)).thenReturn(4.444517845787052)
            Mockito.`when`(lf.log_5(132.0, eps)).thenReturn(3.0338554130377493)
            Mockito.`when`(lf.log_10(132.0, eps)).thenReturn(2.120573931205857)
        }
    }

    @Test
    fun `testOnMinus90`(){
        assertEquals(Double.NaN, function!!.compute(-PI/2),ERR,
            "Function 1 on -Pi/2 wrong")
    }
    @Test
    fun `testOnMinus0`(){
        assertEquals(Double.POSITIVE_INFINITY, function!!.compute(0.0),ERR,
            "Function 1 on 0 wrong")
    }
    @Test
    fun `testOnMinus125`(){
        assertEquals(2.801956862,
            function!!.compute(-25.0/36.0 * PI),
            ERR,
            "Function 1 on -125 wrong")
    }
    @Test
    fun `testOnMinus225`(){
        assertEquals(3.0, function!!.compute(-5.0/4.0 * PI),ERR,
            "Function 1 on -225 wrong")
    }
    @Test
    fun `testOnMinus360`(){
        assertEquals(Double.POSITIVE_INFINITY, function!!.compute(0.0),ERR,
            "Function 1 on -360 wrong")
    }
    @Test
    fun `testOnMinus45`(){
        assertEquals(3.0, function!!.compute(-PI/4),ERR,
            "Function 1 on -45 wrong")
    }
    @Test
    fun `testOnMinus315`(){
        assertEquals(-64.193474803, function!!.compute(-PI/4 + 360),ERR,
            "Function 1 on -315 wrong")
    }

    @Test
    fun `test0132`(){
        assertEquals(3.395704791094, function!!.compute(0.132),ERR,
            "Function 2 on 0.132 wrong")
    }
    @Test
    fun `test04`(){
        assertEquals(0.63264878977, function!!.compute(0.4),ERR,
            "Function 2 on 0.4 wrong")
    }
    @Test
    fun `test05`(){
        assertEquals(0.4032718721, function!!.compute(0.5),ERR,
            "Function 2 on 0.5 wrong")
    }
    @Test
    fun `test0897`(){
        assertEquals(0.047830382791, function!!.compute(0.897),ERR,
            "Function 2 on 0.897 wrong")
    }
    @Test
    fun `test1032`(){
        assertEquals(-0.127646229621, function!!.compute(1.32),ERR,
            "Function 2 on 1.32 wrong")
    }
    @Test
    fun `test15`(){
        assertEquals(-0.197131182483, function!!.compute(1.5),ERR,
            "Function 2 on 1.5 wrong")
    }
    @Test
    fun `test20`(){
        assertEquals(-0.4032718721, function!!.compute(2.0),ERR,
            "Function 2 on 2.0 wrong")
    }
    @Test
    fun `test50`(){
        assertEquals(-1.96363439885, function!!.compute(5.0),ERR,
            "Function 2 on 5.0 wrong")
    }
    @Test
    fun `test132`(){
        assertEquals(-37.349291045242, function!!.compute(132.0),ERR,
            "Function 2 on 1.32 wrong")
    }
}
