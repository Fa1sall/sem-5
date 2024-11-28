import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display the received data
        out.println("<html><body>");
        out.println("<h2>Received Data:</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("</body></html>");
    }
}
