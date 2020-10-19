import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.CALLS_REAL_METHODS
import kotlin.math.PI


class TestFunctionsOnBasic{
    companion object{
        val eps = 1e-8
        val ERR = 1e-4
        val CIRCLE = PI * 2
        var function : Functions? = null

        @BeforeAll
        @JvmStatic
        fun initMock() {
            val tf = Mockito.mock(TrigonometricFunctions::class.java, CALLS_REAL_METHODS)
            val lf = Mockito.mock(LogarithmFunctions::class.java, CALLS_REAL_METHODS)
            function = Functions(tf, lf)

            //sin 0
            Mockito.`when`(tf.sin(0.0, eps)).thenReturn(0.0)
            // sin(0 + eps)
            Mockito.`when`(tf.sin(0.0 + eps, eps)).thenReturn(0.0)
            // sin(0 - eps)
            Mockito.`when`(tf.sin(0.0 - eps, eps)).thenReturn(0.0)
            //sin(0 + circle) = sin(360)
            Mockito.`when`(tf.sin(0.0 + CIRCLE, eps)).thenReturn(0.0)

            //sin 45
            Mockito.`when`(tf.sin(-PI/4, eps)).thenReturn(-0.70710678)
            // sin(45 + eps)
            Mockito.`when`(tf.sin(-PI/4 + eps, eps)).thenReturn(-0.70710678)
            // sin(45 - eps)
            Mockito.`when`(tf.sin(-PI/4 - eps, eps)).thenReturn(-0.70710678)
            //sin(45 + circle)
            Mockito.`when`(tf.sin(-PI/4 + CIRCLE, eps)).thenReturn(-0.70710678)

            //sin 90
            Mockito.`when`(tf.sin(-PI/2, eps)).thenReturn(1.0)
            // sin(90 + eps)
            Mockito.`when`(tf.sin(-PI/2 + eps, eps)).thenReturn(1.0)
            // sin(90 - eps)
            Mockito.`when`(tf.sin(-PI/2 - eps, eps)).thenReturn(1.0)
            //sin(90 + circle)
            Mockito.`when`(tf.sin(-PI/2 + CIRCLE, eps)).thenReturn(1.0)

            //sin 125
            Mockito.`when`(tf.sin(-25.0/36.0 * PI, eps)).thenReturn(-0.81915204)
            // sin(12 + eps)
            Mockito.`when`(tf.sin(-25.0/36.0 * PI + eps, eps)).thenReturn(-0.81915204)
            // sin(125 - eps)
            Mockito.`when`(tf.sin(-25.0/36.0 * PI - eps, eps)).thenReturn(-0.81915204)
            //sin(125 + circle)
            Mockito.`when`(tf.sin(-25.0/36.0 * PI + CIRCLE, eps)).thenReturn(-0.81915204)


            //sin(225)
            Mockito.`when`(tf.sin(-5.0/4.0 * PI, eps)).thenReturn(0.70710678)
            // sin(225 + eps)
            Mockito.`when`(tf.sin(-5.0/4.0  * PI + eps, eps)).thenReturn(0.70710678)
            // sin(225 - eps)
            Mockito.`when`(tf.sin(-5.0/4.0 * PI - eps, eps)).thenReturn(0.70710678)
            //sin(225 + circle)
            Mockito.`when`(tf.sin(-5.0/4.0  * PI + CIRCLE, eps)).thenReturn(0.70710678)

            //sin(-0.5)
            Mockito.`when`(tf.sin(-0.5, eps)).thenReturn(-0.47942553)

            //sin (-1.32)
            Mockito.`when`(tf.sin(-1.32, eps)).thenReturn(-0.9687151001)

            //sin (-13)
            Mockito.`when`(tf.sin(-13.0, eps)).thenReturn(-0.4201670368)


            //Mock on ln Function
            Mockito.`when`(lf.ln(0.132, eps)).thenReturn(-2.024953356)
            Mockito.`when`(lf.ln(0.4,eps)).thenReturn(-0.91629073)

            Mockito.`when`(lf.ln(0.5, eps)).thenReturn(-0.69314718)
            Mockito.`when`(lf.ln(0.897,eps)).thenReturn(-0.108699416)
            Mockito.`when`(lf.ln(1.32, eps)).thenReturn(0.2776317366)
            Mockito.`when`(lf.ln(1.0,eps)).thenReturn(0.0)
            Mockito.`when`(lf.ln(1.5, eps)).thenReturn(0.4054651081)
            Mockito.`when`(lf.ln(2.0,eps)).thenReturn(0.6931471806)
            Mockito.`when`(lf.ln(5.0, eps)).thenReturn(1.609437912)
            Mockito.`when`(lf.ln(132.0,eps)).thenReturn(4.882801923)
        }
    }

    @Test
    fun `testOnMinus90`(){
        assertEquals(Double.NaN, function!!.compute(-PI/2),ERR,
            "Function 1 on -90 wrong")
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
            "Function 2 on 0.4 wrong")
    }
    @Test
    fun `test0897`(){
        assertEquals(0.047830382791, function!!.compute(0.897),ERR,
            "Function 2 on 0.4 wrong")
    }
    @Test
    fun `test1032`(){
        assertEquals(-0.127646229621, function!!.compute(1.32),ERR,
            "Function 2 on 0.4 wrong")
    }
    @Test
    fun `test15`(){
        assertEquals(-0.197131182483, function!!.compute(1.5),ERR,
            "Function 2 on 0.4 wrong")
    }
    @Test
    fun `test20`(){
        assertEquals(-0.4032718721, function!!.compute(2.0),ERR,
            "Function 2 on 0.4 wrong")
    }
    @Test
    fun `test50`(){
        assertEquals(-1.96363439885, function!!.compute(5.0),ERR,
            "Function 2 on 0.4 wrong")
    }
    @Test
    fun `test132`(){
        assertEquals(-37.349291045242, function!!.compute(132.0),ERR,
            "Function 2 on 0.4 wrong")
    }


}

