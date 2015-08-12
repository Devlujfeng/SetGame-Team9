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
@WebServlet("/mobile")
public class mobileJson extends HttpServlet{
    @Inject private GameList gamlist;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                ArrayList<Card> MobileJson = gamlist.mobileCreateGame();
                int x = gamlist.getI();
                gamlist.getMobilegamelist().get(x).getresult();
                JsonArrayBuilder cardlist = Json.createArrayBuilder();
                for(Card cards : MobileJson){
                    cardlist.add(
                    Json.createObjectBuilder()
                            .add("CardNumber",cards.getImgNo())
                    );        
                }
                JsonArray cardlistarray = cardlist.build();
                try(PrintWriter pw = resp.getWriter()){
                    pw.println(cardlistarray.toString());
                    System.out.println("JsonMobile ----------data test");
                }
        
        
    }
    
    
    
    
}
