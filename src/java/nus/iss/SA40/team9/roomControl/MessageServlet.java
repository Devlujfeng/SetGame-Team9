/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.roomControl;

import nus.iss.SA40.team9.rest.GameroomResource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import nus.iss.SA40.team9.SetGame.Card;
import nus.iss.SA40.team9.SetGame.GameList;
import org.glassfish.jersey.media.sse.OutboundEvent;

@WebServlet("/playgame")
public class MessageServlet extends HttpServlet {
    
    @Inject private GameroomResource cr;
    private UserList participants;
    @Inject private GameList gamelist;
    int m =0;
    
    @Resource(lookup = "concurrencySetGame")
    private ManagedScheduledExecutorService service;
    
    @Inject
    public void setParticipantList(UserList p) {
        participants = p;
    }
    
//    @Resource(lookup = "concurrencySetGame")
//    public void setMyFristPool(ManagedScheduledExecutorService svc) {
//        service = svc;
//    }    

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        int card1 = Integer.parseInt(req.getParameter("card1"));
        int card2 = Integer.parseInt(req.getParameter("card2"));
        int card3 = Integer.parseInt(req.getParameter("card3"));
        String username = req.getParameter("username");
        String chatname = req.getParameter("chatname");
        System.out.println(card1 + ">>>" + card2+ ">>>"+card3+">>>"+chatname);
        
        
        
        if(gamelist.retrieveResult(chatname, card1, card2, card3)){
               ArrayList<ArrayList<Card>> cardresultlist = gamelist.getresultarraylist(chatname);
               ArrayList<Card> cardlist = gamelist.getAllresultlist(chatname);
            service.submit(new MessageTask(participants,chatname,cardlist,cardresultlist,m,username));
            m++;
        }
        else{
            req.setAttribute("flag", "Wrong");
            
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }        
    
}
