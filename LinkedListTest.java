

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LinkedListTest.
 *
 * @author  Oyunomin Munkhkhurel
 * @version 2018/02/07
 */
public class LinkedListTest {
    /**
     * Default constructor for test class LinkedListTest
     */
    public LinkedListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testLinkedList() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        Integer first = new Integer(1);
        Integer second = new Integer(2);
        Integer zero = new Integer(0);
        Integer three = new Integer(3);
        Integer four = new Integer(4);
        l.addFirst(first);
        l.addLast(second);
        l.addFirst(zero);
        assertEquals(3, l.size());
        assertEquals(0, l.get(0).getData());
        assertEquals(2, l.get(l.size() - 1).getData());
        assertEquals(0, l.getPosition(zero));
        l.add(0, four);
        l.add(2, three);
        l.add(4, zero);
        assertEquals(l.get(0).getData(), l.get(0).getData());
        assertEquals(0, l.get(1).getData());
        assertEquals(3, l.get(2).getData());
        assertEquals(1, l.get(3).getData());
        assertEquals(0, l.get(4).getData());
        assertEquals(2, l.get(5).getData());
        l.remove(zero);
        assertEquals(l.get(0).getData(), l.get(0).getData());
        assertEquals(3, l.get(1).getData());
        assertEquals(1, l.get(2).getData());
        assertEquals(0, l.get(3).getData());
        assertEquals(2, l.get(4).getData());
    }
    
    @Test (expected = IllegalArgumentException.class) 
    public void testPreCond() {
        LinkedList<Integer> link = new LinkedList<Integer>();
        link.addFirst(null);
    }
}
