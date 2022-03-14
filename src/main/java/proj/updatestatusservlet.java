package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class updatestatusservlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("user");
        int amount = Integer.parseInt(req.getParameter("amount"));
        Date date = new Date();
        String date1 = date.toString();
        employeeaction action = new employeeaction();
        List<Employee> name1 = action.view(username);
        String name = name1.get(0).getName();
        action.updatestatus(username,name,date1,amount);

        req.getRequestDispatcher("navbar.html").include(req,resp);
        pr.print("<style>\n" +
                "    #h1 {\n" +
                "        font-size:35px;\n" +
                "        font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\n" +
                "        color:rgb(91, 75, 177);\n" +
                "        margin-top:50px;\n" +
                "        margin-left:auto;\n" +
                "        margin-right:auto;\n" +
                "        width: 350px;\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "    <h1 id=\"h1\">Request submitted!</h1>\n" +
                "</body>");
        pr.close();

    }
}
