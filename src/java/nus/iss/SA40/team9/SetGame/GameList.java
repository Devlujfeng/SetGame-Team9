/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.SetGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author devlu
 */
@ApplicationScoped
public class GameList {
      
   HashMap<String, Engine> gamelist = new HashMap<>();
    ArrayList<Engine> mobilegamelist = new ArrayList<>();
    int i = -1;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public ArrayList<Engine> getMobilegamelist() {
        return mobilegamelist;
    }

    public void setMobilegamelist(ArrayList<Engine> mobilegamelist) {
        this.mobilegamelist = mobilegamelist;
    }
    public HashMap<String, Engine> getGamelist() {
        return gamelist;
    }

    public void setGamelist(HashMap<String, Engine> gamelist) {
        this.gamelist = gamelist;
    }


    
            public ArrayList<Card> mobileCreateGame(){
                Engine engine = new Engine();
                mobilegamelist.add(engine);
                engine.getList();
                i++;
                return engine.getList();
            }
    
    
    
            public String GameGenerator(){
                String gameid;
                Random r = new Random(); // Random selects cards
                int x = r.nextInt(1000000);
                gameid = "room" + x;
                Engine engine=new Engine();
                gamelist.put(gameid, engine);
                System.out.println("No of Game Room: " + gamelist.size());
                System.out.println("No of Game Room: " + gamelist.size());
                return gameid;
                
            }
            public Set<String> GetAllRoom(){
                Set<String> allroomskey = gamelist.keySet();
                System.out.println("No of Game Room: <GetALLROOM>" + gamelist.size());
                return allroomskey;
            }
            public ArrayList<Card> getinitcards(String roomname){
                
                return gamelist.get("room"+roomname).initcards();
            }
            
            
            
            public boolean retrieveResult(String roomname,int i,int j,int k){
                 return gamelist.get("room"+roomname).findSet(i, j, k);
            }
            
            
            public ArrayList<ArrayList<Card>> getresultarraylist(String roomname){
                
                ArrayList<ArrayList<Card>> test = gamelist.get("room"+roomname).getSubfindresultdemo();
                    
                    System.out.println("lujianfeng>>>>>>>>>>>>>>>>>>>>>size:"+test.size());
                for(int i =0; i<test.size(); i++){
                    System.out.println("No:"+i);
                     ArrayList<Card> test2 =  test.get(i);
                    for(Card cards : test2){
                          System.out.println(cards.toString());
                    } 
                     
                }
                System.out.println("lujianfeng>>>>>>>>>>>>>>>>>>>>>size:"+test.size());
                
                
                
                return gamelist.get("room"+roomname).getSubfindresultdemo();
            }
            public ArrayList<Card> getAllresultlist(String roomname){
                return gamelist.get("room"+roomname).getList();
            }
            
            
            
            public HashMap<Integer, ArrayList<Card>> autolistresult(String roomname){
                    gamelist.get("room"+roomname).findresult();
//                    
//                    ArrayList<ArrayList> test = gamelist.get("room"+roomname).getAutoresult();
//                    
//                    System.out.println("wangbadan>>>>>>>>>>>>>>>>>>>>>size:"+test.size());
//                for(int i =0; i<test.size(); i++){    
//                     ArrayList<Card> test2 =  test.get(i);
//                    for(Card cards : test2){
//                          System.out.println(cards.toString());
//                    } 
//                     
//                }
//                System.out.println("wangbadan>>>>>>>>>>>>>>>>>>>>>size:"+test.size());
                return gamelist.get("room"+roomname).getAutoresult();
                        
            }
            public HashMap<Integer, ArrayList<Card>> autolistresultdemo(String roomname){
            
            
            
                return gamelist.get("room"+roomname).getResultdemo();
            }
}
