

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SectionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SectionTest
{
    /**
     * Default constructor for test class SectionTest
     */
    public SectionTest()
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
    public void test111() {
        Section s = new Section();
        s.addPar(new Paragraph("sf"));
        s.addPar(new Paragraph("sef"));
        s.addParPosition(new Paragraph("seef"), 2);
        assertEquals(3, s.size());
    }
}
