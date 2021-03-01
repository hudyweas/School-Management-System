package pl.hudyweas.schoolmanagementsystem.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class DBConnectionSystem {
    private final static String DBURL = "jdbc:mysql://localhost:3306/school_management_system";
    private final static String DBUSER = "root";
    private final static String DBPASS = "";
    private final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection conn;

    public DBConnectionSystem() {
        try {
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateData(String query){
        try{
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(query);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public ResultSet getResultSet(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return rs;
    }

    public ArrayList<String> getResultAsArrayList(String query, String... resultSetKeyWords) {
        ArrayList<String> row = new ArrayList<>();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = null;

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }

            while (rs.next()) {
                row.add(resultSetRowToString(rs, resultSetKeyWords));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

    private String resultSetRowToString(ResultSet rs, String... resultSetKeyWords) throws SQLException {
        StringBuilder output = new StringBuilder();
        int rsKeyWordsLength = resultSetKeyWords.length;

        if (rsKeyWordsLength == 1)
            output = new StringBuilder(rs.getString(resultSetKeyWords[0]));
        else {
            for (String keyWord : resultSetKeyWords) {
                output.append(rs.getString(keyWord)).append(";");
            }
            output = new StringBuilder(deleteLastCharFromString(output.toString()));
        }
        return output.toString();
    }

    private String deleteLastCharFromString(String string) {
        return string.substring(0, string.length() - 1);
    }

}
