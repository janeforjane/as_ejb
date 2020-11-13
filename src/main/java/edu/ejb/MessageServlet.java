package edu.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageServlet", urlPatterns = "/MessageServlet")
public class MessageServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Object ejbComponentImpl = req.getSession().getAttribute("ejbComponent");
        EJBComponent ejbComponent;


        try {
            if (ejbComponentImpl == null) {

                resp.sendRedirect("gooutneedlogin.html");

            }else {

                ejbComponent = (EJBComponent) ejbComponentImpl;

                String message = ejbComponent.getMessage();

                req.setAttribute("message", message);
                this.getServletContext().getRequestDispatcher("/messageForm.jsp").forward(req,resp);

            }
        } catch (Exception e) {
            resp.sendRedirect("gooutneedlogin.html");
        }

    }
}
