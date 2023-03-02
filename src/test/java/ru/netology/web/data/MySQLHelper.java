package ru.netology.web.data;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHelper {

        private static QueryRunner runner = new QueryRunner();

        private MySQLHelper() {

        }

        public static Connection connect() throws SQLException {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/app", "app", "pass"
            );
        }
}
