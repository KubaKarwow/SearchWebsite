package pjatk.tpo.demo;

import java.io.*;
import java.sql.*;

public class GamerRepository
{
    private Connection connection;
    public GamerRepository(Connection connection) {
        this.connection=connection;
    }

    public void initializeDB() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("Drop table Gamer");
        statement.executeUpdate("Create Table Gamer(ID INT PRIMARY KEY," +
                " NAME VARCHAR(20),SURNAME VARCHAR(30),NICK VARCHAR(20), AGE INT" +
                ",CURRENTTEAM VARCHAR(30),REGION VARCHAR(20),REGIONALWINS INT, INTERNATIONALWINS INT, PHOTO BLOB)");

    }
    public void addRecord(int id, String name, String surname, String nick,int age, String currentTeam, String region,
                          int regionalTrophies, int internationalTrophies, File imageFile) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:derby:Gamers;create=true");
        String sql = "INSERT INTO GAMER VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, surname);
        statement.setString(4, nick);
        statement.setInt(5, age);
        statement.setString(6, currentTeam);
        statement.setString(7, region);
        statement.setInt(8, regionalTrophies);
        statement.setInt(9, internationalTrophies);
        InputStream inputStream = new FileInputStream(imageFile);
            statement.setBlob(10, inputStream);

        statement.executeUpdate();
    }
}
