import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeAll
import kotlin.math.*

class TestBasicFunctions{
    companion object{
        var lf : LogarithmFunctions? = LogarithmFunctions()
        var tf : TrigonometricFunctions? = TrigonometricFunctions()
        val eps = 1e-8
        val ERR = 1e-4
        @BeforeAll
        @Test
        fun `testOnNull`(){
            assertNull(lf,"This class should be implement")
            assertNull(tf,"This class should be implement")
        }
    }

    @Test
    fun `testSinZeroDegree`(){
        assertEquals(0.0, tf!!.sin(0.0,eps),ERR, "Test on sin(0) should return 0")
    }

    @Test
    fun `testSin45Degree`(){
        assertEquals(0.70710678, tf!!.sin(PI/4,eps),ERR, "Test on sin(45) should return 0.70710678")
    }
    @Test
    fun `testSin90Degree`(){
        assertEquals(1.0, tf!!.sin(PI/2,eps),ERR, "Test on sin(90) should return 1.0")
    }
    @Test
    fun `testSin125Degree`(){
        assertEquals(0.81915204, tf!!.sin(25.0/36.0 * PI,eps),ERR, "Test on sin(125) should return 0.81915204")
    }
    @Test
    fun `testSin180Degree`(){
        assertEquals(0.0, tf!!.sin(PI,eps),ERR, "Test on sin(180) should return 0")
    }

    @Test
    fun `testLnMinus1`(){
        assertEquals(Double.NaN, lf!!.ln(-1.0,eps),ERR, "Test on ln(-1) should return NaN")
    }

    @Test
    fun `testLn0`(){
        assertEquals(Double.NaN, lf!!.ln(0.0,eps),ERR, "Test on ln(0) should return NaN")
    }

    @Test
    fun `testLn0,5`(){
        assertEquals(-0.6931471806, lf!!.ln(0.5,eps),ERR, "Test on ln(0.5) should return -0.6931471")
    }

    @Test
    fun `testLn1`(){
        assertEquals(0.0, lf!!.ln(1.0,eps),ERR, "Test on ln(1) should return 0")
    }
    @Test
    fun `testLn2`(){
        assertEquals(0.6931471806, lf!!.ln(2.0,eps),ERR, "Test on ln(2) should return 0.6931471")
    }

    @Test
    fun `testLn5`(){
        assertEquals(1.609437912, lf!!.ln(5.0,eps),ERR, "Test on ln(5) should return 1.609437912")
    }

}