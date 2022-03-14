package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class viewservlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("user");
        employeeaction action = new employeeaction();
        Employee emp1 = action.view(username).get(0);
        pr.print("<style>\n" +
                "    @import url('https://fonts.googleapis.com/css2?family=Satisfy&display=swap');\n" +
                "\n" +
                "    #h1 {\n" +
                "        font-size:65px;\n" +
                "        font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\n" +
                "        color:rgb(91, 75, 177);\n" +
                "        margin-top:90px;\n" +
                "        margin-right:300px;\n" +
                "        text-align:right;\n" +
                "        font-family: \"Satisfy\";\n" +
                "\n" +
                "    }\n" +
                "    #div1 {\n" +
                "        color:rgb(91, 75, 177);\n" +
                "        width:300px;\n" +
                "        align-self:right;\n" +
                "        height:300px;\n" +
                "        margin-top:-350px;\n" +
                "        margin-left: 900px;\n" +
                "        font-family:cursive;\n" +
                "        font-size:24px;\n" +
                "    }\n" +
                "    #img1 {\n" +
                "        margin-top:80px;\n" +
                "        width:20%;\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "    <h1 id=\"h1\">Welcome "+username+"!!</h1>\n" +
                "    <img id=\"img1\" src=\"images/flower.png\" alt=\"\">\n" +
                "    <div id=\"div1\">\n" +
                "        <div>Your name: "+emp1.getName()+"</div>\n" +
                "        <br>\n" +
                "        <div>Your email: "+emp1.getEmail()+"</div>\n" +
                "        <br>\n" +
                "        <div>Your gender: "+emp1.getGender()+"</div>\n" +
                "        <br>\n" +
                "        <div>Your country: "+emp1.getCountry()+"</div>\n" +
                "        <br>\n" +
                "        <a style=\"font-family:'Times New Roman', Times, serif; font-size:20px; text-decoration:none;\" href='updateemp.html'>Update info</a>\n" +
                "    </div>\n" +
                "</body>");
        req.getRequestDispatcher("navbar.html").include(req,resp);
        pr.close();

    }
}
