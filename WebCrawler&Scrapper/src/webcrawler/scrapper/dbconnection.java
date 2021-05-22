package webcrawler.scrapper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbconnection {

    String url = "jdbc:derby://localhost:1527/Project";
    Connection conn;
    Statement stmt, stmt1;
    ResultSet rs, rs1;
    PreparedStatement ps;

    public dbconnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver registered");
            conn = DriverManager.getConnection(url, "tam", "tam");
            System.out.println("Connection established");
            stmt = conn.createStatement();
            stmt1 = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet dql(String query) {

        try {
            rs1 = stmt1.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs1;
    }

    public int dml(String query) {
        int rows_affected = 0;
        try {
            rows_affected = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows_affected;
    }

    @Override
    protected void finalize() throws Throwable {
        if (conn != null || !conn.isClosed()) {
            conn.close();
        }
    }
}
