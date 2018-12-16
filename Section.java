import java.io.Serializable; 

/**
 * Section that controls and made up by paragraphs
 *
 * @author Oyunomin Munkhkhurel
 * @version 2018/02/10
 */
public class Section implements Serializable {
    /*linked list of paragraphs that hold and controls the paragraphs*/
    private LinkedList<Paragraph> paras;
    
    /*
     * Full constructor for section and initialize linked list of paragraphs
     */
    public Section() {
        paras = new LinkedList<Paragraph>();
    }
    
    /*
     * Returns the number of paragraphs in this list.
     *
     * @return   the number of paragraphs in this list.
     */
    public int size() {
        return paras.size();
    }
    
    /*
     * Retrieves the position of an specified paragraph 
     *
     * @param  Paragraph para desired paragraph to be found
     * @return position of the paragraph represented by integer
     */
    public int getParPosition(Paragraph para) {
        paras.ensure(para);
        return paras.getPosition(para);
    } 
    
    /*
     * Retrieves paragraph on certain position
     * 
     * @param   int index desired index of the paragraph
     * @return  paragraph on that poisiton
     */
    public Paragraph get(int index) {
        return paras.get(index);
    }
    
    /*
     * Appends the specified paragraph to the end of this list.
     *
     * @param  Paragraph para desired paragraph to be added
     */
    public void addPar(Paragraph para) {
        paras.ensure(para);
        paras.addLast(para);
    }
    
    /*
     * Inserts the specified paragraph at the specified position in this list.
     *
     * @param  Paragraph para desired paragraph to be added
     * @param  int index desired index
     */
    public void addParPosition(Paragraph para, int index) {
        paras.ensure(para);
        paras.add(index, para);
    }
    
     /*
     * Removes the desired paragraph from the list 
     *
     * @param  Paragraph para desired paragraph to be removed
     * @return true if successfully removed, if not, false
     */
    public boolean remove(Paragraph para) {
        return paras.remove(para);
    }
    
    /*
     * Moves desired paragraph up
     * 
     * @param   Paragraph para to make up
     */
    public void moveUp(Paragraph para) {
        paras.moveUp(para);
    }
    
    /*
     * Moves desired paragraph down
     * 
     * @param   Paragraph para to make down
     */
    public void moveDown(Paragraph para) {
        paras.moveDown(para);
    }
    
    /*
     * Verbal state of the class
     * 
     * @return   verbal information of the class
     */
    public String toString() {
        String info = "";
        for (int index = 0; index < paras.size(); index++) {
                info += paras.get(index).toString() + "\n";
        }
        return info;
    }
}

