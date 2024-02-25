package controller;

import java.util.List;

import model.dao.CustomersDAO;
import model.dto.CustomersModel;

public class CustomerController {
    private CustomersDAO cdao;
    public CustomerController(CustomersDAO cdao){
        this.cdao=cdao;
    }
    public int addCustomer(CustomersModel cmodel) throws Exception {
        int rs=cdao.addCustomer(cmodel);
        return rs;
    }
    public int getCustomerId() throws Exception{
        int rs1=cdao.getCustomerId();
        return rs1;
    }
    public int removeCustomers(CustomersModel cmodel) throws Exception{
        int rs1=cdao.removeCustomers(cmodel);
        return rs1;
    }
    public int updateCostumerNumber(CustomersModel cmodel,String newphoneNumber) throws Exception{
        int rs1=cdao.updateCustomerNumber(cmodel,newphoneNumber);
        return rs1;
    }
    public int updateCustomerEmail(CustomersModel cmodel,String newEmail) throws Exception{
        int rs1=cdao.updateCustomerEmail(cmodel,newEmail);
        return rs1;
    }
    public int updateCustomerAddress(CustomersModel cmodel,String newAddress) throws Exception{
        int rs1=cdao.updateCustomerAddress(cmodel,newAddress);
        return rs1;
    }
    public List<CustomersModel> getAllCustomers() throws Exception{
        List<CustomersModel> customer=cdao.getAllCustomers();
        return customer;
    }
}
