/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validate")
public class Uservalidation extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        HttpSession session = req.getSession();
        String useraccount = (String)session.getAttribute("User");
        System.out.println(useraccount);
        if(useraccount == null ){
             JsonObject jsonobj2 = Json.createObjectBuilder()
                    .add("UserAccount", "null")
                    .build();
            try(PrintWriter pw = resp.getWriter()){
                pw.println(jsonobj2.toString());
                System.out.println(">>>>>>>Json sent");
            }
        }
        else{
            JsonObject jsonobj = Json.createObjectBuilder()
                    .add("UserAccount", useraccount)
                    .build();
            try(PrintWriter pw = resp.getWriter()){
                pw.println(jsonobj.toString());
                System.out.println(">>>>>>>Json sent");
            }
        }
        
    }
    
}
