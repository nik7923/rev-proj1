package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class managerviewallpendingservlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        manageractions action = new manageractions();
        List<reimbursement> currentstatus = action.viewstatus();
        pr.print("<head>\n" +
                "    <style>\n" +
                "        tr:nth-child(even) {background: rgb(245, 192, 236)}\n" +
                "        tr:nth-child(odd) {background: white}\n" +
                "        #table2 {\n" +
                "            border-collapse:collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        #table {\n" +
                "            margin-top:20px;\n" +
                "            margin-left:auto;\n" +
                "            margin-right:auto;\n" +
                "            overflow-y: auto;\n" +
                "            width: 65%;\n" +
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
                "        .sub {\n" +
                "            text-transform:uppercase;\n" +
                "            height:40px;\n" +
                "            background-color: rgb(202, 220, 235);\n" +
                "            border: 2px solid blue;\n" +
                "            border-radius:14px;\n" +
                "            color:black;\n" +
                "            font-size:20px;\n" +
                "            width:115x;\n" +
                "            font-weight:450;\n" +
                "            font-family:cursive;\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <form action='managerapordservlet' method='post'>\n" +
                "        <div id=\"table\">\n" +
                "        <table id=\"table2\" border=\"1\">\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <th>Select</th>\n" +
                "                <th>Date</th>\n" +
                "                <th>Username</th>\n" +
                "                <th>Name</th>\n" +
                "                <th>Amount</th>\n" +
                "                <th>Status</th>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody id=\"body\">"
        );
        for (reimbursement each:currentstatus) {
            pr.print("        <tr>\n" +
                    "            <td><input type='checkbox' name='ids' value='"+each.getId()+"'/></td>\n" +
                    "            <td>"+each.getDate()+"</td>\n" +
                    "            <td>"+each.getUsername()+"</td>\n" +
                    "            <td>"+each.getName()+"</td>\n" +
                    "            <td>"+each.getAmount()+"</td>\n" +
                    "            <td>"+each.getStatus()+"</td>\n" +
                    "        </tr>");
        }
        pr.print("</tbody>\n" +
                "         </table>\n" +
                "        </div>\n" +
                "         <input class=\"sub\" style=\"position:relative; margin-top:20px; left:610px;\" type='submit' name='request' value='Approve'>\n" +
                "         <input class=\"sub\" style=\"position:relative; margin-top:20px; left:700px;\" type='submit' name='request' value='Deny'>\n" +
                "        </form>");

        req.getRequestDispatcher("managernavbar.html").include(req,resp);
        pr.close();
    }
}
