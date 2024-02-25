package model.dao;

import model.dto.CustomersModel;
import java.util.List;

public interface CustomersDAO {
    int addCustomer(CustomersModel cmodel) throws Exception;
    int getCustomerId() throws Exception;
    int removeCustomers(CustomersModel cmodel) throws Exception;
    int updateCustomerNumber(CustomersModel cmodel,String newphoneNumber) throws Exception;
    int updateCustomerEmail(CustomersModel cmodel,String newEmail) throws Exception;
    int updateCustomerAddress(CustomersModel cmodel,String newAddress) throws Exception;
    public List<CustomersModel> getAllCustomers() throws Exception;
}
