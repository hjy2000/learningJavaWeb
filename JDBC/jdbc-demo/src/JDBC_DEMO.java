import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class JDBC_DEMO {
    public void test1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //反射加载类 其实可以不用手动写 自动加载
        String url="jdbc:mysql://localhost:3306/TEST1?useSSL=false";

        String username="root";
        String pwd="440221";
        Connection conn = DriverManager.getConnection(url,username,pwd);//获取stmt对象及管理事务

        String sql="UPDATE account set money = 100;";

        Statement stmt = conn.createStatement();
        try {
            conn.setAutoCommit(false);

            int count = stmt.executeUpdate(sql);
            System.out.println(count);

            conn.commit();
        }
        catch(Exception e)
        {
            conn.rollback();
            e.printStackTrace();
        }
        stmt.close();
        conn.close();
    }

    /**
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void test2() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //反射加载类 其实可以不用手动写 自动加载
        String url="jdbc:mysql://localhost:3306/TEST1?useSSL=false";

        String username="root";
        String pwd="440221";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        String sql="select * from account;";
        Statement stmt = conn.createStatement();//获取stmt对象及管理事务
        ResultSet rs= stmt.executeQuery(sql);
        while(rs.next())//光标下移并返回布尔值
        {
            int id = rs.getInt(1);
            String name=rs.getString(2);
            int m = rs.getInt(3);
            System.out.format("id:%d,name:%s,money:%d",id,name,m);
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    //PreparedStatement作用：预编译SQL语句并执行：预防SQL注入问题
    public void test3() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //反射加载类 其实可以不用手动写 自动加载
        String url="jdbc:mysql://localhost:3306/TEST1?useSSL=false&useServerPrepStmts=true";//开启预编译

        String username="root";
        String pwd="440221";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        String sql="select * from account where id=?;";
        PreparedStatement stmt = conn.prepareStatement(sql);//获取stmt对象及管理事务
        stmt.setInt(1,1);//对值进行转义 ‘会转义为\’（即符号原意）
        ResultSet rs= stmt.executeQuery();//这里就不用传sql了
        while(rs.next())//光标下移并返回布尔值
        {
            int id = rs.getInt(1);
            String name=rs.getString(2);
            int m = rs.getInt(3);
            System.out.format("id:%d,name:%s,money:%d",id,name,m);
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void driudTest() throws Exception {
        Properties prop=new Properties();//加载配置文件
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource d=DruidDataSourceFactory.createDataSource(prop);//获取连接池对象
        Connection conn=d.getConnection();//获取数据库链接
        System.out.println(conn);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JDBC_DEMO j = new JDBC_DEMO();
        //j.test1();
        //j.test2();
    }
}
