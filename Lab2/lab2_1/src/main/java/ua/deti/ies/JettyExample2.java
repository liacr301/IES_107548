package ua.deti.ies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyExample2 {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8680);
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
        servletHandler.addServletWithMapping(HelloServlet.class, "/");

        server.start();
        server.join();

    }

    public static class HelloServlet extends HttpServlet
    {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            String msg = request.getParameter("msg");

            if (msg != null && !msg.isEmpty()) {
                response.getWriter().println("<h1>" + msg + "</h1>");
            } else {
                response.getWriter().println("<h1>Hello guysss!</h1>");
            }
        }
    }
}