package Oracle;

/**
 * Created by Name on 12.02.2017.
 */
public class OraStatements {
    public final static String CREATE_COSTS = "CREATE TABLE COSTS\n" +
            "(\n" +
            "   CUR_DATE            DATE NOT NULL,\n" +
            "   TOTAL_MONEY         VARCHAR2 (50 BYTE) NOT NULL,\n" +
            "   SPEND_NECESSARY     VARCHAR2 (50 BYTE) NOT NULL,\n" +
            "   SPEND_UNNECESSARY   VARCHAR2 (50 BYTE) NOT NULL,\n" +
            "   REMAIN_MONEY        VARCHAR2 (50 BYTE) NOT NULL,\n" +
            "   COMMENTARY          VARCHAR2 (500 BYTE) NOT NULL\n" +
            ")";

    public final static String INSERT_COSTS =
            "INSERT INTO Costs (cur_date,\n" +
                    "                   Total_Money,\n" +
                    "                   Spend,\n" +
                    "                   Remain_Money,\n" +
                    "                   Commentary)\n" +
                    "     VALUES (TO_DATE (SYSDATE, 'dd/mm/yyyy hh:mi:ss'),\n" +
                    "             86149,\n" +
                    "             223,\n" +
                    "             85834,\n" +
                    "             'текст')";

    public final static String CREATE_SALARY =
            "  CREATE TABLE Salary\n" +
                    "            (\n" +
                    "                    SALARY_DATE     DATE NOT NULL,\n" +
                    "                    BEFORE_SALARY   VARCHAR2 (50 BYTE) NOT NULL,\n" +
                    "    INCOME          VARCHAR2 (50 BYTE) NOT NULL,\n" +
                    "    CURRENT_MONEY   VARCHAR2 (50 BYTE) NOT NULL\n" +
                    "    )";

    public final static String CREATE_SPEND =
            " CREATE TABLE SPEND\n" +
                    "(\n" +
                    "   LAST_SALARY_DATE   DATE NOT NULL,\n" +
                    "   SPEND_MONEY        VARCHAR2 (50 BYTE) NOT NULL\n" +
                    ")";

    public final static String SELECT = "SELECT *FROM COSTS";
    public final static String DROP_TABLE = "DROP TABLE COSTS";

    /*
    ALTER TABLE COSTS
    ADD NECESSARY_SPEND  VARCHAR2 (50 BYTE) NOT NULL;
     */

    /*
    SELECT S.*,  SP.SPEND_MONEY
FROM SALARY s
JOIN SPEND sp
on S.SALARY_DATE = SP.LAST_SALARY_DATE
where s.SALARY_DATE = to_date('20022017', 'ddmmyyyy')
     */

}
