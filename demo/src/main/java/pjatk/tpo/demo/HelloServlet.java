package pjatk.tpo.demo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private GamerRepository gamerRepository;
    private Connection connection;
    public void init() {

        message = "Hello World!";
        try {
            connection= DriverManager.getConnection("jdbc:derby:Gamers;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        gamerRepository = new GamerRepository(connection);
        try {
            gamerRepository.initializeDB();
            gamerRepository.addRecord(1,"lee","kutas","faker","t1","korea",10,6,
                    new File(String.valueOf(Paths.get("src//main//resources//PlayerImages//faker.jpg"))));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        init();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        try {
            Statement statement = connection.createStatement();
          //  statement.executeUpdate("DROP TABLE GAMER");
//            statement.executeUpdate("Create Table Gamer(ID INT PRIMARY KEY, NAME VARCHAR(20),NICK VARCHAR(20))");
//
//            statement.executeUpdate("INSERT INTO GAMER VALUES(1,'FAKER','CHINAMAN')");
//            statement.executeUpdate("INSERT INTO GAMER VALUES(2,'GAMER','GAMING')");
//            statement.executeUpdate("INSERT INTO GAMER VALUES(3,'PONGOLO','KROL RINGU')");
//            statement.executeUpdate("INSERT INTO GAMER VALUES(4,'CAPS','WINTHER')");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM GAMER");
            while (resultSet.next()) {
                StringBuilder sbd = new StringBuilder();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    sbd.append(resultSet.getString(i)+" ");
                }
                out.println("<h1>" + sbd.toString() + "</h1>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Hello   // ju
        //first steps above
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM GAMER");
//            System.out.println(resultSet.getFetchSize());
//            while (resultSet.next()) {
//                StringBuilder sbd = new StringBuilder();
//                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
//                    sbd.append(resultSet.getString(i) + " ");
//                }
//                out.println("<h1>" + sbd.toString() + "</h1>");
////            }
//
//                out.println("<h1>" +" XDXDXXDXDXDXXD" + "</h1>");
//                out.println("</body></html>");
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
        public void destroy() {
    }
}