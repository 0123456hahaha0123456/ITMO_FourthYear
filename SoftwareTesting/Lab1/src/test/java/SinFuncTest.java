import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
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
        assertFalse(message, Math.abs(Math.sin(n) - sinFunc.sin(n,limit) )<= eps);
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
    //@Test
    public void testSinLargeLimit(){
        n = 20;
        limit = 100000;
        assertTrue(message, Math.abs(Math.sin(n) - sinFunc.sin(n, limit)) <= eps);
    }

    @Test
    public void testSinNegative(){
        n=-10;
        limit = 1000;
        assertTrue(message, Math.abs(Math.sin(n) - sinFunc.sin(n, limit)) <= eps);
    }

    @Test public void testSin90degree(){
        n = Math.PI/2;
        limit = 1000;
        assertTrue(message, Math.abs(1f - sinFunc.sin(n, limit)) <= eps);
    }
    @Test public void testSin0degree(){
        n = 0;
        limit = 1000;
        assertTrue(message, Math.abs(0f - sinFunc.sin(n,limit) )<= eps);
    }

    @Test public void testSin180degree(){
        n = Math.PI;
        limit = 1000;
        assertTrue(message, Math.abs(0f - sinFunc.sin(n,limit) )<= eps);
    }

    @Test public void testSin45degree(){
        n = Math.PI/4;
        limit= 1000;
        System.out.println(sinFunc.sin(n,limit));
        assertTrue(message, Math.abs(Math.sqrt(2)/2 - sinFunc.sin(n,limit) )<= eps);
    }
}
