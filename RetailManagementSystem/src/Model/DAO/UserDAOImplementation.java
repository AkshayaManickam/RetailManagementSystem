package Model.DAO;
import java.sql.*;

import Model.DBConnectivity;
import Model.DTO.UserModel;

public class UserDAOImplementation implements UserDAO {
    DBConnectivity db=new DBConnectivity();
    public int addAdmin(UserModel user) throws Exception{
        db.getConnectivity();
        PreparedStatement preparedStatement =null;
        String query="insert into admin_details(admin_id,admin_name,admin_email,admin_password) values (?,?,?,?)" ;
        preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setInt(1, user.getUserId());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3,user.getUserEmail());
        preparedStatement.setString(4, user.getUserPassword());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public int getAdminId() throws Exception{ 
        db.getConnectivity();
        String query = "SELECT COUNT(*) FROM admin_details";
        PreparedStatement preparedStatement =DBConnectivity.con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int rowCount = resultSet.getInt(1);
        return rowCount;
    }
}
