/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nus.iss.SA40.team9.EJB.UserBean;

/**
 *
 * @author devlu
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet{
    
    @EJB private UserBean userBean;
            
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login test55");
         String msg; 
         String AccountName = req.getParameter("accountname");
         String Password = req.getParameter("password");
         System.out.println("Login test44");
         if(userBean.userLogin(AccountName, Password)){
             msg = "1";
             resp.setStatus(HttpServletResponse.SC_OK);
            //System.out.println("Login test33");
            HttpSession session = req.getSession();
            session.setAttribute("User", AccountName);
            //System.out.println("Login test22");
             
            JsonObject jobj = Json.createObjectBuilder()
                    .add("msg", msg)
                    .build();
            
            try(PrintWriter pw = resp.getWriter()){
                pw.println(jobj.toString());
                System.out.println(">>>>>>>Json sent3333");
            
         }
         }
         else{
            msg = "Password or AccountName is incorrect.";
            JsonObject jobj = Json.createObjectBuilder()
                    .add("msg", msg)
                    .build();
            
            try(PrintWriter pw = resp.getWriter()){
                pw.println(jobj.toString());
                System.out.println(">>>>>>>Json sent222");
            }
    }
    }
}
