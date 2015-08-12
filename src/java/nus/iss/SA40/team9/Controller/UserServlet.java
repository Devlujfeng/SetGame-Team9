package nus.iss.SA40.team9.Controller;


import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import nus.iss.SA40.team9.EJB.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nus.iss.SA40.team9.Model.*;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.jms.Session;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


@WebServlet("/user")
public class UserServlet extends HttpServlet{
    
    @EJB private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg;
        String AccountName = req.getParameter("accountname");
        String Email = req.getParameter("email");
        String Name = req.getParameter("name");
        String Password = req.getParameter("password");
        System.out.println("Reg test"+AccountName);
        System.out.println("Reg test"+Email);
        System.out.println("Reg test"+Name);
        System.out.println("Reg test"+Password);
        Users user = new Users();
        user.setAccountName(AccountName);
        user.setName(Name);
        user.setEmail(Email);
        user.setPassword(Password);

        if(userBean.AddUser(user)){
            msg = "1";
            resp.setStatus(HttpServletResponse.SC_OK);
            HttpSession session = req.getSession();
            session.setAttribute("User", user.getAccountName());
            session.setAttribute("Points",user.getPoints());
                       JsonObject jobj = Json.createObjectBuilder()
                    .add("msg", msg)
                    .build();
            
            try(PrintWriter pw = resp.getWriter()){
                pw.println(jobj.toString());
                System.out.println(">>>>>>>Json sent222");
            }
            
        }
        else{
            msg = "Your AccountName has been registered by others, please change another one.";
            JsonObject jobj = Json.createObjectBuilder()
                    .add("msg", msg)
                    .build();
            
            try(PrintWriter pw = resp.getWriter()){
                pw.println(jobj.toString());
                System.out.println(">>>>>>>Json sent");
            }
             
        }

    }
    
    
    
}
