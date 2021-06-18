package taxi.service.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static final String DB_URL = "jdbc:mysql://@localhost:3306/library_db"
            + "?useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "19cience19";
    public static final String MYSQL_DRIVER_URL = "com.mysql.cj.jdbc.Driver";
//    public static final String DB_URL = "YOUR DATABASE URL";
//    public static final String USERNAME = "YOUR USERNAME";
//    public static final String PASSWORD = "YOUR PASSWORD";
//    public static final String MYSQL_DRIVER_URL = "YOUR DRIVER";

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
