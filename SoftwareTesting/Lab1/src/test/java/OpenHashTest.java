import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

public class OpenHashTest {
    private OpenHash hash;
    private Random rand;
    @Before public void setUp(){
        rand = new Random();
        hash = new OpenHash();
    }

    @Test public void testAddDifferentInteger(){
        hash.clean();
        for(int i=0;i<1000;i++){
            hash.add(i);
        }
        assertEquals(1000, hash.getSize());

        for(int i=0;i<10;i++){
            int value = rand.nextInt(1000);
            assertTrue(hash.find(value));
        }

    }

    @Test public void testAddSameInteger(){
        hash.clean();
        for(int i=0;i<1000;i++){
            hash.add(132);
        }
        assertEquals(1000, hash.getSize());
        assertTrue(hash.find(132));
        assertEquals("Expected size of hash is 1000, but found" + hash.getSizeHashValue(132), 1000, hash.getSizeHashValue(132));
        assertEquals("Expected size of hash is 1, but found" + hash.getSizeHashValue(132), 1, hash.getSizeHashValue(132));

    }

    @Test public void testAddAndDelete(){
        hash.clean();
        for(int i=0;i<10;i++){
            hash.add(i);
        }
        assertTrue(hash.delete(2));
        assertTrue(hash.delete(3));
        assertFalse(hash.find(3));
        assertFalse(hash.delete(11));
    }

    @Test
    public void testDelete(){
        hash.clean();
        for(int i=0;i<10;i++){
            hash.add(5);
        }
        assertFalse("No element in hash", hash.delete(1));
        assertTrue(hash.delete(5));
        assertEquals("Expected 9 elements remaining, but found " + hash.getSize(), 9, hash.getSize());
    }
}
