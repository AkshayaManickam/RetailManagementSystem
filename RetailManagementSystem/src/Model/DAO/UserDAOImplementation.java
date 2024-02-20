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
    public int loginAdmin(UserModel user) throws Exception{
        db.getConnectivity();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        String query="Select admin_password from admin_details where admin_email=?" ;
        preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setString(1, user.getUserEmail());
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            String fetchedPassword = resultSet.getString("admin_password");
            if (fetchedPassword.equals(user.getUserPassword())){ 
                return 1;
            } else {
                return 0;
            }
        } 
        else{
            return -1;
        }
    }
}
