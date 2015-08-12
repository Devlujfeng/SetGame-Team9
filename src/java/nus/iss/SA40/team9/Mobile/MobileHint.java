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
import javax.json.JsonObject;
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
@WebServlet("/mobilehint")
public class MobileHint extends HttpServlet{
    @Inject private GameList gamelist;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("test Mobile Hint");
        int x = gamelist.getI();
    ArrayList<Card> Mobilehintlist = gamelist.getMobilegamelist().get(x).getresult();
        JsonObject jobj = Json.createObjectBuilder()
                .add("hint1", Mobilehintlist.get(0).getImgNo())
                .add("hint2", Mobilehintlist.get(1).getImgNo())
                .add("hint3", Mobilehintlist.get(2).getImgNo())
                .build();
        try(PrintWriter pw = resp.getWriter()){
            
            pw.println(jobj.toString());
            System.out.println("Json Mobile Hint Ssent");
            
        }
        
    }
    
}
