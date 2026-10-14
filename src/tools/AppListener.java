package tools;

import resources.Submission;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayDeque;

@WebListener
public class AppListener implements ServletContextListener{
    private final ArrayDeque<Submission> results = new ArrayDeque<>();
    @Override
    public void contextInitialized(ServletContextEvent event){
        ServletContext context = event.getServletContext();
        context.setAttribute("results", results);
    }
}