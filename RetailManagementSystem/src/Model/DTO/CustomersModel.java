package Model.DTO;

public class CustomersModel {
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_phoneNumber;
    private String customer_email;
    private int customer_credits;
    public CustomersModel(){
        this.customer_id=0;
        this.customer_name=null;
        this.customer_address=null;
        this.customer_phoneNumber=null;
        this.customer_email=null;
        this.customer_credits=0;
    }
    public CustomersModel(int customer_id,String customer_name,String customer_address,String customer_phoneNumber,String customer_email,int customer_credits){
        this.customer_id=customer_id;
        this.customer_name=customer_name;
        this.customer_address=customer_address;
        this.customer_phoneNumber=customer_phoneNumber;
        this.customer_email=customer_email;
        this.customer_credits=customer_credits;
    }
    public void setCustomerId(int customer_id){
        this.customer_id=customer_id;
    }
    public void setCustomerName(String customer_name){
        this.customer_name=customer_name;
    }
    public void setCustomerAddress(String customer_address){
        this.customer_address=customer_address;
    }
    public void setCustomerPhoneNumber(String customer_phoneNumber){
        this.customer_phoneNumber=customer_phoneNumber;
    }
    public void setCustomerEmail(String customer_email){
        this.customer_email=customer_email;
    }
    public void setCustomerCredits(int customer_credits){
        this.customer_credits=customer_credits;
    }
    public int getCustomerId(){
        return this.customer_id;
    }
    public String getCustomerName(){
        return this.customer_name;
    }
    public String getCustomerAddress(){
        return this.customer_address;
    }
    public String getCustomerPhoneNumber(){
        return this.customer_phoneNumber;
    }
    public String getCustomerEmail(){
        return this.customer_email;
    }
    public int getCustomerCredits(){
        return this.customer_credits;
    }
}
