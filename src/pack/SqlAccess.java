package pack;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlAccess {
    public static int total = 0;
    public List<item> itemList;
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String username = System.getenv("ACCESSKEY");
        String password = System.getenv("SECRETKEY");
        String dbUrl = String.format("jdbc:mysql://%s:%s/%s",
                System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"),
                System.getenv("MYSQL_DB"));
        try {
            Class.forName(driver).newInstance();
            //connect = DriverManager.getConnection("jdbc:mysql://localhost/bookdb?"+ "user=root&password=123456");
            connect = DriverManager.getConnection("jdbc:mysql://ufpzjczbyypj.rds.sae.sina.com.cn:10555/bookdb?"+ "user=root&password=123456");

            statement = connect.createStatement();
        }catch (Exception e){
            throw e;
        }
    }
    public void store(int AuthorID,String Name,int Age,String Country)throws Exception{
        preparedStatement = connect.prepareStatement(
                "insert into  bookdb.Author values (?,?,?,?)");
        preparedStatement.setInt(1,AuthorID);
        preparedStatement.setString(2,Name);
        preparedStatement.setInt(3,Age);
        preparedStatement.setString(4,Country);
        preparedStatement.executeUpdate();
    }
    public List<item> update_list(ResultSet rs)throws Exception{
        itemList=new ArrayList<item>();
        while (rs.next()){
            item temp=new item(rs.getString(1),rs.getString(2),
                    rs.getInt(3),rs.getString(4),rs.getString(5),
                    rs.getString(6));
            itemList.add(temp);
        }
        return itemList;
    }
    public ResultSet select_name(String name)throws Exception{
        String s="SELECT * FROM  bookdb.Author WHERE Name='"+name+"'";
        resultSet=statement.executeQuery(s);
        return resultSet;
    }
    public ResultSet searchbook(int id)throws Exception{
        String s="select * from bookdb.Book WHERE AuthorID='"+String.valueOf(id)+"'";
        resultSet=statement.executeQuery(s);
        return resultSet;
    }
    public int isbn_to_id(String isbn)throws Exception{
        String s="select * from bookdb.Book WHERE Isbn='"+isbn+"'";
        resultSet=statement.executeQuery(s);
        resultSet.next();
        return resultSet.getInt(3);
    }
    public String id_to_name(int id)throws Exception{
        String s="select * from bookdb.Author WHERE AuthorID="+String.valueOf(id);
        resultSet=statement.executeQuery(s);
        resultSet.next();
        return resultSet.getString(2);
    }
    public ResultSet viewTotal()throws Exception{

        resultSet=statement.executeQuery(
                "select * from bookdb.Author");
        return resultSet;
    }
    public void delete(String a)throws Exception{
        preparedStatement =  connect.prepareStatement(
                "delete from bookdb.Book where Isbn='"+a+"'");
        preparedStatement.executeUpdate();
    }
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        }
    }

}
