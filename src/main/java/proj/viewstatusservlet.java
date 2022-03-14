package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class viewstatusservlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("user");
        employeeaction action = new employeeaction();
        List<reimbursement> currentstatus = action.viewstatus(username);
        req.getRequestDispatcher("navbar.html").include(req,resp);
        pr.print("    <style>\n" +
                "        tr:nth-child(even) {background: rgb(245, 192, 236)}\n" +
                "        tr:nth-child(odd) {background: white}\n" +
                "        #table2 {\n" +
                "            border-collapse:collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        #table {\n" +
                "            margin-top:10px;\n" +
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
                "    </style>");
        pr.print("<div id=\"table\">\n" +
                "        <table id=\"table2\" border=\"1\">\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <th>Name</th>\n" +
                "                <th>Date</th>\n" +
                "                <th>Amount</th>\n" +
                "                <th>Status</th>\n" +
                "            </tr>\n" +
                "            </thead>\n"
        );
        for (reimbursement each:currentstatus) {
            pr.print("        <tr>\n" +
                    "            <td>"+each.getName()+"</td>\n" +
                    "            <td>"+each.getDate()+"</td>\n" +
                    "            <td>"+each.getAmount()+"</td>\n" +
                    "            <td>"+each.getStatus()+"</td>\n" +
                    "        </tr>");
        }
        pr.print("</table></div>");
        pr.close();

    }
}
