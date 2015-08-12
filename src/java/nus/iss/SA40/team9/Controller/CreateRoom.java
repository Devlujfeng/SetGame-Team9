/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nus.iss.SA40.team9.SetGame.GameList;


/**
 *
 * @author devlu
 */
@WebServlet("/game")
public class CreateRoom extends HttpServlet{

    @Inject private GameList GameList;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentGameId = GameList.GameGenerator();        
        System.out.println(">>>>>senteeer"+currentGameId);
                JsonObject gameid = Json.createObjectBuilder()
                .add("name", currentGameId)
                .build();

                try (PrintWriter pw = resp.getWriter()) {
                    pw.println(gameid.toString());
                       System.out.println(">>>>>sent"+currentGameId);
                }
    }
}
