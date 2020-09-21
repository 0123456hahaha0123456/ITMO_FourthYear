import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class SinFuncTest {
    private SinFunc sinFunc;
    private double n;
    private int limit = 100000;
    final double eps = 0.0001;
    final String message = "The value of power series of funtion sin(x) is not equals to value of sin(x) ";

    /**
    Create new instance of SinFunc class to test inside methods
     */
    @Before public void setUp(){
        sinFunc = new SinFunc();
    }

    /**
     * Test sin with small limit
     */
    @Test
    public void testSinSmallerLimit(){
        n = 6;
        limit = 10;
        System.out.println(sinFunc.sin(n,limit));
        System.out.println(Math.sin(n));
        assertTrue(message, Math.abs(Math.sin(n) - sinFunc.sin(n,limit) )<= eps);
    }

    /**
     * Test sin with medium limit
     */
    @Test
    public void testSinMediumLimit(){
        n = 10;
        limit = 1000;
        assertTrue(message, Math.abs(Math.sin(n) - sinFunc.sin(n, limit)) <= eps);
    }
    /**
     * Test sin with large limit
     */
    @Test
    public void testSinLargeLimit(){
        n = 20;
        limit = 100000;
        assertTrue(message, Math.abs(Math.sin(n) - sinFunc.sin(n, limit)) <= eps);
    }

}
