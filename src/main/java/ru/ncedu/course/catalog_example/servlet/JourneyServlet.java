package ru.ncedu.course.catalog_example.servlet;

import ru.ncedu.course.catalog_example.model.dto.OfferingDTO;
import ru.ncedu.course.catalog_example.service.AuthorizationBean;
import ru.ncedu.course.catalog_example.service.CommentService;
import ru.ncedu.course.catalog_example.service.JourneyBean;
import ru.ncedu.course.catalog_example.service.OfferingService;
import ru.ncedu.course.catalog_example.util.PathConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathConstants.JOURNEY_PATH)
public class JourneyServlet extends HttpServlet {

    private static final String JOURNEY_JSP = "/journey.jsp";

    private static final String JOURNEY_LIST = "journey_list";

    private static final String CLEAR_ATTR = "clear";


    @Inject
    private JourneyBean journeyBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().setAttribute(JOURNEY_LIST, journeyBean.getPages());
        getServletContext().getRequestDispatcher(JOURNEY_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        journeyBean.clearPages();
        doGet(req, resp);
    }

}
