package taxi.service.controller.car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.service.lib.Injector;
import taxi.service.model.Car;
import taxi.service.model.Driver;
import taxi.service.service.CarService;
import taxi.service.service.DriverService;

public class AddDriverToCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi.service");
    private final CarService carService = (CarService) injector
            .getInstance(CarService.class);
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/cars/drivers/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        long driverId = Long.parseLong(req.getParameter("driver_id"));
        long carId = Long.parseLong(req.getParameter("car_id"));
        Driver driver = driverService.get(driverId);
        Car car = carService.get(carId);
        carService.addDriverToCar(driver, car);
        resp.sendRedirect("/cars/drivers/add");
    }
}
