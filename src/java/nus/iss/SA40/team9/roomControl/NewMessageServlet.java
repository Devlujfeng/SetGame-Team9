/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.roomControl;

import nus.iss.SA40.team9.rest.ChatroomResource;
import java.io.IOException;
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
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.sse.OutboundEvent;

@WebServlet("/newMessage")
public class NewMessageServlet extends HttpServlet {
    
    @Inject private ChatroomResource cr;
    private ParticipantList participants;
    
    @Resource(lookup = "concurrencySetGame")
    private ManagedScheduledExecutorService service;
    
    @Inject
    public void setParticipantList(ParticipantList p) {
        participants = p;
    }
    
//    @Resource(lookup = "concurrencySetGame")
//    public void setMyFristPool(ManagedScheduledExecutorService svc) {
//        service = svc;
//    }    

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String name = req.getParameter("name2");
        String msg = req.getParameter("message2");
        String chatname = req.getParameter("chatname2");
        System.out.println(name + ">>> " + msg+ ">>>"+ chatname);
        
        service.submit(new BroadcastMessageTask(name, msg, participants,chatname));
        
        resp.setStatus(HttpServletResponse.SC_OK);
    }        
    
}
