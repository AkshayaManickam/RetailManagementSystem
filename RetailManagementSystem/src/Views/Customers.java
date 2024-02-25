package views;

import controller.CustomerController;
import model.dao.CustomersDAO;
import model.dao.CustomersDAOImplementation;
import model.dto.CustomersModel;

import java.util.List;

public class Customers extends Admin {
    CustomersModel cmodel=new CustomersModel();
    CustomersDAO cdao=new CustomersDAOImplementation();
    CustomerController ccontrol=new CustomerController(cdao);

    public void customerPage() throws Exception{
        System.out.println("\nWELCOME TO CUSTOMER MANAGEMENT PAGE\n");
		int ch;
		do
		{
			System.out.println("\n*****************************************************\n");
			System.out.println("1 - ADD CUSTOMERS");
			System.out.println("2 - REMOVE CUSTOMERS");
			System.out.println("3 - ALTER CUSTOMERS INFO");
			System.out.println("4 - VIEW ALL CUSTOMERS");
			System.out.println("5 - EXIT PAGE");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : \n");
			ch=obj.nextInt();
			if(ch==1)
				addCustomers();
			else if(ch==2)
				removeCustomers();
			else if(ch==3)
				alterCustomersInfo();
			else if(ch==4)
				viewCustomers();
		}while(ch<=4);
    }
    public void addCustomers() throws Exception{
        char ch=' ';
        String cus_name,phoneNumber,email,address;
        int cus_credits;
        do{
            System.out.println("\nEnter the details to Add the customer\n");
            System.out.println("*****************************************************\n");
            obj.nextLine();
            System.out.println("Enter customer name");
            cus_name=obj.nextLine();
            System.out.println("Enter customer address");
            address=obj.nextLine();
            System.out.println("Enter customer Phone Number");
            phoneNumber=obj.nextLine();
            System.out.println("Enter customer email");
            email=obj.nextLine();
            System.out.println("Enter customer credits");
            cus_credits=obj.nextInt();
            int c_id=getCId();
            cmodel.setCustomerId(c_id);
            cmodel.setCustomerName(cus_name);
            cmodel.setCustomerAddress(address);
            cmodel.setCustomerPhoneNumber(phoneNumber);
            cmodel.setCustomerEmail(email);
            cmodel.setCustomerCredits(cus_credits);
            if(phoneNumber.length()==10){
                int rs=ccontrol.addCustomer(cmodel);
                if(rs==1){
                    System.out.println("Customer added Successfully");
                    System.out.print("Do you want to continue ( Y for yes , N for NO )");
                    ch=obj.next().charAt(0);
                }
                else{
                    System.out.println("Customer not added");
                    System.out.print("Do you want to continue ( Y for yes , N for NO )");
                    ch=obj.next().charAt(0);
                }
            }
            else{
                System.out.println("Invalid Phone number");
                System.out.print("Do you want to continue ( Y for yes , N for NO )");
                ch=obj.next().charAt(0);
            }
        }while(ch=='y' || ch=='Y');
    }
    public void removeCustomers() throws Exception{
        char ch=' ';
        String phoneNumber;
        do{
            System.out.println("\nEnter the details to Remove the customer\n");
            System.out.println("*****************************************************\n");
            System.out.println("Enter customer Phone Number");
            phoneNumber=obj.nextLine();
            cmodel.setCustomerPhoneNumber(phoneNumber);
            int rs=ccontrol.removeCustomers(cmodel);
            if(rs==1){
                System.out.println("Customer removed Successfully");
                System.out.print("Do you want to continue ( Y for yes , N for NO )");
                ch=obj.next().charAt(0);
            }
            else{
                System.out.println("No Customer found with this phone Number");
                System.out.print("Do you want to continue ( Y for yes , N for NO )");
                ch=obj.next().charAt(0);
            }
        }while(ch=='y' || ch=='Y');
    }
    public void alterCustomersInfo() throws Exception{
        char ch=' ';
        String customer_phoneNumber,customer_email,customer_address;
        String customer_newphoneNumber,customer_newAddress,customer_newEmail;
        do{
            System.out.println("Enter the Details to Alter Product\n");
            System.out.println("*****************************************************");
			System.out.println("1 - UPDATE CUSTOMER PHONE NUMBER");
			System.out.println("2 - UPDATE CUSTOMER ADDRESS");
			System.out.println("3 - UPDATE CUSTOMER EMAIL");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			int t=obj.nextInt();
            if(t==1){
                obj.nextLine();
                System.out.println("Enter customer phone Number");
                customer_phoneNumber=obj.nextLine();
				System.out.println("Enter new customer phone Number");
                customer_newphoneNumber=obj.nextLine();
                cmodel.setCustomerPhoneNumber(customer_phoneNumber);
                int rs=ccontrol.updateCostumerNumber(cmodel,customer_newphoneNumber);
				if(rs==1){
					System.out.println("Customer phone Number updated Successfully");
					System.out.print("Do you want to continue ( Y for yes , N for NO )");
					ch=obj.next().charAt(0);
				}
				else{
					System.out.println("Customer phone Number not updated");
					System.out.print("Do you want to continue ( Y for yes , N for NO )");
					ch=obj.next().charAt(0);
				}
            }
            else if(t==2){
                obj.nextLine();
                System.out.println("Enter customer phone Number");
                customer_phoneNumber=obj.nextLine();
                System.out.println("Enter customer email");
                customer_email=obj.nextLine();
				System.out.println("Enter new customer email");
                customer_newEmail=obj.nextLine();
                cmodel.setCustomerPhoneNumber(customer_phoneNumber);
                cmodel.setCustomerEmail(customer_email);
                int rs=ccontrol.updateCustomerEmail(cmodel,customer_newEmail);
				if(rs==1){
					System.out.println("Customer Email updated Successfully");
					System.out.print("Do you want to continue ( Y for yes , N for NO )");
					ch=obj.next().charAt(0);
				}
				else{
					System.out.println("Customer Email not updated");
					System.out.print("Do you want to continue ( Y for yes , N for NO )");
					ch=obj.next().charAt(0);
				}
            }
            else if(t==3){
                obj.nextLine();
                System.out.println("Enter customer phone Number");
                customer_phoneNumber=obj.nextLine();
                System.out.println("Enter customer Address");
                customer_address=obj.nextLine();
				System.out.println("Enter new customer Address");
                customer_newAddress=obj.nextLine();
                cmodel.setCustomerPhoneNumber(customer_phoneNumber);
                cmodel.setCustomerAddress(customer_address);
                int rs=ccontrol.updateCustomerAddress(cmodel,customer_newAddress);
				if(rs==1){
					System.out.println("Customer Address updated Successfully");
					System.out.print("Do you want to continue ( Y for yes , N for NO )");
					ch=obj.next().charAt(0);
				}
				else{
					System.out.println("Customer Address not updated");
					System.out.print("Do you want to continue ( Y for yes , N for NO )");
					ch=obj.next().charAt(0);
				}
            }   
        }while(ch=='y' || ch=='Y');
    }
    public void viewCustomers() throws Exception{
        List<CustomersModel> customerList = ccontrol.getAllCustomers();
		for (CustomersModel customer : customerList) {
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Customer Name: " + customer.getCustomerName());
			System.out.println("Customer Address: " + customer.getCustomerAddress());
            System.out.println("Customer PhoneNo: " + customer.getCustomerPhoneNumber());
			System.out.println("Customer Email: " + customer.getCustomerEmail());
			System.out.println("Customer Credits: " + customer.getCustomerCredits());
            System.out.println("------------------------");
        }
    }
    public int getCId() throws Exception{
        int id=ccontrol.getCustomerId();
        if(id==0){
            return 1;
        }
        else{
            return id+1;
        }
    }
}

