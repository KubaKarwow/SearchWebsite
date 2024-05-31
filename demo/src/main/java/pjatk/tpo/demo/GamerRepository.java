package pjatk.tpo.demo;

import java.io.*;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;

public class GamerRepository {
    private Connection connection;

    public GamerRepository(Connection connection) throws SQLException {
        this.connection = connection;
        Statement statement = connection.createStatement();


    }

    public void initializeDB() throws SQLException, IOException {
        System.out.println("WCHODZIMY W INITIALIZE");
        Statement statement = connection.createStatement();
        if(!doesTableExist(connection,"TEAM")){
            statement.executeUpdate("CREATE TABLE TEAM(" +
                    "ID INT PRIMARY KEY, " +
                    "NAME VARCHAR(20), " +
                    "CREATED DATE, " +
                    "REGION VARCHAR(20))");
            addRecordsToTeam();
            System.out.println("WE ADDED TEAM");
        }
      //  if (!doesTableExist(connection, "GAMER")) {
        statement.executeUpdate("DROP TABLE ISIN");
        statement.executeUpdate("DROP TABLE GAMER");
        System.out.println("DROPPED GAMER");
            statement.executeUpdate("Create Table GAMER( " +
                    "ID INT PRIMARY KEY," +
                    " NAME VARCHAR(20), " +
                    "SURNAME VARCHAR(30), " +
                    "NICK VARCHAR(20)," +
                    "AGE INT, " +
                    "REGIONALWINS INT, " +
                    "INTERNATIONALWINS INT, " +
                    "PHOTOPATH VARCHAR(150))");
        System.out.println("CREATED GAMER");

            addRecordsToGamer();
            System.out.println("ADDED GAMER");
      //  }
//        if(!doesTableExist(connection,"ISIN")){
            statement.executeUpdate("CREATE TABLE ISIN(ID INT PRIMARY KEY, " +
                    "PLAYERID INT, " +
                    "TEAMID INT, " +
                    "JOINED DATE, " +
                    "\"LEFT\" DATE, " +
                    "FOREIGN KEY (PLAYERID) REFERENCES GAMER(ID)," +
                    "FOREIGN KEY (TEAMID) REFERENCES TEAM(ID))");
            addRecordsToISIN();
            System.out.println("WE ADDED ISIN");
        }


    private void addRecordToISINTable(int id, int playerID, int teamID, LocalDate joined, LocalDate left) throws SQLException {
        String sql = "INSERT INTO ISIN VALUES(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, playerID);
        statement.setInt(3, teamID);
        statement.setDate(4, Date.valueOf(joined));
        if(left!=null){
            statement.setDate(5, Date.valueOf(left));
        }
        else{
            statement.setDate(5,null);
        }
        statement.executeUpdate();
    }
    private void addRecordsToISIN() throws SQLException {
        addRecordToISINTable(1,1,1,LocalDate.of(2019,12,8),null);
        addRecordToISINTable(2,2,1,LocalDate.of(2020,11,27),null);
        addRecordToISINTable(3,3,1,LocalDate.of(2020,11,27),null);
        addRecordToISINTable(4,4,1,LocalDate.of(2020,11,27),null);
        addRecordToISINTable(5,5,1,LocalDate.of(2020,11,25),null);

        addRecordToISINTable(6,6,2,LocalDate.of(2021,11,21),null);
        addRecordToISINTable(7,7,2,LocalDate.of(2022,12,23),null);
        addRecordToISINTable(8,8,2,LocalDate.of(2018,11,29),null);
        addRecordToISINTable(9,9,2,LocalDate.of(2022,12,21),null);
        addRecordToISINTable(10,10,2,LocalDate.of(2022,11,19),null);

        addRecordToISINTable(11,11,3,LocalDate.of(2023,11,29),null);
        addRecordToISINTable(12,12,3,LocalDate.of(2023,11,29),null);
        addRecordToISINTable(13,13,3,LocalDate.of(2021,11,25),null);
        addRecordToISINTable(14,14,3,LocalDate.of(2022,12,21),null);
        addRecordToISINTable(15,15,3,LocalDate.of(2023,11,29),null);

        addRecordToISINTable(16,16,4,LocalDate.of(2022,11,29),null);
        addRecordToISINTable(17,17,4,LocalDate.of(2021,12,27),null);
        addRecordToISINTable(18,18,4,LocalDate.of(2021,11,27),null);
        addRecordToISINTable(19,19,4,LocalDate.of(2023,6,21),null);
        addRecordToISINTable(20,20,4,LocalDate.of(2023,11,29),null);

        addRecordToISINTable(21,21,5,LocalDate.of(2023,11,29),null);
        addRecordToISINTable(22,22,5,LocalDate.of(2022,12,27),null);
        addRecordToISINTable(23,23,5,LocalDate.of(2023,11,27),null);
        addRecordToISINTable(24,24,5,LocalDate.of(2023,6,16),null);
        addRecordToISINTable(25,25,5,LocalDate.of(2024,3,22),null);

        addRecordToISINTable(26,26,6,LocalDate.of(2023,11,29),null);
        addRecordToISINTable(27,27,6,LocalDate.of(2020,12,27),null);
        addRecordToISINTable(28,28,6,LocalDate.of(2023,11,27),null);
        addRecordToISINTable(29,29,6,LocalDate.of(2023,11,16),null);
        addRecordToISINTable(30,30,6,LocalDate.of(2024,12,22),null);

        addRecordToISINTable(31,31,7,LocalDate.of(2021,12,22),null);
        addRecordToISINTable(32,32,7,LocalDate.of(2023,12,21),null);
        addRecordToISINTable(33,33,7,LocalDate.of(2023,12,25),null);
        addRecordToISINTable(34,34,7,LocalDate.of(2022,12,22),null);
        addRecordToISINTable(35,35,7,LocalDate.of(2022,12,24),null);

        addRecordToISINTable(36,36,9,LocalDate.of(2024,5,24),null);
        addRecordToISINTable(37,37,8,LocalDate.of(2023,11,29),null);
    }

    private void addRecordToTeamTable(int id, String name, LocalDate created, String region) throws SQLException {
        String sql = "INSERT INTO TEAM VALUES(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setDate(3, Date.valueOf(created));
        statement.setString(4, region);
        statement.executeUpdate();
    }

    private void addRecordToGamerTable(int id, String name, String surname, String nick, int age,
                                       int regionalTrophies, int internationalTrophies, String photoPath) throws SQLException, IOException {
        String sql = "INSERT INTO GAMER VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, surname);
        statement.setString(4, nick);
        statement.setInt(5, age);
        statement.setInt(6, regionalTrophies);
        statement.setInt(7, internationalTrophies);
        statement.setString(8, photoPath);
        statement.executeUpdate();
    }

    private boolean doesTableExist(Connection connection, String tableName) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }

    private void addRecordsToTeam() throws SQLException {
        addRecordToTeamTable(1,"T1",LocalDate.of(2019,12,8),"South Korea");
        addRecordToTeamTable(2,"G2",LocalDate.of(2013,11,1),"Europe");
        addRecordToTeamTable(3,"GENG",LocalDate.of(2017,7,12),"South Korea");
        addRecordToTeamTable(4,"FNATIC",LocalDate.of(2004,7,23),"Europe");
        addRecordToTeamTable(5,"Heretics",LocalDate.of(2017,1,25),"Europe");
        addRecordToTeamTable(6,"Mad Lions KOI",LocalDate.of(2017,8,31),"Europe");
        addRecordToTeamTable(7,"BLG",LocalDate.of(2017,12,17),"China");
        addRecordToTeamTable(8,"T1 Academy",LocalDate.of(2019,12,8),"South Korea");
        addRecordToTeamTable(9,"100 na płaskiej",LocalDate.of(2024,5,25),"Europe");

    }
    private void addRecordsToGamer() throws SQLException, IOException {
        addRecordToGamerTable(1, "Lee", "Sang-hyeok", "Faker", 28, 10, 6,
                "Pictures//Faker.png");

        addRecordToGamerTable(2, "Choi ", "Woo-je", "Zeus", 20, 4, 1,
                "https://lol.fandom.com/wiki/Zeus#/media/File:T1_Zeus_2024_Split_1.png");

        addRecordToGamerTable(3, "Mun ", "Hyeon-jun", "Oner", 21, 4, 1,
                "https://lol.fandom.com/wiki/Oner#/media/File:T1_Oner_2024_Split_1.png");

        addRecordToGamerTable(4, "Lee", "Min-hyeong", "Gumayusi", 22,  4, 1,
                "https://lol.fandom.com/wiki/Gumayusi#/media/File:T1_Gumayusi_2024_Split_1.png");

        addRecordToGamerTable(5, "Ryu", "Min-seok", "Keria", 21,  4, 1,
                "https://lol.fandom.com/wiki/Keria#/media/File:T1_Keria_2024_Split_1.png");

        addRecordToGamerTable(6, "Sergen ", "Çelik", "BrokenBlade", 24,  6, 0,
                "https://lol.fandom.com/wiki/BrokenBlade#/media/File:G2_BrokenBlade_2024_Split_1.png");

        addRecordToGamerTable(7, "Martin", "Sundelin", "Yike", 23,  5, 0,
                "https://lol.fandom.com/wiki/Yike#/media/File:G2_Yike_2024_Split_1.png");

        addRecordToGamerTable(8, "Rasmus", "Winther", "Caps", 24, 12, 1,
                "https://lol.fandom.com/wiki/Caps#/media/File:G2_Caps_2024_Split_1.png");

        addRecordToGamerTable(9, "Steven", "Liv", "Hans sama", 24,  5, 0,
               "https://lol.fandom.com/wiki/Hans_Sama#/media/File:G2_Hans_Sama_2024_Split_1.png");

        addRecordToGamerTable(10, "Mihael", "Mehle", "Mikyx", 25,  9, 1,
                "https://lol.fandom.com/wiki/Mikyx#/media/File:G2_Mikyx_2024_Split_1.png");

        addRecordToGamerTable(11, "Kim", "Gi-in", "Kiin", 25,  1, 1,
                "https://lol.fandom.com/wiki/Kiin#/media/File:GEN_Kiin_2024_Split_1.png");

        addRecordToGamerTable(12, "Kim", "Geon-bu", "Canyon", 23,  3, 2,
               "https://lol.fandom.com/wiki/Canyon#/media/File:GEN_Canyon_2024_Split_1.png");

        addRecordToGamerTable(13, "Jeong", "Ji-hoon", "Chovy", 23,  4, 1,
                "https://lol.fandom.com/wiki/Chovy#/media/File:GEN_Chovy_2024_Split_1.png");

        addRecordToGamerTable(14, "Kim", "Su-hwan", "Peyz", 18,  4, 1,
                "https://lol.fandom.com/wiki/Peyz#/media/File:GEN_Peyz_2024_Split_1.png");

        addRecordToGamerTable(15, "Son", "Si-woo", "Lehends", 25,  2, 1,
                "https://lol.fandom.com/wiki/Lehends#/media/File:GEN_Lehends_2024_Split_1.png");

        addRecordToGamerTable(16, "Óscar", "Jiménez", "Oscarinin", 20,  0, 0,
                "https://lol.fandom.com/wiki/Oscarinin#/media/File:FNC_Oscarinin_2024_Split_1.png");

        addRecordToGamerTable(17, "Iván", "Díaz", "Razork", 23,  0, 0,
                "https://lol.fandom.com/wiki/Razork#/media/File:FNC_Razork_2024_Split_1.png");

        addRecordToGamerTable(18, "Marek", "Brázda", "Humanoid", 24,  2, 0,
                "https://lol.fandom.com/wiki/Humanoid#/media/File:FNC_Humanoid_2024_Split_1.png");

        addRecordToGamerTable(19, "Oh", "Hyeon-taek", "Noah", 22,  0, 0,
                "https://lol.fandom.com/wiki/Noah_(Oh_Hyeon-taek)#/media/File:FNC_Noah_2024_Split_1.png");

        addRecordToGamerTable(20, "Yoon", "Se-junk", "Jun", 23,  0, 0,
                "https://lol.fandom.com/wiki/Jun_(Yoon_Se-jun)#/media/File:FNC_Jun_2024_Split_1.png");

        addRecordToGamerTable(21, "Martin", "Hansen", "Wunder", 25,  4, 1,
                "https://lol.fandom.com/wiki/Wunder#/media/File:TH_Wunder_2024_Split_1.png");

        addRecordToGamerTable(22, "Marcin", "Jankowski", "Jankos", 28,  5, 1,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJgWytEsOcuj6HFSDrzDxd4WUHG2zsI7kdvA&s");

        addRecordToGamerTable(23, "Luka", "Perković", "Perkz", 25, 9, 1,
                "https://en.wikipedia.org/wiki/Perkz#/media/File:Perkz_2020.jpg");

        addRecordToGamerTable(24, "Victor", "Tortosa", "Flakked", 23,  1, 0,
                "https://lol.fandom.com/wiki/Flakked#/media/File:TH_Flakked_2024_Split_1.png");

        addRecordToGamerTable(25, "Adrian", "Trybus", "Trymbi", 23,  1, 0,
                "https://lol.fandom.com/wiki/Trymbi#/media/File:FNC_Trymbi_2023_Split_3.png");

        addRecordToGamerTable(26, "Alex", "Villarejo", "Myrwn", 20,  0, 0,
                "https://lol.fandom.com/wiki/Myrwn#/media/File:MDK_Myrwn_2024_Split_1.png");

        addRecordToGamerTable(27, "Javier", "Batalla", "Elyoya", 24,  3, 0,
                "https://lol.fandom.com/wiki/Elyoya#/media/File:MDK_Elyoya_2024_Split_1.png");

        addRecordToGamerTable(28, "Bartłomiej", "Przewoźnik", "Fresskowy", 24,  0, 0,
                "https://lol.fandom.com/wiki/Fresskowy#/media/File:MDK_Fresskowy_2024_Split_1.png");

        addRecordToGamerTable(29, "David", "García", "Supa", 23,  0, 0,
                "https://lol.fandom.com/wiki/Supa#/media/File:MDK_Supa_2024_Split_1.png");

        addRecordToGamerTable(30, "Álvaro", "del Amo", "Alvaro", 20,  0, 0,
                "https://lol.fandom.com/wiki/Alvaro_(%C3%81lvaro_Fern%C3%A1ndez)#/media/File:MDK_Alvaro_2024_Split_1.png");

        addRecordToGamerTable(31, "Chen", "Ze-Bin", "Bin", 20,  2, 1,
                "https://lol.fandom.com/wiki/Bin_(Chen_Ze-Bin)#/media/File:BLG_Bin_2024_Split_1.png");

        addRecordToGamerTable(32, "Peng", "Li-Xun", "Xun", 22,  1, 0,
                "https://lol.fandom.com/wiki/Xun#/media/File:BLG_Xun_2024_Split_1.png");

        addRecordToGamerTable(33, "Zhuo", "Ding", "Knight", 24,  4, 1,
                "https://lol.fandom.com/wiki/Knight_(Zhuo_Ding)#/media/File:BLG_knight_2024_Split_1.png");

        addRecordToGamerTable(34, "Zhao", "Jia-Hao", "Elk", 22,  1, 0,
                "https://lol.fandom.com/wiki/Elk#/media/File:BLG_Elk_2024_Split_1.png");

        addRecordToGamerTable(35, "Luo", "Wen-Jun", "ON", 21,  1, 0,
                "https://lol.fandom.com/wiki/ON#/media/File:BLG_ON_2024_Split_1.png");

        addRecordToGamerTable(36, "Jakub", "Karwowski", "Krol Ringu", 20,  0, 0,
               "https://www.facebook.com/photo.php?fbid=633722440758452&set=pb.100023621046506.-2207520000&type=3");

        addRecordToGamerTable(37, "Martin", "Larsson", "Rekkles", 27,  4, 0,
                "https://lol.fandom.com/wiki/Rekkles#/media/File:T1.EA_Rekkles_2024_Split_1.png");
    }
}
