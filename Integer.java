
/**
 * Write a description of class Integer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Integer
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Integer
     */
    public Integer(int x)
    {
        // initialise instance variables
        this.x = x;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getData()
    {
        // put your code here
        return x;
    }
    
    public String toString() {
        return x + " ";
    }
}
