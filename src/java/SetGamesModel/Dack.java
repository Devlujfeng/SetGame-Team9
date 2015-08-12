/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetGamesModel;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author zhangzhonghua
 */
public class Dack {
    
     private  final ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * @return the cards
     */
    public  ArrayList<Card> getCards() {
        return cards;
    }
    
    //初始化 生成81张牌
     
     public void init()  
    {  
        int m=1;
       for( int i=0 ; i<3 ; i++ )  
        {  
            for( int j=0 ; j<3 ; j++ )  
            {  
                for( int k=0 ; k<3 ; k++ )  
                {  
                    for( int l=1 ; l<4 ; l++ )  
                    {  
                        cards.add(new Card(Card.Shape.values()[j],Card.Pattern.values()[i],Card.Color.values()[k],
                                l,m++));
                    }  
                }  
            }  
        } 
      
     shuffle(cards);

    }  
    
     //洗牌
    
     public <T> void shuffle(ArrayList<T> list) {
        int size = list.size();
        Random random = new Random();
        
        for(int times=0;times<100;times++)
        {
        
        for(int i = 0; i < size; i++)
        {
            // 获取随机位置
            int randomPos = random.nextInt(size); 
            // 当前元素与随机元素交换
            T temp = list.get(i);
            list.set(i, list.get(randomPos));
            list.set(randomPos, temp);
        }
        
        }
    }    
  
}
