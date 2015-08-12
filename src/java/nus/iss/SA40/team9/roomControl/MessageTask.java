/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.roomControl;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import nus.iss.SA40.team9.SetGame.Card;
import nus.iss.SA40.team9.SetGame.GameList;
import org.glassfish.jersey.media.sse.OutboundEvent;

/**
 *
 * @author cmlee
 */
public class MessageTask implements Runnable {

    private UserList participants;
    private String chatname;
    private ArrayList<Card> cardlist;
    private ArrayList<ArrayList<Card>> cardresultlist;
    int mx;
    private String username;
         
    
    public MessageTask(UserList p,String cn, ArrayList<Card> gl,ArrayList<ArrayList<Card>> csl,int m,String un) {

        participants = p;
        chatname = cn;
        cardlist=gl;
        cardresultlist = csl;
        mx = m;
        username=un;
    }

    @Override
    public void run() {
        ArrayList<Card> Finalresult = cardresultlist.get(mx);
        System.out.println(">>> broadcasting message: " + chatname);
        System.out.println(">>> MX checking: " + mx);
        JsonArrayBuilder JsonAB = Json.createArrayBuilder();
          for(int i=0; i < cardlist.size(); i++){
            JsonAB.add(
            Json.createObjectBuilder()
            .add("cardNumber",cardlist.get(i).getImgNo())
            .add("username",username)
            .add("card1", Finalresult.get(0).getImgNo())
            .add("card2", Finalresult.get(1).getImgNo())
            .add("card3", Finalresult.get(2).getImgNo())
            );
             }
            JsonArray cardslistback = JsonAB.build(); 
            System.out.println(">>> packaged Jsonarray");
        OutboundEvent data = new OutboundEvent.Builder()
                .data(JsonArray.class, cardslistback)
                .name(chatname)
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .build();
            System.out.println(">>> packaged Jsonarray sent");
            
        participants.send(data);
    }

}
