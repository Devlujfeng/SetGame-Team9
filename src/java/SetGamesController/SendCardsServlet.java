/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetGamesController;

import SetGamesModel.Card;
import SetGamesModel.Dack;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
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
@WebServlet("/SendCardServlet")
public class SendCardsServlet extends HttpServlet{
  

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
     
        System.out.println("test111");
     Dack dack = new Dack();
     dack.init();
     ArrayList<Card> cards = dack.getCards(); 
     int cardSend=0;   //记录已经发出的牌的个数
     ArrayList<Card> cardsOn = new ArrayList<Card>();  //桌面上正在玩牌的list
        for( int i=0 ; i<12 ; i++ ) 
       {   
       cardsOn.add(cards.get(i));
       cardSend++;
       } 
    
        
        
        JsonArrayBuilder cardsOnList=Json.createArrayBuilder(); //固定
        for (Card cardsOn1 : cardsOn) {
            cardsOnList.add(
            Json.createObjectBuilder().add("CardsNo",cardsOn1.getImgNo())
            );
        }
          JsonArray cardsarray = cardsOnList.build();
        try(PrintWriter pw=resp.getWriter()){
        pw.println(cardsarray.toString());
       
        }
        
        
    HttpSession session=req.getSession();
    session.setAttribute("cardsOn",cardsOn);
    session.setAttribute("cardSend", cardSend);
    session.setAttribute("cards",cards);
    
    }
    
    
   
}
