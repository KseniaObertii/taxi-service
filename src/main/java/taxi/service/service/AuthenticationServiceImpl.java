package taxi.service.service;

import java.util.Optional;
import taxi.service.lib.Injector;
import taxi.service.lib.Service;
import taxi.service.lib.exception.AuthenticationException;
import taxi.service.model.Driver;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Injector injector = Injector.getInstance("taxi/service");
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> driver = driverService.findByLogin(login);
        if (driver.isPresent() && password.equals(driver.get().getPassword())) {
            return driver.get();
        }
        throw new AuthenticationException("Invalid login or password");
    }
}
