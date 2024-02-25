package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.DBConnectivity;
import model.dto.CustomersModel;

public class CustomersDAOImplementation implements CustomersDAO{
    DBConnectivity db=new DBConnectivity();
    public int addCustomer(CustomersModel cmodel) throws Exception{
        db.getConnectivity();
        PreparedStatement preparedStatement =null;
        String query="insert into customer_details(customer_id,customer_name,customer_address,customer_phoneNumber,customer_email,customer_credits) values (?,?,?,?,?,?)" ;
        preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setInt(1, cmodel.getCustomerId());
        preparedStatement.setString(2,cmodel.getCustomerName());
        preparedStatement.setString(3, cmodel.getCustomerAddress());
        preparedStatement.setString(4, cmodel.getCustomerPhoneNumber());
        preparedStatement.setString(5,cmodel.getCustomerEmail());
        preparedStatement.setInt(6, cmodel.getCustomerCredits());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public int getCustomerId() throws Exception{
        db.getConnectivity();
        String query = "SELECT COUNT(*) FROM customer_details";
        PreparedStatement preparedStatement =DBConnectivity.con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int rowCount = resultSet.getInt(1);
        return rowCount;
    }
    public int removeCustomers(CustomersModel cmodel) throws Exception{
        db.getConnectivity();
        String query="delete from customer_details where customer_phoneNumber=?";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setString(1, cmodel.getCustomerPhoneNumber());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public int updateCustomerNumber(CustomersModel cmodel,String newphoneNumber) throws Exception{
        return 1;
    }
    public int updateCustomerEmail(CustomersModel cmodel,String newEmail) throws Exception{
        return 1;
    }
    public int updateCustomerAddress(CustomersModel cmodel,String newAddress) throws Exception{
        return 1;
    }
    public List<CustomersModel> getAllCustomers() throws Exception{
        db.getConnectivity();
        List<CustomersModel> customerList = new ArrayList<>();
        String query = "SELECT * FROM customer_details";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
           CustomersModel customer = new CustomersModel();
           customer.setCustomerId(resultSet.getInt("customer_id"));
           customer.setCustomerName(resultSet.getString("customer_name"));
           customer.setCustomerAddress(resultSet.getString("customer_address"));
           customer.setCustomerPhoneNumber(resultSet.getString("customer_phoneNumber"));
           customer.setCustomerEmail(resultSet.getString("customer_email"));
           customer.setCustomerCredits(resultSet.getInt("customer_credits"));
           customerList.add(customer);
        }
        return customerList;
    }
}
