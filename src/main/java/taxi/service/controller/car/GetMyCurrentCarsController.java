package taxi.service.controller.car;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import taxi.service.lib.Injector;
import taxi.service.model.Car;
import taxi.service.service.CarService;

@WebServlet(urlPatterns = "/cars/my")
public class GetMyCurrentCarsController extends HttpServlet {
    private static final String DRIVER_ID = "driver_id";
    private static final Injector injector = Injector.getInstance("taxi.service");
    private static final CarService carService =
            (CarService) injector.getInstance(CarService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Car> driversCars = carService.getAllByDriver(
                (Long) session.getAttribute(DRIVER_ID));
        req.setAttribute("cars", driversCars);
        req.getRequestDispatcher("/WEB-INF/views/cars/all.jsp").forward(req, resp);
    }
}
