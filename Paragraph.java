import java.io.Serializable; 

/**
 * Paragraph class that takes care of the literal string and style of the text
 *
 * @author  Oyunomin Munkhkhurel
 * @version 02/10/2018
 */
public class Paragraph implements Serializable {
    /*literal text of the paragraph*/
    private String text;
    /*style or design of the text*/
    private Style style;
    /*Style choices of the text*/
    public enum Style {RIGHT_ALLIGN, CENTER_ALLIGN, LEFT_ALLIGN, 
                        HEADER1, HEADER2, HEADER3, HEADER4, 
                        BULLETED, NUMBERED};
      
    /*
     * Default constructor for paragraph
     * 
     * @param String text literal text of the paragraph
     */  
    public Paragraph(String text) {
        this(text, Style.LEFT_ALLIGN);
    }
    
    /*
     * Full constructor for paragraph 
     * 
     * @param String text literal text of the paragraph
     * @param Style style design of the text
     
     */
    public Paragraph(String text, Style style) {
        setText(text);
        setStyle(style);
    }
    
    /*
     * Retrives the text of the paragraph
     * 
     * @return text of the paragraph
     */
    public String getText() {
        return text;
    }
      
    /*
     * Retrives the style of the paragraph
     * 
     * @return style of the paragraph
     */
    public Style getStyle() {
        return style;
    }
    
    /*
     * Sets the text of the paragraph
     * 
     * @param String text of the paragraph
     * @throws IllegalArgumentException if text is null
     */
    public void setText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        this.text = text;
    }
      
    /*
     * Sets the style of the paragraph
     * 
     * @param Style style of the paragraph
     */
    public void setStyle(Style style) {
        this.style = style;
    }
    
    /*
     * Retrieves the verbal state of the paragraph
     * 
     * @return verbal state of the paragraph
     */
    public String toString() {
        String info = "";
        info += "Paragraph Style:   " + style + "\n";
        info += "Paragraph Text:    " + text + "\n";
        return info;
    }
}

