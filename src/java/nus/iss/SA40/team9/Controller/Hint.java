/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Controller;

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
@WebServlet("/hint")
public class Hint extends HttpServlet{
    @Inject private GameList gamelist;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String m = req.getParameter("gameid");
        System.out.println(">>>>>><<<<<<"+ m);
        ArrayList<Card> hintlist = gamelist.getGamelist().get("room"+m).getresult();
        System.out.println("size test "+ hintlist.size());
         System.out.println("cards matching test "+ hintlist.get(0).getImgNo()+">>>>>>"+hintlist.get(1).getImgNo()+">>>>>>>>>"+hintlist.get(2).getImgNo());
         JsonObject hintobj = Json.createObjectBuilder()
                 .add("hint1", hintlist.get(0).getImgNo())
                 .add("hint2", hintlist.get(1).getImgNo())
                 .add("hint3", hintlist.get(2).getImgNo())
                 .build();
         try(PrintWriter pw = resp.getWriter()){
             pw.println(hintobj.toString());
             System.out.println("Json hint sent");
         }
    }
    
    
    
}
