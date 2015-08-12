
package SetGamesModel;
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhangzhonghua
 */
public class Card {
    
    private final Color color;
    private final Shape shape;
    private final Pattern pattern;
    private final int num;
    private final int imgNo;
    
    
 public Card(Shape shape,Pattern pattern,Color color, int num,int imgNo)
 {
 super();
 this.color=color;
 this.shape=shape;
 this.pattern=pattern;
 this.num=num;
 this.imgNo=imgNo;
 }

 @Override
    public String toString()
{
  StringBuffer sb = new StringBuffer();
//  sb.append(this.getShape()+",");
//  sb.append(this.getColor()+",");
//  sb.append(this.getPattern()+",");
//  sb.append(this.getNum()+",");
  sb.append(this.getImgNo());
  
  
  return sb.toString();

}
     /**
     * @return the color
     */
    public  Color getColor() {
        return color;
    }

  
    /**
     * @return the shape
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * @return the pattern
     */
    public Pattern getPattern() {
        return pattern;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @return the imgNo
     */
    public int getImgNo() {
        return imgNo;
    }
    enum Color{
      RED,
   PURPLE,
    GREEN
   
    }
    
    enum Shape{
    SQUIGGLE,
    DIAMOND,
     OVAL
    }
 
    enum Pattern{
    FILLED,
    SHADED,
    EMPTY
 
    }
    


}
