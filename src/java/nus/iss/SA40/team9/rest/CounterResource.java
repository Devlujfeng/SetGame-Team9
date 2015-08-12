package nus.iss.SA40.team9.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.SseFeature;
import nus.iss.SA40.team9.Controller.CounterTask;
import nus.iss.SA40.team9.SetGame.Card;
import nus.iss.SA40.team9.SetGame.GameList;

@RequestScoped
@Path("counter/{result}")
public class CounterResource {
    @Inject private GameList gamelist;
    
    @Resource(lookup = "concurrencySetGame")
    private ManagedScheduledExecutorService service;
    
    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public Response get(
            @PathParam("result") String name) {
        System.out.println("Im in result Servlet"+ name);
        EventOutput eo = new EventOutput();
        HashMap<Integer, ArrayList<Card>> cardlistAuto = gamelist.autolistresult(name);
        HashMap<Integer, ArrayList<Card>> resultdemo = gamelist.autolistresultdemo(name);
        System.out.println(">>>check AutoListSize:"+cardlistAuto.size());
        CounterTask task = new CounterTask(cardlistAuto, eo,name, resultdemo);
        ScheduledFuture<?> future = 
        service.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);        
        task.setHandle(future);
                
        return (Response.ok(eo).build());  
    };
}
