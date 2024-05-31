package pjatk.tpo.demo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Base64;
import java.util.Map;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private GamerRepository gamerRepository;
    private Connection connection;

    public void init() {
        try {
            connection = DriverManager.getConnection("jdbc:derby:Gamers;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            gamerRepository = new GamerRepository(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            gamerRepository.initializeDB();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Map<String, String[]> parameterMap = request.getParameterMap();
        int ageMin = Integer.parseInt(parameterMap.get("age_min")[0]);
        int ageMax = Integer.parseInt(parameterMap.get("age_max")[0]);
        int regional_trophies_min = Integer.parseInt(parameterMap.get("regional_trophies_min")[0]);
        int regional_trophies_max = Integer.parseInt(parameterMap.get("regional_trophies_max")[0]);
        int international_trophies_min = Integer.parseInt(parameterMap.get("international_trophies_min")[0]);
        int international_trophies_max = Integer.parseInt(parameterMap.get("international_trophies_max")[0]);
        String region = parameterMap.get("region")[0];
        String sortBy = parameterMap.get("sort")[0];

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        try {
            String sql = "SELECT GAMER.NAME, " +
                    "GAMER.SURNAME, " +
                    "GAMER.NICK, " +
                    "GAMER.AGE, " +
                    "TEAM.NAME, " +
                    "ISIN.JOINED, " +
                    "TEAM.REGION, " +
                    "GAMER.REGIONALWINS, " +
                    "GAMER.INTERNATIONALWINS, " +
                    "GAMER.PHOTOPATH " +
                    "FROM GAMER " +
                    "JOIN ISIN ON ISIN.PLAYERID=GAMER.ID " +
                    "JOIN TEAM ON TEAM.ID=ISIN.TEAMID " +
                    "WHERE AGE>=? AND AGE<=? AND " +
                    "REGIONALWINS>=? AND REGIONALWINS<=? AND " +
                    "INTERNATIONALWINS>=? AND INTERNATIONALWINS<=? " +
                    "AND REGION=? " + " ORDER BY " + sortBy;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ageMin);
            statement.setInt(2, ageMax);
            statement.setInt(3, regional_trophies_min);
            statement.setInt(4, regional_trophies_max);
            statement.setInt(5, international_trophies_min);
            statement.setInt(6, international_trophies_max);
            statement.setString(7, region);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet.getFetchSize() + " AMOUNT OF RECORDS");
            while (resultSet.next()) {
                sendFormattedResponse(out, resultSet);
                System.out.println("ANOTHER RESPONSE");
            }
            out.println("<html></body>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendFormattedResponse(PrintWriter out, ResultSet resultSet) throws SQLException, IOException {
        StringBuilder sbd = new StringBuilder();
        for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
            out.println("<h3>" + getProperResponse(i) + ":" + resultSet.getString(i) + "</h3>");
        }
        sbd = new StringBuilder();
        sbd.append("<img src='"+resultSet.getString("PHOTOPATH")+"'/>");
        out.println("<h3>" + sbd.toString() + "</h3>");

    }

    private String getProperResponse(int columnIndex) {
        switch (columnIndex) {
            case 1 -> {
                return "Name";
            }
            case 2 -> {
                return "Surname";
            }
            case 3 -> {
                return "Nick";
            }
            case 4 -> {
                return "Age";
            }
            case 5 -> {
                return "Current team";
            }
            case 6 -> {
                return "Joined";
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
             ByteArrayOutputStream os = new ByteArrayOutputStream()){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            return os.toByteArray();
        }
    }

    public void destroy() {
    }
}