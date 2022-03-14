package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class manviewallempinfoservlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        manageractions action = new manageractions();
        List<Employee> emps = action.viewall();
        pr.print("    <style>\n" +
                "        tr:nth-child(even) {background: rgb(245, 192, 236)}\n" +
                "        tr:nth-child(odd) {background: white}\n" +
                "        #table2 {\n" +
                "            border-collapse:collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        #table {\n" +
                "            margin-top:40px;\n" +
                "            margin-left:auto;\n" +
                "            margin-right:auto;\n" +
                "            overflow-y: auto;\n" +
                "            width: 55%;\n" +
                "            height: 520px;\n" +
                "        }\n" +
                "        #table thead tr {\n" +
                "            position:sticky;\n" +
                "            top: 0;\n" +
                "        }\n" +
                "        th{\n" +
                "         padding: 8px;\n" +
                "         font-size: 20px;\n" +
                "         text-align: center;\n" +
                "         color: rgb(59, 44, 83);\n" +
                "        }\n" +
                "        td {\n" +
                "        padding: 8px;\n" +
                "        font-size: 20px;\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <div id=\"table\">\n" +
                "        <table id=\"table2\" border=\"1\">\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <th>Username</th>\n" +
                "                <th>Name</th>\n" +
                "                <th>Gender</th>\n" +
                "                <th>Email</th>\n" +
                "                <th>Country</th>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody id=\"body\">\n");
        for (Employee each:emps) {
            pr.print("        <tr>\n" +
                    "            <td>"+each.getUsername() + "</td>\n" +
                    "            <td>"+each.getName()+"</td>\n" +
                    "            <td>"+each.getGender()+"</td>\n" +
                    "            <td>"+each.getEmail()+"</td>\n" +
                    "            <td>"+each.getCountry()+"</td>\n" +
                    "        </tr>");
        }
        pr.print("            </tbody>\n" +
                "         </table>\n" +
                "        </div>\n");
        req.getRequestDispatcher("managernavbar.html").include(req,resp);
        pr.close();

    }
}
