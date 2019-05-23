package project.projectController;

import org.hibernate.SessionFactory;
import project.HibernateConfig;
import project.HibernateJavaConfig;
import project.dao.SkillsDao;
import project.dao.StudiesDao;
import project.dao.impl.SkillsDaoImpl;
import project.dao.impl.StudiesDaoImpl;
import project.model.Skills;
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
public class SkillsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("hello world");
        HibernateConfig hibernateConfig = new HibernateJavaConfig();
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        SkillsDao skillsDao = new SkillsDaoImpl(sessionFactory);
        List<Skills> skillsList = skillsDao.findAll();
        for (Skills skills : skillsList){
            out.println(skills);
        }
        request.setAttribute("skills", skillsList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/aboutme.jsp");
        dispatcher.forward(request, response);
    }
}
