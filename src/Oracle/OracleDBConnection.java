package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;


public class OracleDBConnection {

    final public static String driverName = "oracle.jdbc.driver.OracleDriver";
    public static String HOST = "jdbc:oracle:thin:@localhost:1521:XE"; // Порт, ssid
    final public static String USERNAME = "Stark";
    final public static String PASSWORD = "1";
    public static Connection isConnected;

    public static Connection getDBConnection() {
        Locale.setDefault(Locale.ENGLISH);
        HOST = "jdbc:oracle:thin:@localhost:1521:XE"; // Порт, ssid
        System.out.println(HOST);
        try {
            Class.forName(driverName); // Определение драйвера jdbc
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Драйвер не найден");
        }
        try {
            Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD); // JDBC Manager который открывает соединение с базой данных
            isConnected = connection;
            System.out.println("connecting: " + HOST);
            System.out.println("Connection closed ? " + connection.isClosed());
            System.out.println("Connected");

            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Подключение не удалось");
        }
        return isConnected;
    }

    public static Connection getIsConnected() {
        return isConnected;
    }
}
