package edu.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        // TODO: check inputs
        Object ejbComponentImpl = req.getSession().getAttribute("ejbComponent");
        EJBComponent ejbComponent;

        try {
            if (ejbComponentImpl == null) {

                InitialContext initialContext = new InitialContext();
                ejbComponent = (EJBComponent) initialContext.lookup("java:module/EJBComponentImpl");

                req.getSession().setAttribute("ejbComponent", ejbComponent);

            }else {

                ejbComponent = (EJBComponent) ejbComponentImpl;
            }

            boolean loginResult = ejbComponent.login(login, password);

            if (loginResult) {
                resp.sendRedirect("getMessage.html");

                System.out.println();

            } else {
                resp.sendRedirect("gooutwrongdata.html");
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
