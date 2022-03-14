package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class manreqvieweachservlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        String user = req.getParameter("user");
        List<reimbursement> userrequests = null;
        try {
            manageractions action = new manageractions();
            userrequests = action.vieweach(user);

        } catch (Exception e) {
            pr.print("maybe name doesn't exist");
        }
        pr.print("<style>\n" +
                "        tr:nth-child(even) {background: rgb(245, 192, 236)}\n" +
                "        tr:nth-child(odd) {background: white}\n" +
                "        #table2 {\n" +
                "            border-collapse:collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        #table {\n" +
                "            margin-top:30px;\n" +
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
                "                <th>Name</th>\n" +
                "                <th>Date</th>\n" +
                "                <th>Amount</th>\n" +
                "                <th>Status</th>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody id=\"body\">"
        );
        for (reimbursement each : userrequests) {
            pr.print("        <tr>\n" +
                    "            <td>" + each.getName() + "</td>\n" +
                    "            <td>" + each.getDate() + "</td>\n" +
                    "            <td>" + each.getAmount() + "</td>\n" +
                    "            <td>" + each.getStatus() + "</td>\n" +
                    "        </tr>");
        }
        pr.print("            </tbody>\n" +
                "         </table>\n" +
                "        </div>");
        req.getRequestDispatcher("managernavbar.html").include(req,resp);
        pr.close();

    }
}
