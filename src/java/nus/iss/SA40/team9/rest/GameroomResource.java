package nus.iss.SA40.team9.rest;

import nus.iss.SA40.team9.roomControl.UserList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.SseFeature;

@RequestScoped
@Path("game/{chat}")
public class GameroomResource {
    
    @Inject private UserList participants;
     
     @GET     
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public Response connect(@PathParam("chat") String name) {
        
         System.out.println(">>> new connection resultresource "+ name);
         EventOutput eo = new EventOutput();
         participants.add(eo);
          System.out.println(">>> new connection resultresource"+ name);
         return (Response.ok(eo).build());
    }
}
