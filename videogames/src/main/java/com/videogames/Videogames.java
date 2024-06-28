package com.videogames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Videogames {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/videogame";
        String user = "campus2023";
        String password = "campus2023";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}