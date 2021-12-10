package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeaders")
public class ServletHeaders extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String metodoHttp = request.getMethod();
        
        out.print("<html>");
        out.print("<head>");
        out.print("<tittle>Header HTTP</tittle>");
        out.print("</header>");
        out.print("<body>");
        out.print("<h1>Headers HTTP</h1>");
        out.print("<br>");
        out.print("Metodo HTTP: "+metodoHttp);
        out.print("<br>");
        
        String uri = request.getRequestURI();
        out.print("URI solicitada: "+uri);
        out.print("<br>");
        
        Enumeration headers = request.getHeaderNames();
        
        while(headers.hasMoreElements()){
            String nombreHeader = (String) headers.nextElement();
            out.print("<b>" + nombreHeader + "</b");
            out.print(request.getHeader(nombreHeader));
            out.print("<br>");
        }
        
        out.print("</body>");
        out.print("</html>");
        out.close();
        
    }
    
}
