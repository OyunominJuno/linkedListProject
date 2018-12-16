

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ParagraphTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ParagraphTest
{
    /**
     * Default constructor for test class ParagraphTest
     */
    public ParagraphTest()
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
    public void testParaConstMutAndAccsr() {
        //full constructor
        Paragraph para = new Paragraph("foo", Paragraph.Style.CENTER_ALLIGN);
        assertEquals("foo", para.getText());
        assertEquals(Paragraph.Style.CENTER_ALLIGN, para.getStyle());
        // default constructor
        Paragraph para1 = new Paragraph("DEFAULT");
        assertEquals("DEFAULT", para1.getText());
        assertEquals(Paragraph.Style.LEFT_ALLIGN, para1.getStyle());
        // mutators
        para1.setText("defaultCheck");
        assertEquals("defaultCheck", para1.getText());
        para1.setStyle(Paragraph.Style.HEADER1);
        assertEquals(Paragraph.Style.HEADER1, para1.getStyle());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testParaPreCond() {
        Paragraph paraNull = new Paragraph(null);
    }
        
}
