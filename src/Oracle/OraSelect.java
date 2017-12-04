package Oracle;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

import static Oracle.OracleDBConnection.getDBConnection;

/**
 * Created by Name on 11.02.2017.
 */
public class OraSelect {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        getDBConnection();
        Statement statement = OracleDBConnection.getIsConnected().createStatement();
        ResultSet resultSet = statement.executeQuery(OraStatements.SELECT);
        int row_num = 0;
        while (resultSet.next()) {
            row_num++;
            String Cur_date = resultSet.getString("Cur_date");
            String Total_money = resultSet.getString("Total_money");
            String Spend = resultSet.getString("Spend");
            String Remain_money = resultSet.getString("Remain_money");
            String Commentary = resultSet.getString("Commentary");
            System.out.print(row_num + " ");
            System.out.print(Cur_date = Cur_date.substring(2, 10) + " ");
            System.out.print(Total_money + " ");
            System.out.print(Spend + " ");
            System.out.print(Remain_money + " ");
            System.out.println(Commentary);
        }
        resultSet.close();
    }
}
