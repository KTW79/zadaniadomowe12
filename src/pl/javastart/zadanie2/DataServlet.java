package pl.javastart.zadanie2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kasia on 06.02.2017.
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = createUserFromRequest(request);
        sendResponse(user, response);
    }
    private User createUserFromRequest(HttpServletRequest request) {
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setAge(request.getParameter("age"));
        user.setUrl(request.getParameter("url"));
        return user;

    }


    private void sendResponse(User user, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.print("<div>");
        if ( user.getFirstName() != null && user.getLastName() != null){
            writer.println("<h3>Przyjęto następujące dane</h3>");
            writer.println(user.getFirstName() + "<br>");
            writer.println(user.getLastName() + "<br>");
            writer.println(user.getAge() + "<br>");
            writer.println(user.getUrl() + "<br>");
            writer.println("<img src=\"http://www.fantastycznie.pl/upload/images/large/2015/03/smieszny_kot_2015-03-15_19-51-18.jpg\">");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
        }else{
            writer.println("<h3>Wprowadzono błędne dane</h3>");
            writer.println("<h4><a href=http://localhost:8081/index1.html>powrót do formularza</a></h4>");

        }
    }


    public DataServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = createUserFromRequest(request);
        sendResponse(user, response);

    }


}
