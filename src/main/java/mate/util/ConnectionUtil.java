package mate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static final String DB_URL = "url";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1111";
    public static final String MYSQL_DRIVER_URL = "driverUrl";

    static {
        try {
            Class.forName(MYSQL_DRIVER_URL);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(DB_URL, dbProperties);
    }
}
