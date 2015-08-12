/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nus.iss.SA40.team9.Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author devlu
 */
@WebServlet("/logout")

public class UserLogoutServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("get");
            String test = "123";
            
            req.getSession().invalidate();
            req.setAttribute("null", test);
            //RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            System.out.println("get2");

            System.out.println("get3");
            
        
    }

    
    
    
    
}
