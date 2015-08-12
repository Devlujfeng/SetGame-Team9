/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ScheduledFuture;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.core.MediaType;
import nus.iss.SA40.team9.SetGame.Card;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

/**
 *
 * @author cmlee
 */
public class CounterTask implements Runnable {
    private HashMap<Integer, ArrayList<Card>> cardlist;
    private final EventOutput eo;
    private String roomname;
    private ScheduledFuture<?> future = null;
    int mx = 0;
    HashMap<Integer, ArrayList<Card>> resultdemo;
    public CounterTask(HashMap<Integer, ArrayList<Card>> c, EventOutput eo, String rm,HashMap<Integer, ArrayList<Card>> rmd) {
        cardlist = c;
        this.eo = eo;
        roomname = rm;
        resultdemo =rmd;
    }
    public void setHandle(ScheduledFuture<?> f) {
        future = f;
    }
    @Override
    public void run() {           
        System.out.println(">>>check AutoListSize Second test:"+cardlist.size());
        System.out.println(">>>check MX value"+mx);
          ArrayList<Card> cardtransmx = cardlist.get(mx);
          ArrayList<Card> autoresultdemo = resultdemo.get(mx);
          JsonArrayBuilder JsonAB = Json.createArrayBuilder();
          for(int i=0; i < cardtransmx.size(); i++){
            JsonAB.add(
            Json.createObjectBuilder()
            .add("cardid",cardtransmx.get(i).getImgNo())
            .add("carddemo1", autoresultdemo.get(0).getImgNo())
            .add("carddemo2", autoresultdemo.get(1).getImgNo())
            .add("carddemo3", autoresultdemo.get(2).getImgNo())
            );
             }
            JsonArray cardslistback = JsonAB.build(); 
        System.out.println(">>>check MX value test2"+mx);
            System.out.println(">>> packaged Jsonarray");
               
            OutboundEvent data = new OutboundEvent.Builder()
                .data(JsonArray.class, cardslistback)
                
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .build();
            System.out.println(">>> packaged Jsonarray sent");
            mx++;
        
        try {
            eo.write(data);
        } catch (Exception ex) {
            future.cancel(true);
        }
        System.out.println(">>> count = ");
    }
}
