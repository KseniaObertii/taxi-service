package taxi.service.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.service.lib.Injector;
import taxi.service.lib.exception.AuthenticationException;
import taxi.service.model.Driver;
import taxi.service.service.AuthenticationService;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final String DRIVER_ID = "driver_id";
    private static final Injector injector = Injector.getInstance("taxi.service");
    private static final AuthenticationService authenticationService = (AuthenticationService)
            injector.getInstance(AuthenticationService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            Driver driver = authenticationService.login(login, password);
            req.getSession().setAttribute(DRIVER_ID, driver.getId());
        } catch (AuthenticationException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
        resp.sendRedirect("/index");
    }
}
