import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class CircleArea extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private double area;

    public CircleArea() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        area = Math.pow(Double.parseDouble(request.getParameter("radius")), 2) * Math.PI;
        out.println("<html><body>" +
            "Area = " + area + 
            "</html></body>");
    }

}