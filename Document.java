import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.Serializable;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
 
/**
 * Section that controls and made up by sections
 *
 * @author Oyunomin Munkhkhurel
 * @version 2018/02/10
 */
public class Document implements Serializable {
    /*linked list of sections that hold and controls the sections*/
    private LinkedList<Section> sections = new LinkedList<Section>();
    private static Document instance = null;
    private File file;
    /*
     * Retrieves the name of the file 
     * 
     * @return  String name of the file
     */
    public String getFileName() {
        return file.getClass().getName();
    }
    
    /*
     * Sets null to the sections Linked List, this way would be able to get objects from the deserialization
     */
    public void close() {
        instance = null;
    }
    
    // /*
     // * Works with simple txt file and assign to sections and paragraphs
     // * 
     // * @param   File simple txt file
     // */
    // public void fileText(File file) throws FileNotFoundException{
        // this.file = file;
        // Scanner scan = new Scanner(file);
        // String temp = "";
        // while (scan.hasNext()) {
             // temp += scan.next();
        // }
        // String[] lines = temp.split("\n\n");
        // for (int i = 0; i < lines.length; i++) {
            // Paragraph tempPar = new Paragraph(lines[i]);
        // }
    // }
    
    /*
     * Method that deserializes section objects
     * 
     * @param   File desired file to be deserialized
     * @throws  FileNotFoundException e if there is no such a file
     * @throws  IOException e if there is lost connection etc
     * @throws  ClassNotFoundException e if there is no such a class
     */
    public void openFile() {
        try {
            File sectionFolder = new File("sections");
            File[] files = sectionFolder.listFiles();
            for (int index = 0; index < files.length; index++) {
                FileInputStream fileIn = new FileInputStream(files[index]);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                sections.addLast((Section)in.readObject());
                in.close();
                fileIn.close();
            }
        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //
        } catch (ClassNotFoundException e) {
            //
        }
    }
    
    /*
     * Method serializes sections to a file with extension wpd
     * 
     * @param   LinkedList<Section> sections that is being serialized
     * @throw   IOException if errors occur during serialization of a shape file 
     */
    public void save() throws IOException, FileNotFoundException {
        Path newPath = Paths.get(System.getProperty("user.dir") + "//sections");
        Files.createDirectories(newPath);
        for (int index = 0; index < sections.size(); index++) {
            FileOutputStream fileOut = new FileOutputStream("sections\\" + " para-" + (index + 1)  + ".wpd");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sections.get(index));
            out.close();
            fileOut.close();
        }
    }
    
    /*
     * Saves the texts to the html version with the proper tags
     */
    public void saveToHTML() throws IOException, FileNotFoundException {
        File html = new File("htmllll.html");
        FileWriter tool = new FileWriter(html);
        tool.write("<!DOCTYPE html>\n<html>\n<body>");
                for ( int index = 0; index < sections.size(); index++) {
                    for (int idx = 0; idx < sections.get(index).size(); idx++) {
                Paragraph.Style style = sections.get(index).get(idx).getStyle();
                String text = sections.get(index).get(idx).getText();
                switch (style) {
                    case LEFT_ALLIGN:
                        tool.write("\n<p>\n<div align=\"left\">\n" + text + "\n</div>\n</p>");
                        break;
                    case CENTER_ALLIGN:
                        tool.write("\n<p>\n<div align=\"center\">\n" + text + "\n</div>\n</p>");
                        break;
                    case RIGHT_ALLIGN:
                        tool.write("\n<p>\n<div align=\"right\">\n" + text + "\n</div>\n</p>");
                        break;
                    case HEADER1:
                        tool.write("\n<h1>\n" + text + "\n</h1>");
                        break;    
                    case HEADER2:
                        tool.write("\n<h2>\n" + text + "\n</h2>");
                        break; 
                    case HEADER3:
                        tool.write("\n<h3>\n" + text + "\n</h3>");
                        break; 
                    case HEADER4:
                        tool.write("\n<h4>\n" + text + "\n</h4>");
                        break; 
                    case BULLETED:
                        String[] list = text.split("\n");
                        tool.write("<ul>");
                        for (int i = 0; i < list.length; i++) {
                        tool.write("<li>" + list[i] + "</li>");
                    }
                        tool.append("</ul>");
                        break; 
                    case NUMBERED:
                        String[] list1 = text.split("\n");
                        tool.write("<ol type=\"1\">");
                        for (int i = 0; i < list1.length; i++) {
                        tool.write("<li>" + list1[i] + "</li>");
                    }
                        tool.append("</ol>");
                        break; 
                }
                
                
            }
        }
        tool.append("</html>\n</body>");
        tool.flush();
        tool.close();
    }
    

    /*
     * Returns the number of sections in this list.
     *
     * @return   the number of sections in this list.
     */
    public int getSecCount() {
        return sections.size();
    }
    
    /*
     * Retrieves section on certain position
     * 
     * @param   int index desired index of the section
     * @return  section on that poisiton
     */
    public Section get(int index) {
        return sections.get(index);
    }
    
    /*
     * Retrieves the position of an specified section 
     *
     * @param    Section section desired section to be found
     * @return      position of the section represented by integer
     */
    public int getSecPosition(Section section) {
        sections.ensure(section);
        return sections.getPosition(section);
    }   
    
    /*
     * Appends the specified section to the end of this list.
     *
     * @param  Section section desired section to be added
     */
    public void addSec(Section section) {
        sections.ensure(section);
        sections.addLast(section);
    }
    
    /*
     * Inserts the specified section at the specified position in this list.
     *
     * @param  Section section desired section to be added
     * @param  int index desired index
     */
    public void addSecPosition(Section section, int index) {
        sections.ensure(section);
        sections.add(index, section);
    }
    
     /*
     * Removes the desired section from the list 
     *
     * @param    Section section desired section to be removed
     * @return      true if successfully removed, if not, false
     */
    public boolean remove(Section section) {
        return sections.remove(section);
    }
    
    /*
     * Moves desired section up
     * 
     * @param   Secrion sec to make up
     */
    public void moveUp(Section sec) {
        sections.moveUp(sec);
    }
    
    /*
     * Moves desired section down
     * 
     * @param   Section sec to make down
     */
    public void moveDown(Section sec) {
        sections.moveDown(sec);
    }
    
    //constructor
    private Document() {
        //singleton design, private constructor
    }
    
    public static Document getInstance() {
        if (instance == null) {
            instance = new Document();
        }
        return instance;
    }
    
}
