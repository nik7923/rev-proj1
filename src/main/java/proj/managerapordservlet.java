package proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class managerapordservlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        manageractions action = new manageractions();
        int[] userids = Arrays.stream(req.getParameterValues("ids")).mapToInt(Integer::parseInt).toArray();
        String button = req.getParameter("request");
        if (button.equals("Approve")) {
            action.approveselected(userids);

        }
        else if (button.equals("Deny")) {
            action.denyselected(userids);
        }
        resp.sendRedirect("managerviewallpendingservlet");
        pr.close();
    }
}
