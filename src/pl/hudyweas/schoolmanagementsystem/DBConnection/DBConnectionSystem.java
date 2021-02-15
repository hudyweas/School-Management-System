package pl.hudyweas.schoolmanagementsystem.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class DBConnectionSystem {
    private final static String DBURL = "jdbc:mysql://localhost:3306/school_management_system";
    private final static String DBUSER = "root";
    private final static String DBPASS = "";
    private final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection conn;
    private Statement stmt;

    public DBConnectionSystem() {
        try {
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setUpConnectionAndStatement() throws Exception {
        Class.forName(DBDRIVER).getDeclaredConstructor().newInstance();
        this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        this.stmt = conn.createStatement();
    }

    private void closeConenctionAndStatement() throws Exception{
        this.stmt.close();
        this.conn.close();
    }

    public void updateData(String query){
        try{
            setUpConnectionAndStatement();
            stmt.executeUpdate(query);
            closeConenctionAndStatement();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public ResultSet getResultSet(String query) {
        ResultSet rs = null;
        try {
            setUpConnectionAndStatement();

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
            closeConenctionAndStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return rs;
    }

    public ArrayList<String> getResultAsArrayList(String query, String... resultSetKeyWords) {
        ArrayList<String> row = new ArrayList<>();
        try {
            setUpConnectionAndStatement();
            ResultSet rs = null;

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }

            while (rs.next()) {
                row.add(resultSetRowToString(rs, resultSetKeyWords));
            }
            closeConenctionAndStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return row;
    }

    private String resultSetRowToString(ResultSet rs, String... resultSetKeyWords) throws SQLException {
        StringBuilder output = null;
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
        return string.substring(0, string.length() - 2);
    }

}
