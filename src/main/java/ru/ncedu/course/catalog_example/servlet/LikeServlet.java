package ru.ncedu.course.catalog_example.servlet;

import ru.ncedu.course.catalog_example.model.dto.OfferingDTO;
import ru.ncedu.course.catalog_example.service.AuthorizationBean;
import ru.ncedu.course.catalog_example.service.CommentService;
import ru.ncedu.course.catalog_example.service.OfferingService;
import ru.ncedu.course.catalog_example.service.UserService;
import ru.ncedu.course.catalog_example.util.PathConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathConstants.LIKE_PATH)
public class LikeServlet extends HttpServlet {

    private static final String OFFERING_ID_PARAM = "id";
    private static final String CATALOG_JSP = "/catalog.jsp";

    @Inject
    private AuthorizationBean authorizationBean;

    @Inject
    private OfferingService offeringService;

    @Inject
    private CommentService commentService;

    @Inject
    private UserService userService;
/*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long offeringId = Long.parseLong(req.getParameter(OFFERING_ID_PARAM));

            OfferingDTO offeringDTO = offeringService.findByIdOrThrow(offeringId);

            getServletContext().setAttribute(OFFERING_ATTR, offeringDTO);
            getServletContext().setAttribute(COMMENTS_ATTR, commentService.findAllByOffering(offeringId));
            getServletContext().setAttribute(AUTHORIZED_ATTR, authorizationBean.isAuthorized());
            getServletContext().getRequestDispatcher(OFFERING_JSP).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long offeringId = Long.parseLong(req.getParameter(OFFERING_ID_PARAM));
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher(CATALOG_JSP).forward(req, resp);
    }

}
