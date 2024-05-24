package pjatk.tpo.demo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Base64;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private GamerRepository gamerRepository;
    private Connection connection;
    public void init() {
        try {
            connection= DriverManager.getConnection("jdbc:derby:Gamers;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        gamerRepository = new GamerRepository(connection);
        try {
            gamerRepository.initializeDB();

            gamerRepository.addRecord(1,"Lee","Sang-hyeok","Faker",28,"T1","South Korea",10,6,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(2,"Choi ","Woo-je","Zeus",20,"T1","South Korea",4,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(3,"Mun ","Hyeon-jun","Oner",21,"T1","South Korea",4,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(4,"Lee","Min-hyeong","Gumayusi",22,"T1","South Korea",4,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(5,"Ryu","Min-seok","Keria",21,"T1","South Korea",4,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(6,"Sergen ","Çelik","BrokenBlade",24,"G2","Europe",6,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(7,"Martin","Sundelin","Yike",23,"G2","Europe",5,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(8,"Rasmus","Winther","Caps",24,"G2","Europe",12,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(9,"Steven","Liv","Hans sama",24,"G2","Europe",5,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(10,"Mihael","Mehle","Mikyx",25,"G2","Europe",9,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(11,"Kim","Gi-in","Kiin",25,"GENG","South Korea",1,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(12,"Kim","Geon-bu","Canyon",23,"GENG","South Korea",3,2,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(13,"Jeong","Ji-hoon","Chovy",23,"GENG","South Korea",4,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(14,"Kim","Su-hwan","Peyz",18,"GENG","South Korea",4,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(15,"Son","Si-woo","Peyz",25,"GENG","South Korea",2,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(16,"Óscar","Jiménez","Oscarinin",20,"Fnatic","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(17,"Iván","Díaz","Razork",23,"Fnatic","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(18,"Marek","Brázda","Humanoid",24,"Fnatic","Europe",2,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(19,"Oh","Hyeon-taek","Noah",22,"Fnatic","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(20,"Yoon","Se-junk","Jun",23,"Fnatic","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(21,"Martin","Hansen","Wunder",25,"Heretics","Europe",4,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(22,"Marcin","Jankowski","Jankos",28,"Heretics","Europe",5,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(23,"Luka","Perković","Perkz",25,"Heretics","Europe",9,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(24,"Victor","Tortosa","Flakked",23,"Heretics","Europe",1,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(25,"Adrian","Trybus","Trymbi",23,"Heretics","Europe",1,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(26,"Alex","Villarejo","Myrwn",20,"MAD Lions KOI","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(27,"Javier","Batalla","Elyoya",24,"MAD Lions KOI","Europe",3,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(28,"Bartłomiej","Przewoźnik","Fresskowy",24,"MAD Lions KOI","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(29,"David","García","Supa",23,"MAD Lions KOI","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(30,"Álvaro","del Amo","Alvaro",20,"MAD Lions KOI","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(31,"Chen","Ze-Bin","Bin",20,"BLG","China",2,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(32,"Peng","Li-Xun","Xun",22,"BLG","China",1,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(33,"Zhuo","Ding","Knight",24,"BLG","China",4,1,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(34,"Zhao","Jia-Hao","Elk",22,"BLG","China",1,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(35,"Luo","Wen-Jun","ON",21,"BLG","China",1,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(36,"Jakub","Karwowski","Krol Ringu",20,"100kg bench press","Europe",0,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));

            gamerRepository.addRecord(37,"Martin","Larsson","Rekkles",27,"T1 Academy","South Korea",4,0,
                    new File(String.valueOf(Paths.get("C:\\Users\\Jakub\\Desktop\\Studia\\4 semestr\\TPO\\TPO6\\demo\\src\\main\\resources\\PlayerImages\\Faker.png"))));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //init();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM GAMER");
            while (resultSet.next()) {
                sendFormattedResponse(out,resultSet);
            }
            out.println("<html></body>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void sendFormattedResponse(PrintWriter out, ResultSet resultSet) throws SQLException, IOException {
        StringBuilder sbd = new StringBuilder();
        for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
            out.println("<h3>" +getProperResponse(i)+":"+ resultSet.getString(i) + "</h3>");
        }
        sbd = new StringBuilder();
        Blob photo = resultSet.getBlob("PHOTO");
        if(photo!=null){
            byte[] photoBytes = blobToBytes(photo);
            String base64Image = Base64.getEncoder().encodeToString(photoBytes);
            sbd.append("<img src='data:image/jpeg;base64,").append(base64Image).append("' />");
        }
        out.println("<h3>" + sbd.toString() + "</h3>");

    }
    private String getProperResponse(int columnIndex){
        switch (columnIndex){
            case 1 -> {
                return "ID";
            }
            case 2 -> {
                return "Name";
            }
            case 3 -> {
                return "Surname";
            }
            case 4 -> {
                return "Nick";
            }
            case 5 -> {
                return "Age";
            }
            case 6 -> {
                return "Current team";
            }
            case 7 -> {
                return "Region";
            }
            case 8 -> {
                return "Amount of Regional Trophies";
            }
            case 9 -> {
                return "Amount of International Trophies";
            }
            default -> {
                return "Never happening";
            }
        }
    }
    private byte[] blobToBytes(Blob blob) throws SQLException, IOException {
        try (InputStream is = blob.getBinaryStream();
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            return os.toByteArray();
        }
    }
    public void destroy() {}
}