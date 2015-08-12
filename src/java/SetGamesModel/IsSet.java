/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetGamesModel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zhangzhonghua
 */
public class IsSet {
    
    public boolean isSet( Card... cards)  
    {  
        Map<Card.Color, Integer> colorCount = new HashMap<Card.Color, Integer>();  
        Map<Card.Shape, Integer> shapeCount = new HashMap<Card.Shape, Integer>();  
        Map<Card.Pattern,Integer> patternCount = new HashMap<Card.Pattern,Integer>();  
        Map<Integer,Integer> numCount = new HashMap<Integer,Integer>();  
          
        for( Card card : cards )  
        {  
          // 颜色  
            if( colorCount.get( card.getColor() ) == null )  
            {  
                colorCount.put( card.getColor(), 1);  
            }  
            else  
            {  
                int count = colorCount.get( card.getColor() );  
                colorCount.put( card.getColor(), ++count );  
            }  
              
            // 形状  
            if( shapeCount.get( card.getShape()) == null )  
            {  
                shapeCount.put( card.getShape(), 1 );  
            }  
            else  
            {  
                int count = shapeCount.get( card.getShape() );  
                shapeCount.put( card.getShape(), ++count );  
            }  
              
            // 背景阴影  
            if( patternCount.get( card.getPattern() ) == null )  
            {  
                patternCount.put( card.getPattern(), 1 );  
            }  
            else  
            {  
                int count = patternCount.get( card.getPattern() );  
                patternCount.put( card.getPattern(), ++count );  
            }  
              
            // 个数  
            if( numCount.get( card.getNum()) == null )  
            {  
                numCount.put(card.getNum(), 1 );  
            }  
            else  
            {  
                int count = numCount.get( card.getNum() );  
                numCount.put(card.getNum(), ++count);
 
            }  
        }  
          
        return isAllSameOrAllDiff( colorCount.size() )   
                && isAllSameOrAllDiff( shapeCount.size())
                && isAllSameOrAllDiff( patternCount.size())
                && isAllSameOrAllDiff( numCount.size());  
    }  
      
    private boolean isAllSameOrAllDiff( Integer count )  
    {  
        if( count == null )  
        {  
            return false;  
        }  
          
        return count == 1 || count == 3;  
    }  
 
 
    
}
