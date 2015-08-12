/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetGamesController;

import SetGamesModel.Card;
import SetGamesModel.IsSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import javax.servlet.http.HttpSession;


/**
 *
 * @author zhangzhonghua
 */
@WebServlet("/FindSetServlet")
public class FindSetServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
     HttpSession session=req.getSession();   
     ArrayList<Card> cardsOn=(ArrayList<Card>) session.getAttribute("cardsOn");
     ArrayList findSet=new ArrayList();
     IsSet DecisionSet=new IsSet();
        System.out.println(cardsOn);
     for(int i=0;i<cardsOn.size()-2;i++)
     {
        for(int j=i+1;j<cardsOn.size()-1;j++)
        {
          for(int k=j+1;k<cardsOn.size();k++)
          {
          if(DecisionSet.isSet(cardsOn.get(i),cardsOn.get(j),cardsOn.get(k)))
          {
           String s=(i+1)+","+(j+1)+","+(k+1);
           findSet.add(s);
          }
          }
        }
     }
 
     System.out.println("hello"+findSet);
       JsonArrayBuilder findsetList=Json.createArrayBuilder(); //固定
        for (Object findSet1 : findSet) {
            findsetList.add
            (Json.createObjectBuilder().add("findset", findSet1.toString()));
        }
        JsonArray setarray = findsetList.build();
        try(PrintWriter pw=resp.getWriter()){
        pw.println(setarray.toString());
       
        }
   
        
   
    }

  
    
   
}
