package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class updateservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("user");

        employeeaction action = new employeeaction();
        action.update(username,name,email,gender,country);
        pr.print("<br>");
        resp.sendRedirect("viewservlet");
        pr.close();


    }
}
