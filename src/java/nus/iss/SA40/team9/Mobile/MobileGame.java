/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;
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

@WebServlet("/mobilesend")
public class MobileGame extends HttpServlet{

    @Inject private GameList gamelist;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int card1 = Integer.parseInt(req.getParameter("card1"));
        int card2 = Integer.parseInt(req.getParameter("card2"));
        int card3 = Integer.parseInt(req.getParameter("card3"));
        int x = gamelist.getI();
        System.out.println(x);
        
        
        boolean flag = gamelist.getMobilegamelist().get(x).findSet(card1, card2, card3);
        if(flag){
            ArrayList<Card> cardssuit = gamelist.getMobilegamelist().get(x).getList();
            JsonArrayBuilder jsonAobj = Json.createArrayBuilder();
            for(int i = 0; i<cardssuit.size();i++){
                jsonAobj.add(
                        Json.createObjectBuilder()
                        .add("cardsult", cardssuit.get(i).getImgNo()) 
                ); 
            }
            JsonArray cardArray = jsonAobj.build();
            try(PrintWriter pw = resp.getWriter()){
            pw.println(cardArray.toString());
            System.out.println("[MOBILE ]card test AAA");
            }

        }
        else{
            JsonArrayBuilder jsonAobj2 = Json.createArrayBuilder();
                jsonAobj2.add(
                        Json.createObjectBuilder()
                        .add("cardsult", "0") 
                ); 
            JsonArray cardArray = jsonAobj2.build();
            try(PrintWriter pw = resp.getWriter()){
            pw.println(cardArray.toString());
            System.out.println("[MOBILE ]card test 00000");
            }
        }
    }
}
