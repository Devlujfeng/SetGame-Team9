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
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonObject;
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
@WebServlet("/IsSetServlet")
public class IsSetServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
     HttpSession session=req.getSession();
     
     System.out.println("test");
     
     String a=req.getParameter("c1");    
     String b=req.getParameter("c2");
     String c=req.getParameter("c3");
      
          
     System.out.println(">>>>>>>>"+a);
    int l = Integer.parseInt(a);
    int m = Integer.parseInt(b);
    int n = Integer.parseInt(c);
   
    IsSet DecisionSet=new IsSet();
    
        
      
    ArrayList<Card> cards=(ArrayList<Card>) session.getAttribute("cards");
   
    
    ArrayList<Card> cardsOn=(ArrayList<Card>) session.getAttribute("cardsOn");     
 
    int cardsend= (int) session.getAttribute("cardSend");

  boolean sign=DecisionSet.isSet(cardsOn.get(l),cardsOn.get(m),cardsOn.get(n));
  System.out.println(">>>>>>>>"+l+","+m+","+n); 
   
  String flag="";
    
    if(sign)
    { 
      flag="1";
      System.out.println(">>>>>>>>"+cardsOn.get(l).getColor()+cardsOn.get(m).getColor()+cardsOn.get(n).getColor());
    System.out.println(">>>>>>>>"+cardsOn.get(l).getNum()+cardsOn.get(m).getNum()+cardsOn.get(n).getNum());
    System.out.println(">>>>>>>>"+cardsOn.get(l).getPattern()+cardsOn.get(m).getPattern()+cardsOn.get(n).getPattern());
    System.out.println(">>>>>>>>"+cardsOn.get(l).getShape()+cardsOn.get(m).getShape()+cardsOn.get(n).getShape());
    System.out.println(">>>>>>>>"+cardsOn.get(l).getImgNo()+cardsOn.get(m).getImgNo()+cardsOn.get(n).getImgNo());
    }
    else
    {
      flag="2";  
    }
    
        JsonObject flagJsonObject=(JsonObject) Json.createObjectBuilder()
                .add("flag",flag)
                .add("card1",cardsOn.get(l).getImgNo())
                .add("card2",cardsOn.get(m).getImgNo() )
                .add("card3",cardsOn.get(n).getImgNo() )
                .build();
        
        try(PrintWriter pw=resp.getWriter()){
        pw.println(flagJsonObject.toString());
        }
       
   
    }

  
    
   
}
