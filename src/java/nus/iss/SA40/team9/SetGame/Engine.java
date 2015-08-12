/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.SetGame;

/**
 *
 * @author devlu
 */


import static nus.iss.SA40.team9.SetGame.Card.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
   ArrayList<Card> cards = new ArrayList<Card>(); //洗好的81张牌的list
   String x;
   ArrayList<Card> list = new ArrayList<Card>(); 
   
    public ArrayList<Card> getList() {
        return list;
    }

    public void setList(ArrayList<Card> list) {
        this.list = list;
    }
   int pointer=0;
   int pointer2=0;
   
   ArrayList<ArrayList<Card>> subfindresultdemo = new ArrayList<ArrayList<Card>>();

    public ArrayList<ArrayList<Card>> getSubfindresultdemo() {
        return subfindresultdemo;
    }

    public void setSubfindresultdemo(ArrayList<ArrayList<Card>> subfindresultdemo) {
        this.subfindresultdemo = subfindresultdemo;
    }
   
   
   
    HashMap<Integer, ArrayList<Card>> autoresult = new HashMap<>();
    HashMap<Integer, ArrayList<Card>> resultdemo = new HashMap<>();

    public HashMap<Integer, ArrayList<Card>> getResultdemo() {
        return resultdemo;
    }

    public void setResultdemo(HashMap<Integer, ArrayList<Card>> resultdemo) {
        this.resultdemo = resultdemo;
    }

    public HashMap<Integer, ArrayList<Card>> getAutoresult() {

        return autoresult;
    }
   int cardS=-1;
   
   public Engine(){
   dack.init();       //第一次先发12张牌
   cards = dack.getCards(); //桌面上正在玩牌的list
   for( int i=0 ; i<12 ; i++ ) 
       {   
       list.add(cards.get(i));
       cardS++; //记录已经发出的牌的个数    
       }
       System.out.println(cardS);
   }
   
   public ArrayList<Card> initcards(){
        getresult();
        return list;
   }
   
     
    public void play() 
    {  
        

           
      //找到set 
//        try{
//        findSet(cardsOn,12);
//        }
//        catch(Exception e){
//            
//        }
//        return cardsOn;
    }  
      
    
    public ArrayList<Card> getresult(){
        ArrayList<Card> hintCards = new  ArrayList<>();
        for(int i = 0; i < list.size()-2; i++){
           for(int j = i+1; j < list.size()-1; j++){
               for(int k = j+1; k < list.size(); k++){{
                    if(isSet( list.get(i), list.get(j), list.get(k))){
                        System.out.println("Let's cheat.");
                        System.out.println("Card1:"+i+"   Card2:"+j+"   Card3:"+k);
                        System.out.println("Let's cheat.");
                        hintCards.add(list.get(i));
                        hintCards.add(list.get(j));
                        hintCards.add(list.get(k));
                     }
                   }
                 } 
               }
           }
        System.out.println("size checking--------"+hintCards.size());
        return hintCards;
        }
    
    public void findresult(){
        
        
//        String flag = pointer.toString();
        System.out.println("thread1?");
        for(int i = 0; i < list.size()-2; i++){
           for(int j = i+1; j < list.size()-1; j++){
               for(int k = j+1; k < list.size(); k++){
                    if(cardS == 77){
                        
                              if((i == list.size()-3 && j == list.size()-2 && k == list.size()-1)){
                                    addcards();
                                    cardS=cardS+3;
                                     autoresult.put(pointer, new ArrayList<Card>(list));
                                     pointer++;
                                     System.out.println("A pointer test: "+ pointer);
                                    System.out.println("Cards in List(in ifFalseMethod)"+list.size());
                                    findresult();                           
                                    //System.out.println("Last No matched found");
                                    }
                        
                              else if(isSet( list.get(i), list.get(j), list.get(k))){
                                ArrayList<Card> listdemo = new ArrayList<Card>(); 
                                     listdemo.add(list.get(i));
                                     listdemo.add(list.get(j));
                                     listdemo.add(list.get(k));
                                resultdemo.put(pointer2, listdemo);
                                        pointer2++;
                                     int temp;
                                     int a = i;
                                     int b = j; 
                                     int c = k;
                                    if(a > b ){
                                        temp = a;
                                        a = b;
                                        b = temp;
                                    } 
                                    if (a > c){
                                        temp = a;
                                        a = c;
                                        c = temp;
                                    }
                                    if(b > c){
                                        temp = b;
                                        b = c;
                                        c = temp;
                                    }
                                    System.out.println("AAAAAAAremove?");
                                     list.remove(a);
                                     list.remove(b-1);
                                     list.remove(c-2);
                                    if(list.size()<12){ 
                                     addcards();
                                     cardS=cardS+3;
                                     System.out.println("AAAAAAAr+++++++");
                                    }
                                      for(Card cards : list){
                                        System.out.println(cards.toString());
                                    }
                                      
                                  autoresult.put(pointer, new ArrayList<Card>(list));
                                     
                                     
                                     pointer++;
                                     findresult();
                                     System.out.println("Cards in List(in ifTRUEMethod)"+list.size());
                                     
                                    }
//                                    else if((i == list.size()-3 && j == list.size()-2 && k == list.size()-1)){
//                                    addcards();
//                                    cardS=cardS+3;
//                                     autoresult.put(pointer, new ArrayList<Card>(list));
//                                     pointer++;
//                                     System.out.println("A pointer test: "+ pointer);
//                                    System.out.println("Cards in List(in ifFalseMethod)"+list.size());
//                                    findresult();                           
//                                    //System.out.println("Last No matched found");
//                                    }
                        
                        
                             }
                             else if(cardS > 77){
                            if(isSet( list.get(i), list.get(j), list.get(k))){
                                 ArrayList<Card> listdemo = new ArrayList<Card>(); 
                                     listdemo.add(list.get(i));
                                     listdemo.add(list.get(j));
                                     listdemo.add(list.get(k));
                                 resultdemo.put(pointer2, listdemo);
                                        pointer2++;
                                     int temp;
                                     int a = i;
                                     int b = j; 
                                     int c = k;
                                    if(a > b ){
                                        temp = a;
                                        a = b;
                                        b = temp;
                                    } 
                                    if (a > c){
                                        temp = a;
                                        a = c;
                                        c = temp;
                                    }
                                    if(b > c){
                                        temp = b;
                                        b = c;
                                        c = temp;
                                    }
                                    System.out.println("BBBBBBremove?");
                                     list.remove(a);
                                     list.remove(b-1);
                                     list.remove(c-2);
                                   autoresult.put(pointer, new ArrayList<Card>(list));
                                     pointer++;
                                     System.out.println("B pointer test: "+ pointer);
                                     for(Card cards : list){
                                        System.out.println(cards.toString());
                                    }
                                     System.out.println("A  Cards in List(in ifTRUEMethod)"+list.size());
                                     findresult(); 
                                    }
                              else if((i == list.size()-3 && j == list.size()-2 && k == list.size()-1)){
                                    
                                   System.out.println("No Result Found");
                              }
                             }
                        else{
                            if(isSet( list.get(i), list.get(j), list.get(k))){
                                 ArrayList<Card> listdemo = new ArrayList<Card>(); 
                                     listdemo.add(list.get(i));
                                     listdemo.add(list.get(j));
                                     listdemo.add(list.get(k));
                                 resultdemo.put(pointer2, listdemo);
                                        pointer2++;
                                System.out.println(">>>>>"+cardS+"<<<<<");
                                     int temp;
                                     int a = i;
                                     int b = j; 
                                     int c = k;
                                    if(a > b ){
                                        temp = a;
                                        a = b;
                                        b = temp;
                                    } 
                                    if (a > c){
                                        temp = a;
                                        a = c;
                                        c = temp;
                                    }
                                    if(b > c){
                                        temp = b;
                                        b = c;
                                        c = temp;
                                    }
                                    System.out.println("CCCCCCCremove?");
                                     list.remove(a);
                                     list.remove(b-1);
                                     list.remove(c-2);
                                   if(list.size()<12){ 
                                     addcards();
                                     cardS=cardS+3;
                                    }
                                    for(Card cards : list){
                                        System.out.println(cards.toString());
                                    }
                                    autoresult.put(pointer, new ArrayList<Card>(list));
                                    System.out.println("nimabi>>>>>>>>>>>>>>>>>>>>>size:"+autoresult.size());
                                    ArrayList<Card> test2 =  autoresult.get(pointer);
                                   for(Card cards : test2){
                                         System.out.println(cards.toString());

                                   }                                     
                                     
                                     pointer++;
                                     System.out.println("C pointer test: "+ pointer);
                        
                                     
                                     
                                     System.out.println("C  Cards in List(in ifTRUEMethod)"+list.size());
                                     findresult();
                            }
                     else if((i == list.size()-3 && j == list.size()-2 && k == list.size()-1)){
                                    
                         if(isSet( list.get(i), list.get(j), list.get(k))){
                               ArrayList<Card> listdemo = new ArrayList<Card>(); 
                                     listdemo.add(list.get(i));
                                     listdemo.add(list.get(j));
                                     listdemo.add(list.get(k));
                                 resultdemo.put(pointer2, listdemo);
                                        pointer2++;
                                     int temp;
                                     int a = i;
                                     int b = j; 
                                     int c = k;
                                    if(a > b ){
                                        temp = a;
                                        a = b;
                                        b = temp;
                                    } 
                                    if (a > c){
                                        temp = a;
                                        a = c;
                                        c = temp;
                                    }
                                    if(b > c){
                                        temp = b;
                                        b = c;
                                        c = temp;
                                    }
                                    System.out.println("BBBBBBremove?");
                                     list.remove(a);
                                     list.remove(b-1);
                                     list.remove(c-2);
                                   autoresult.put(pointer, new ArrayList<Card>(list));
                                     pointer++;
                                     System.out.println("B pointer test: "+ pointer);
                                     for(Card cards : list){
                                        System.out.println(cards.toString());
                                    }
                                     System.out.println("A  Cards in List(in ifTRUEMethod)"+list.size());
                                     findresult();
                         }
                         
                         else{
                                    addcards();
                                    cardS=cardS+3;
                                    //ArrayList<Card> 
                                     autoresult.put(pointer, new ArrayList<Card>(list));
                                    System.out.println("D pointer test: "+ pointer);
                                    pointer++;
                                    System.out.println("D  Cards in List(in ifFalseMethod)"+list.size());
                                    findresult();
                         }
                     }
                    }
                     
             }
               
         }
           
     }
        autoresult.put(pointer, new ArrayList<Card>(list));
        pointer++;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Finally, not matches found, Last Cards in List : "+list.size());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for(Card cards : list){
         System.out.println(cards.toString());
        }
         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
 }
   public void addcards(){
            list.add(cards.get(cardS+1));
            list.add(cards.get(cardS+2));
            list.add(cards.get(cardS+3));
   }
   
   public void subfindresult(int i,int j, int k){
       System.out.println(">>>>>>>>I:"+i);
       System.out.println(">>>>>>>>J:"+j);
       System.out.println(">>>>>>>>K:"+k);
        ArrayList<Card> subfindresultdemo2 = new ArrayList<Card>();
            subfindresultdemo2.add(list.get(i));
            subfindresultdemo2.add(list.get(j));
            subfindresultdemo2.add(list.get(k));
            subfindresultdemo.add(subfindresultdemo2);
   }
   
   
   public boolean findSet(int i,int j,int k)
   {
       System.out.println("AAAA>>>>>>>>I:"+i);
       System.out.println("AAAA>>>>>>>>J:"+j);
       System.out.println("AAAA>>>>>>>>K:"+k);
       boolean flag = false;
     if( isSet( list.get(i), list.get(j), list.get(k)) ) 
         {  
            System.out.println( "Congratulations ,This is a set!" ); 
                        subfindresult(i,j,k);
                            int temp;
                            int a = i;
                            int b = j; 
                            int c = k;
                           if(a > b ){
                               temp = a;
                               a = b;
                               b = temp;
                           } 
                           if (a > c){
                               temp = a;
                               a = c;
                               c = temp;
                           }
                           if(b > c){
                               temp = b;
                               b = c;
                               c = temp;
                           }
                            list.remove(a);
                            list.remove(b-1);
                            list.remove(c-2);
                            
                         if(cardS<81){
                            addcards();
                            cardS +=3;
                            getresult();
                         }
                         else{
                                System.out.println( "Cards Finish." ); 
                            }
                         flag = true;
         }
     
     else{
            System.out.println( "Sorry ,This is not a set!" );
            System.out.println("Typed 0 to stop this games");
            System.out.println("Typed 1 to try again");
            System.out.println("Typed 2 to add 3 new cards"); 
        }
     return flag;
   } 
   
   private void print(ArrayList<Card> list)
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
 
 
//    
//     public static void main(String[] args) throws IOException   
//    { 
//        
//        Engine engine=new Engine();
//        engine.initcards();
//        //engine.play();
//    }  

}  
   