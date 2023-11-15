package com.sesac.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sesac.project.mvc.fx.ResourcesReader;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DBConnector {

    private static final Properties properties = ResourcesReader.read("db.properties");

    public static void drive() {
        try {
            Class.forName("net.sf.log4jdbc.DriverSpy");
        } catch (ClassNotFoundException e) {
            log.info(e.getMessage());
        }
    }

    public static Connection connect() throws SQLException {
        String host = (String) properties.get("host");
        String port = (String) properties.get("port");
        String database = (String) properties.get("database");
        String user = (String) properties.get("user");
        String password = (String) properties.get("password");
        String url = String.format("jdbc:log4jdbc:oracle:thin:@%s:%s/%s", host, port, database);
        return DriverManager.getConnection(url, user, password);
    }
}
