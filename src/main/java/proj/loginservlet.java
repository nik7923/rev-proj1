package proj;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class loginservlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        employeeaction action = new employeeaction();
        boolean check = false;
        try {
            check = action.checklogin(username, password);
        } catch (Exception e) {
        }
        if (check) {
            Cookie cookie = new Cookie("username", username);
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            resp.addCookie(cookie);
            resp.sendRedirect("employeehome.html");
        } else if (username.equalsIgnoreCase("manager") && password.equals("manager")) {
            Cookie cookie = new Cookie("manager", username);
            resp.addCookie(cookie);
            HttpSession session = req.getSession();
            resp.sendRedirect("manhome.html");
        } else {
            pr.print("<h2 style='text-align:center; margin-bottom:-20px;'>Wrong password or username doesn't exist</h2>");
            req.getRequestDispatcher("employeelogin.html").include(req,resp);
        }
        pr.close();
    }
}
