package com.osms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {

    private static DBConnection dBConnection;
    private Connection connection;

    private DBConnection() {
        try {
            Properties properties = new Properties();
            File file = new File("D:\\laptop\\users\\eclipse-workspace\\online-staff-management\\src\\main\\java\\com\\osms\\util\\db-properties.properties");
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);

            String ip = properties.getProperty("ip");
            String database = properties.getProperty("database");
            String password = properties.getProperty("password");
            String port = properties.getProperty("port");
            String username = properties.getProperty("username");
            String configs = properties.getProperty("configs");

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database + configs, username, password);


        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBConnection getDBInstance() {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public Connection getConnection() {
        return connection;
    }

}
