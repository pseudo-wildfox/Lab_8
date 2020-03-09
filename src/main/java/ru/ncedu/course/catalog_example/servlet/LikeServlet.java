package ru.ncedu.course.catalog_example.servlet;


import ru.ncedu.course.catalog_example.service.*;
import ru.ncedu.course.catalog_example.util.PathConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(PathConstants.LIKE_PATH)
public class LikeServlet extends HttpServlet {

    private static final String OFFERING_ID_PARAM = "id";
    private static final String CATALOG_JSP = "/catalog.jsp";
    private static final String LIKESMAP_ATTR = "map";


    @Inject
    private AuthorizationBean authorizationBean;

    @Inject
    private OfferingService offeringService;

    @Inject
    private LikeService likeService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long offeringId = Long.parseLong(req.getParameter(OFFERING_ID_PARAM));
            likeService.create(offeringId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //getServletContext().getRequestDispatcher(CATALOG_JSP).forward(req, resp);
        resp.sendRedirect(PathConstants.CATALOG_PATH);
    }

}
