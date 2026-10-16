package servlets;

import resources.Point;
import resources.Submission;
import tools.Checker;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;

@WebServlet("/check")
public class AreaCheckServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        long start = System.nanoTime();
        Point point = new Point(Float.parseFloat(request.getParameter("x")),
                Float.parseFloat(request.getParameter("y")),
                Float.parseFloat(request.getParameter("r")));
        ServletContext context = getServletContext();
        ArrayDeque<Submission> results = (ArrayDeque<Submission>) context.getAttribute("results");
        Submission result = Checker.check(point, start);
        results.addFirst(result);
        if (results.size() > 10){
            results.removeLast();
        }
        context.setAttribute("last", result);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Результат</h1>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>id</th>");
        out.println("<th>x</th>");
        out.println("<th>y</th>");
        out.println("<th>r</th>");
        out.println("<th>script time</th>");
        out.println("<th>result</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td>" + result.getId() + "</td>");
        out.println("<td>" + result.getPoint().getX() + "</td>");
        out.println("<td>" + result.getPoint().getY() + "</td>");
        out.println("<td>" + result.getPoint().getR() + "</td>");
        out.println("<td>" + result.getScriptTime() + "</td>");
        out.println("<td>" + result.getResult() + "</td>");
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("<a href='controller'> -> </a>");
        out.println("</body>");
        out.println("</html>");
    }
}
