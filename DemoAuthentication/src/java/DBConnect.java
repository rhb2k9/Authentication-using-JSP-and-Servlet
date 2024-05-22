/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sahil
 */
import java.sql.*;

public class DBConnect {
    
    Connection con;
    public Connection getConnect() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Sample?autoReconnect=true&useSSL=false";
            String user="root";
            String password="1234";
            con = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException ex) {
            
        }
        return con;
    }
    
    public int check(String p, String q){
        int k=0;
        //if proper k=1
        String str ="select * from users where username='"+p+"' and password ='"+q+"'";
        Statement st;
        try{
            Connection m = getConnect();
            st = m.createStatement();
            ResultSet rs;
            rs = st.executeQuery(str);
            if (rs.next()){
                k=1;
            }
        }catch(Exception e){
            
        }
        
        return k;
    }
}
