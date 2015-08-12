package SetGamesModel;


import SetGamesModel.Card;
import SetGamesModel.Dack;
import static SetGamesModel.Card.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhangzhonghua
 */
public class Engine {
    
   Dack dack = new Dack();
   ArrayList<Card> cards = new ArrayList<>(); //洗好的81张牌的list
   
   public void initcards(){
       dack.init();
       cards = dack.getCards();
   }
   
     
    private void play() throws IOException  
    {  
        
      //第一次先发12张牌
        int cardSend=0;   //记录已经发出的牌的个数
        ArrayList<Card> cardsOn = new ArrayList<Card>();  //桌面上正在玩牌的list
        for( int i=0 ; i<12 ; i++ ) 
       {   
       cardsOn.add(cards.get(i));
//       System.out.println("card"+(i+1)+": "+cardsOn.get(i).toString());
//       System.out.println();
       cardSend++;
       }    
           
      //找到set 

        findSet(cardsOn,cardSend);
     
   
    }  
      
   private  void findSet(ArrayList list, int cardS) throws IOException
   {

     System.out.print("Please enter the number of the three cards you choose:\n");
     
     Scanner sc = new Scanner(System.in);
     int i=sc.nextInt();
     int j=sc.nextInt();
     int k=sc.nextInt();
     
     
     if( isSet( cards.get(i-1), cards.get(j-1), cards.get(k-1)) ) 
         {  
            System.out.println( "Congratulations ,This is a set!" ); 
            list.remove(i-1);
            list.remove(j-1);
            list.remove(k-1);
            findSet(list,cardS);
         }
     
     else{
            System.out.println( "Sorry ,This is not a set!" );
            System.out.println("Typed 0 to stop this games");
            System.out.println("Typed 1 to try again");
            System.out.println("Typed 2 to add 3 new cards");
        
         
             Scanner s = new Scanner(System.in);
            int n=s.nextInt();
          
            if(n==0)
            {
             System.exit(0);
            }
            else if(n==1)
            {
                
              findSet(list,cardS);
            }
            
            else if(n==2)
            {   
                if(cardS<81){
            list.add(cards.get(cardS+1));
            list.add(cards.get(cardS+2));
            list.add(cards.get(cardS+3));
            cardS +=3;
              
             print(list);
             findSet(list,cardS);
                }
                else{    System.exit(0);}
            }
       
     }
   } 
   
   private void print(ArrayList list)
   {
       for(int i=0;i<list.size();i++)
       {
         System.out.println("card"+(i+1)+":" + list.get(i).toString());
         System.out.println();
       }
   
   }
   
   //判断是否为一个set
    private boolean isSet( Card... cards)  
    {  
        Map<Color, Integer> colorCount = new HashMap<Color, Integer>();  
        Map<Shape, Integer> shapeCount = new HashMap<Shape, Integer>();  
        Map<Pattern,Integer> patternCount = new HashMap<Pattern,Integer>();  
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
 
 
    
     public static void main(String[] args) throws IOException   
    { 
        
        Engine engine=new Engine();
        engine.initcards();
        engine.play();
    }  

}  
    
    

