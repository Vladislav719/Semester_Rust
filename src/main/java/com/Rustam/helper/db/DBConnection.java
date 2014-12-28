package com.Rustam.helper.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Владислав on 27.12.2014.
 */
public class DBConnection {
    public volatile static Connection connection = null;

    static final String JDBC_DRIVER="org.h2.Driver";
    static final String DB_URL = "jdbc:h2:file:C:/Users/Владислав/IdeaProjects/Rustam/work";
    static final String USER = "";
    static final String PASS = "";

    private DBConnection() {

    }

    public static Connection getConnection() {
        if ( connection == null) {
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                        Class.forName(JDBC_DRIVER);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

}
