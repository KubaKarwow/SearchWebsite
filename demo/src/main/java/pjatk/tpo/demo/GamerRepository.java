package pjatk.tpo.demo;

import java.io.*;
import java.nio.file.Paths;
import java.sql.*;

public class GamerRepository {
    private Connection connection;

    public GamerRepository(Connection connection) {
        this.connection = connection;
    }

    public void initializeDB() throws SQLException, IOException {
        Statement statement = connection.createStatement();
        if(!doesTableExist(connection,"Team")){
            statement.executeUpdate("CREATE TABLE TEAM(ID INT PRIMARY KEY, NAME VARCHAR(20),CREATED DATE, ,)")
        }
        if (!doesTableExist(connection, "Gamer")) {
            statement.executeUpdate("Create Table Gamer(ID INT PRIMARY KEY," +
                    " NAME VARCHAR(20),SURNAME VARCHAR(30),NICK VARCHAR(20), AGE INT" +
                    ",CURRENTTEAM VARCHAR(30),REGION VARCHAR(20),REGIONALWINS INT, INTERNATIONALWINS INT, PHOTO BLOB)");
            addRecords();
        }
    }

    private void addRecord(int id, String name, String surname, String nick, int age, String currentTeam, String region,
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

    private boolean doesTableExist(Connection connection, String tableName) throws SQLException {
        ResultSet tables = connection.getMetaData().getTables(null, null, tableName, null);
        return tables.getFetchSize() == 1;
    }

    private void addRecords() throws SQLException, IOException {
        addRecord(1, "Lee", "Sang-hyeok", "Faker", 28, "T1", "South Korea", 10, 6,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(2, "Choi ", "Woo-je", "Zeus", 20, "T1", "South Korea", 4, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(3, "Mun ", "Hyeon-jun", "Oner", 21, "T1", "South Korea", 4, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(4, "Lee", "Min-hyeong", "Gumayusi", 22, "T1", "South Korea", 4, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(5, "Ryu", "Min-seok", "Keria", 21, "T1", "South Korea", 4, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(6, "Sergen ", "Çelik", "BrokenBlade", 24, "G2", "Europe", 6, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(7, "Martin", "Sundelin", "Yike", 23, "G2", "Europe", 5, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(8, "Rasmus", "Winther", "Caps", 24, "G2", "Europe", 12, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(9, "Steven", "Liv", "Hans sama", 24, "G2", "Europe", 5, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(10, "Mihael", "Mehle", "Mikyx", 25, "G2", "Europe", 9, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(11, "Kim", "Gi-in", "Kiin", 25, "GENG", "South Korea", 1, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(12, "Kim", "Geon-bu", "Canyon", 23, "GENG", "South Korea", 3, 2,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(13, "Jeong", "Ji-hoon", "Chovy", 23, "GENG", "South Korea", 4, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(14, "Kim", "Su-hwan", "Peyz", 18, "GENG", "South Korea", 4, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(15, "Son", "Si-woo", "Peyz", 25, "GENG", "South Korea", 2, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(16, "Óscar", "Jiménez", "Oscarinin", 20, "Fnatic", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(17, "Iván", "Díaz", "Razork", 23, "Fnatic", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(18, "Marek", "Brázda", "Humanoid", 24, "Fnatic", "Europe", 2, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(19, "Oh", "Hyeon-taek", "Noah", 22, "Fnatic", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(20, "Yoon", "Se-junk", "Jun", 23, "Fnatic", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(21, "Martin", "Hansen", "Wunder", 25, "Heretics", "Europe", 4, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(22, "Marcin", "Jankowski", "Jankos", 28, "Heretics", "Europe", 5, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(23, "Luka", "Perković", "Perkz", 25, "Heretics", "Europe", 9, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(24, "Victor", "Tortosa", "Flakked", 23, "Heretics", "Europe", 1, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(25, "Adrian", "Trybus", "Trymbi", 23, "Heretics", "Europe", 1, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(26, "Alex", "Villarejo", "Myrwn", 20, "MAD Lions KOI", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(27, "Javier", "Batalla", "Elyoya", 24, "MAD Lions KOI", "Europe", 3, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(28, "Bartłomiej", "Przewoźnik", "Fresskowy", 24, "MAD Lions KOI", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(29, "David", "García", "Supa", 23, "MAD Lions KOI", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(30, "Álvaro", "del Amo", "Alvaro", 20, "MAD Lions KOI", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(31, "Chen", "Ze-Bin", "Bin", 20, "BLG", "China", 2, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(32, "Peng", "Li-Xun", "Xun", 22, "BLG", "China", 1, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(33, "Zhuo", "Ding", "Knight", 24, "BLG", "China", 4, 1,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(34, "Zhao", "Jia-Hao", "Elk", 22, "BLG", "China", 1, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(35, "Luo", "Wen-Jun", "ON", 21, "BLG", "China", 1, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(36, "Jakub", "Karwowski", "Krol Ringu", 20, "100kg bench press", "Europe", 0, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

        addRecord(37, "Martin", "Larsson", "Rekkles", 27, "T1 Academy", "South Korea", 4, 0,
                new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));
    }
}
