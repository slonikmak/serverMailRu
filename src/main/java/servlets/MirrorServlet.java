package servlets;

import templater.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton on 20.09.2016.
 */
public class MirrorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //System.out.println("get");
        Map<String, Object> variables = createPageVariablesMap(request);
        String message = request.getParameter("key");
        System.out.println(message);

        response.setContentType("text/html;charset=utf-8");

        if (message == null || message.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        variables.put("key", message == null ? "" : message);

        response.getWriter().println(PageGenerator.instance().getPage("mirror.html", variables));


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> variables = createPageVariablesMap(request);


        System.out.println("post");
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        pageVariables.put("pathInfo", request.getPathInfo());
        pageVariables.put("sessionId", request.getSession().getId());
        pageVariables.put("parameters", request.getParameterMap().toString());
        return pageVariables;
    }
}
