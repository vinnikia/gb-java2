package lesson7.server;

import java.sql.*;


public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String password){
        String sql = String.format("SELECT nickname FROM main\n" +
                "WHERE login = '%s'\n" +
                "AND password = '%s'", login, password);

        try {
            ResultSet rs =stmt.executeQuery(sql);
            if(rs.next()){
                return rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean isUserExists(String nick) {
        String sql = String.format("SELECT COUNT(*) FROM main WHERE nickname = '%s'", nick);
        try {
            ResultSet rs =stmt.executeQuery(sql);
            if(rs.next() && rs.getInt(1) == 1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
