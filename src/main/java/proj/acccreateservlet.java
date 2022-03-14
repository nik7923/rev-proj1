package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class acccreateservlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        employeeaction action = new employeeaction();
        try {
            action.createacc(username,password);
        } catch (Exception e) {
            pr.print("<script>alert('Username already exists')</script>");
            req.getRequestDispatcher("createacc.html").include(req,resp);
            pr.close();
            return;
        }
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        action.update(username,name,email,gender,country);
        pr.print("<h2 style='text-align:center;'>Account created!</h2>");
        req.getRequestDispatcher("employeelogin.html").include(req,resp);
    }
}
