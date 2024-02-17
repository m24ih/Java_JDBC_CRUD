import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class App { 
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        
        try{
            connection = helper.getConnection();
            String sql ="insert into city(Name,CountryCode,District,Population) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Konya2");
            statement.setString(2,"TUR");
            statement.setString(3,"Turkey");
            statement.setInt(4,468903904);
            statement.executeUpdate();
            System.out.println("Added to database");
        }catch(SQLException exception){
            helper.showErrorMessage(exception);
            System.out.println(exception.getMessage());
        }finally{
            connection.close();
        }    
    }
 
    
    public static void selectDemo()throws SQLException {
    Connection connection = null;
    DbHelper helper = new DbHelper();
    Statement statement = null;
    ResultSet resultSet;
    
    try{
        connection = helper.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select Code,Name,Continent,Region from country");
        ArrayList<Country> countries = new ArrayList<Country>();
        while(resultSet.next()){
            countries.add(new Country(
                resultSet.getString("Code"),
                resultSet.getString("Name"),
                resultSet.getString("Continent"),
                resultSet.getString("Region")));
        }
        System.out.println(countries.size());
    }catch(SQLException exception){
        helper.showErrorMessage(exception);
        System.out.println(exception.getMessage());
    }finally{
        connection.close();
    }
}

    public void insertData()throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        
        try{
            connection = helper.getConnection();
            String sql ="insert into city(Name,CountryCode,District,Population) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Duzce2");
            statement.setString(2,"TUR");
            statement.setString(3,"Turkey");
            statement.setInt(4,4654248);
            statement.executeUpdate();
            System.out.println("Added to database");
        }catch(SQLException exception){
            helper.showErrorMessage(exception);
            System.out.println(exception.getMessage());
        }finally{
            connection.close();
        }    
    }

    public void updateData() throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        
        try{
            connection = helper.getConnection();
            String sql ="update city set population = 100000 where id  = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4082);
            statement.executeUpdate();
            System.out.println("Database updated");
        }catch(SQLException exception){
            helper.showErrorMessage(exception);
            System.out.println(exception.getMessage());
        }finally{
            connection.close();
        }
    }

    public void deleteData() throws SQLException{
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        
        try{
            connection = helper.getConnection();
            String sql ="delete from city where id  = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4082);
            statement.executeUpdate();
            System.out.println("Deleted from database");
        }catch(SQLException exception){
            helper.showErrorMessage(exception);
            System.out.println(exception.getMessage());
        }finally{
            connection.close();
        }

    }

}