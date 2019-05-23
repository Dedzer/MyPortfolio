package project.projectController;

import org.hibernate.SessionFactory;
import project.HibernateConfig;
import project.HibernateJavaConfig;
import project.dao.StudiesDao;
import project.dao.impl.StudiesDaoImpl;
import project.model.Studies;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudiesServlet", value = "/aboutme")
public class StudiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("hello world");
        HibernateConfig hibernateConfig = new HibernateJavaConfig();
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        StudiesDao studiesDao = new StudiesDaoImpl(sessionFactory);
        List<Studies> studiesList = studiesDao.findAll();
        for (Studies studies : studiesList){
            out.println(studies);
        }
        request.setAttribute("studies", studiesList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/aboutme.jsp");
        dispatcher.forward(request, response);
    }
}
