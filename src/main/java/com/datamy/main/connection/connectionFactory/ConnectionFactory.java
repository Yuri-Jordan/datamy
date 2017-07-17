package com.datamy.main.connection.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    protected static final String JDBC_DRIVER = "org.postgresql.Driver";
    protected static final String URL = "jdbc:postgresql://localhost:5432/datamy";
    protected static final String USER = "postgres";
    protected static final String PASS = "123";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public ConnectionFactory() {
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    ConnectionFactory.URL,
                    ConnectionFactory.USER,
                    ConnectionFactory.PASS
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
