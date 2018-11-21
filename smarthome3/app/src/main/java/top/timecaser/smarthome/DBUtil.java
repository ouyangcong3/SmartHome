package top.timecaser.smarthome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBUtil {



    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://101.201.234.9:3306/smarthome?useUnicode=true&characterEncoding=UTF-8","root","ou302775954");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return con;
    }


    public static String selectADPwd(String mgNo) {
        String result = null;

        try {
            Connection e = getConnection();
            Statement st = e.createStatement();
            String sql = "select password from manager where user=\'" + mgNo + "\'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                result = rs.getString(1);
            }

            rs.close();
            st.close();
            e.close();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return result;
    }
}

