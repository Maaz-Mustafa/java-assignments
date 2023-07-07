package q1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoJDBC {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/intranet_db";
    static final String USER = "maaz";
    static final String PASS = "psql@1234";
    static final String QUERY = "SELECT * FROM vendor";
    static final String QUERY2 = "SELECT v.id,v.category,u.date_of_birth,u.email,u.first_name from vendor v,intranet_user u where v.id=u.id";

    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DB_URL,USER,PASS );
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(QUERY);
            while(rs.next()){
                //Display values
                System.out.println("ID       : " + rs.getInt("id"));
                System.out.println("Category : " + rs.getString("category"));
                System.out.println("Companyc : " + rs.getString("company"));
                System.out.println("email    : " + rs.getString("email"));
            }

            System.out.println("================== Query 2 Output =================");
            ResultSet rs2=stmt.executeQuery(QUERY2);
            while(rs2.next()){
                System.out.println("ID            : "+rs2.getInt("id"));
                System.out.println("Company       : "+rs2.getString("category"));
                System.out.println("date of Birth : "+rs2.getDate("date_of_birth"));
                System.out.println("name          : "+rs2.getString("first_name"));
                System.out.println("email         : "+rs2.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connection to database failed");
        }
        System.out.println("Connected to database successfully");
    }
}
