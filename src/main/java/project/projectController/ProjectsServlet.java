package project.projectController;


import project.dao.impl.MongoBaseController;
import project.model.ProjectsModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProjectsServlet", value = "/myprojects")
public class ProjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("hello world");
        MongoBaseController dataBaseConnection = new MongoBaseController();
        List<ProjectsModel> projectsModelList = dataBaseConnection.getProjectsList();
        for(ProjectsModel projectsModel : projectsModelList){
            out.println(projectsModel);
        }
        request.setAttribute("projects", projectsModelList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/myprojects.jsp");
        dispatcher.forward(request,response);
    }
}
