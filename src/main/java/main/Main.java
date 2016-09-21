package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.Frontend;
import servlets.MirrorServlet;


/**
 * Created by Anton on 19.09.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Frontend frontend = new Frontend();
        MirrorServlet mirrorServlet = new MirrorServlet();


        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.addServlet(new ServletHolder(frontend), "/authform");
        context.addServlet(new ServletHolder(mirrorServlet), "/*");
        server.setHandler(context);


        server.start();
        System.out.println("Server started");
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();


    }
}
