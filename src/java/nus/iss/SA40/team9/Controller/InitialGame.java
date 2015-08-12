/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nus.iss.SA40.team9.SetGame.Card;
import nus.iss.SA40.team9.SetGame.GameList;

/**
 *
 * @author devlu
 */
@WebServlet("/initcards")
public class InitialGame extends HttpServlet{
     ArrayList<Card> cardlist = new ArrayList<>();
    @Inject GameList gameList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String roomid = req.getParameter("roomid");
       
        cardlist =  gameList.getinitcards(roomid);
        System.out.println(cardlist.size());
        
        JsonArrayBuilder JsonAB = Json.createArrayBuilder();
        
                for(Card cards: cardlist) {
                            JsonAB.add(
                            Json.createObjectBuilder()
                            .add("cardId", cards.getImgNo())
                 );
                 }
                JsonArray allcards = JsonAB.build(); 
                try (PrintWriter pw = resp.getWriter()) {
                    pw.println(allcards.toString());
                     System.out.println(allcards.toString());
                       System.out.println(">>>>>sent all cards in json Builder ");
                }   
    }
}
