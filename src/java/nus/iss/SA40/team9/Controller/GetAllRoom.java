/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Controller;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nus.iss.SA40.team9.SetGame.GameList;
import javax.json.JsonArray;


@WebServlet("/getallroom")
public class GetAllRoom extends HttpServlet{
    @Inject private GameList gameList;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       
        Set<String> keys = gameList.GetAllRoom();       
        String[] rooms = keys.toArray(new String[keys.size()]);
        System.out.println(keys.size());

        for(int i=0; i < keys.size(); i++){
            System.out.println(rooms[i]);
        }
        JsonArrayBuilder JsonAB = Json.createArrayBuilder();
            for(int i=0; i < keys.size(); i++){
            JsonAB.add(
            Json.createObjectBuilder()
            .add("rooms",rooms[i])
            );
             }
            JsonArray allrooms = JsonAB.build(); 
                try (PrintWriter pw = resp.getWriter()) {
                    pw.println(allrooms.toString());
                     System.out.println(allrooms.toString());
                       System.out.println(">>>>>sent all rooms in jsonBuild");
                }
    }
    
    
}
