package com.healthshop.healthshop.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteSQLFile {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:h2:tcp://localhost/~/health-shop"; // 파일 모드
        // String jdbcUrl = "jdbc:h2:mem:testdb"; // 메모리 모드
        String username = "sa";
        String password = "";
        String filePath = "src/main/resources/dummy_data.sql";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder sql = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sql.append(line);
                if (line.endsWith(";")) {
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(sql.toString());
                        sql.setLength(0);  // Clear the StringBuilder for the next statement
                    }
                }
            }
            System.out.println("SQL file executed successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
