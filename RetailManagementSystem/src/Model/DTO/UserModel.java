package Model.DTO;
public class UserModel {
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    public UserModel(){
        this.user_id=0;
        this.user_name=null;
        this.user_email=null;
        this.user_password=null;
    }
    UserModel(int user_id,String user_name,String user_email,String user_password){
        this.user_id=user_id;
        this.user_name=user_name;
        this.user_email=user_email;
        this.user_password=user_password;
    }
    public void setUserId(int user_id){
        this.user_id=user_id;
    }
    public void setUserName(String user_name){
        this.user_name=user_name;
    }
    public void setuserEmail(String user_email){
        this.user_email=user_email;
    }
    public void setUserPassword(String user_password){
        this.user_password=user_password;
    }
    public int getUserId(){
        return this.user_id;
    }
    public String getUserName(){
        return this.user_name;
    }
    public String getUserEmail(){
        return this.user_email;
    }
    public String getUserPassword(){
        return this.user_password;
    }
}
