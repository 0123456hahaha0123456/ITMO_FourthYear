import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.CALLS_REAL_METHODS
import kotlin.math.PI

/**
This class is used to test 2 functions
 */
class TestFunctions{
    companion object{
        val eps = 1e-8
        val ERR = 1e-4
        var function : Functions? = null

        @BeforeAll
        @JvmStatic
        fun initMock() {
            function = Mockito.mock(Functions::class.java, CALLS_REAL_METHODS)
            function!!.tf = TrigonometricFunctions()
            function!!.lf = LogarithmFunctions()

            Mockito.`when`(function!!.firstFunction(-10.0)).thenReturn(2.905228291528051)
            Mockito.`when`(function!!.firstFunction(-9.5)).thenReturn(163.87566572234851)
            Mockito.`when`(function!!.firstFunction(-9.0)).thenReturn(7.850956639935923)
            Mockito.`when`(function!!.firstFunction(-8.5)).thenReturn(2.7552451870584838)
            Mockito.`when`(function!!.firstFunction(-8.0)).thenReturn(40.605057647223695)
            Mockito.`when`(function!!.firstFunction(-7.5)).thenReturn(10.79554283181615)
            Mockito.`when`(function!!.firstFunction(-7.0 )).thenReturn(2.8001457915453205)
            Mockito.`when`(function!!.firstFunction(-6.5)).thenReturn(17.338253869943582)
            Mockito.`when`(function!!.firstFunction(-6.0)).thenReturn(16.03855338490637)
            Mockito.`when`(function!!.firstFunction(-5.5)).thenReturn(3.00892983146954)
            Mockito.`when`(function!!.firstFunction(-3.5)).thenReturn(5.972135733719304)
            Mockito.`when`(function!!.firstFunction(-3.0)).thenReturn(57.106793882968645)
            Mockito.`when`(function!!.firstFunction(-2.5)).thenReturn(3.941646955023048)
            Mockito.`when`(function!!.firstFunction(-2.0)).thenReturn(4.256467332186978)

            Mockito.`when`(function!!.firstFunction(-PI)).thenReturn(9.338533518935124E21)
            Mockito.`when`(function!!.firstFunction(-PI/4)).thenReturn(3.000000000039191)
            Mockito.`when`(function!!.firstFunction(-PI/2)).thenReturn(Double.NaN)
            Mockito.`when`(function!!.firstFunction(0.0)).thenReturn(Double.POSITIVE_INFINITY)
            Mockito.`when`(function!!.firstFunction(-5.0/6.0* PI)).thenReturn(-0.689716163621691)

            Mockito.`when`(function!!.secondFunction(1.4)).thenReturn(-0.15837734888758226)
            Mockito.`when`(function!!.secondFunction(4.1999)).thenReturn(-1.520454898193096)
            Mockito.`when`(function!!.secondFunction(6.3)).thenReturn(-2.68957095645971)
            Mockito.`when`(function!!.secondFunction(7.0)).thenReturn(-3.078384624529496)
            Mockito.`when`(function!!.secondFunction(5.6 )).thenReturn(-2.298718627091840)
            Mockito.`when`(function!!.secondFunction(6.3)).thenReturn(-2.6895709564597152)
            Mockito.`when`(function!!.secondFunction(0.7)).thenReturn( 0.169397765285602)
            Mockito.`when`(function!!.secondFunction(0.5)).thenReturn(0.4032718721016867)
            Mockito.`when`(function!!.secondFunction(0.1)).thenReturn( 4.6981967089670755)
            Mockito.`when`(function!!.secondFunction(132.0)).thenReturn(-37.34929104524210)
        }
    }

    @Test
    fun `testOnMinus90`(){
        assertEquals(Double.NaN, function!!.compute(-PI/2),ERR,
            "Functions on -90 wrong")
    }
    @Test
    fun `testOnMinus0`(){
        assertEquals(Double.POSITIVE_INFINITY, function!!.compute(0.0),ERR,
            "Functions on 0 wrong")
    }
    @Test
    fun `testOnMinus150`(){
        assertEquals(-0.6897161636,
            function!!.compute(-5.0/6.0 * PI),
            ERR,
            "Functions on -150 wrong")
    }
    @Test
    fun `testOnMinus180`(){
        assertEquals(9.338533518935124E21, function!!.compute(-PI),ERR,
            "Functions on -180 wrong")
    }
    @Test
    fun `testOnMinus360`(){
        assertEquals(Double.POSITIVE_INFINITY, function!!.compute(0.0),ERR,
            "Functions on -360 wrong")
    }
    @Test
    fun `testOnMinus45`(){
        assertEquals(3.0, function!!.compute(-PI/4),ERR,
            "Functions on -45 wrong")
    }

    @Test
    fun `test14`(){
        assertEquals(-0.15837734888, function!!.compute(1.4),ERR,
            "Functions on 1.4 wrong")
    }
    @Test
    fun `test4199`(){
        assertEquals(-1.52045489819, function!!.compute(4.1999),ERR,
            "Functions on 4.199 wrong")
    }
    @Test
    fun `test05`(){
        assertEquals(0.4032718721, function!!.compute(0.5),ERR,
            "Functions on 0.5 wrong")
    }
    @Test
    fun `test07`(){
        assertEquals(0.1693977652, function!!.compute(0.7),ERR,
            "Functions on 0.7 wrong")
    }
    @Test
    fun `test01`(){
        assertEquals(4.698196708967, function!!.compute(0.1),ERR,
            "Functions on 0.1 wrong")
    }

    @Test
    fun `test15`(){
        assertEquals(-3.07838462452, function!!.compute(7.0),ERR,
            "Functions on 7.0 wrong")
    }
    @Test
    fun `test56`(){
        assertEquals(-2.298718627091, function!!.compute(5.6),ERR,
            "Functions on 5.6 wrong")
    }
    @Test
    fun `test63`(){
        assertEquals(-2.68957095645, function!!.compute(6.3),ERR,
            "Functions on 6.3 wrong")
    }
    @Test
    fun `test132`(){
        assertEquals(-37.349291045242, function!!.compute(132.0),ERR,
            "Functions on 132 wrong")
    }
}

