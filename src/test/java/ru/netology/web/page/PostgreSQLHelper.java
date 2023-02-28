package ru.netology.web.page;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private PostgreSQLHelper() {

    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresdb://localhost:5432/app", "app", "pass"
        );
    }
}
