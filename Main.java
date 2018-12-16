import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main {
    public static void main(String[] args) throws IOException {
    System.out.print('\u000C');
    LinkedList<Integer> l = new LinkedList<Integer>();
    Integer first = new Integer(1);
    Integer second = new Integer(2);
    Integer zero = new Integer(0);
    Integer three = new Integer(3);
    Integer four = new Integer(4);
    l.addFirst(first);
    l.addLast(second);
    l.addFirst(zero);
    l.add(0, four);
    l.add(2, three);
    l.add(4, zero);
   System.out.println(l);
   
   Paragraph par1 = new Paragraph("This is my first paragraph", Paragraph.Style.BULLETED);
   Paragraph par2 = new Paragraph("This is my second paragraph", Paragraph.Style.HEADER1);
   Paragraph par3 = new Paragraph("This is my third paragraph", Paragraph.Style.RIGHT_ALLIGN);

   Section sec1 = new Section();
   Section sec2 = new Section();
   
   sec1.addPar(par1);
   sec1.addPar(par2);
   sec2.addPar(par3);
   System.out.print("Before moving up /n" + sec1);
   sec1.moveUp(par3);
   System.out.print("After moving up /n" + sec1);
   System.out.print(sec1);
   Document doc1 = Document.getInstance();
   doc1.addSec(sec1);
   doc1.addSec(sec2);
   System.out.println(doc1.get(0).get(0).getText());
   doc1.saveToHTML();
}
}