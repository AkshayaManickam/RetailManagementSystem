package controller;
import model.dao.UserDAO;
import model.dto.UserModel;

public class UserController {
    private UserDAO userdao;
    public UserController(UserDAO userdao){
        this.userdao=userdao;
    }
    public int addAdmin(UserModel user) throws Exception {
        int rs=userdao.addAdmin(user);
        return rs;
    }
    public int loginAdmin(UserModel user) throws Exception {
        int rs=userdao.loginAdmin(user);
        return rs;
    }
    public int getAdminId() throws Exception{
        int rs1=userdao.getAdminId();
        return rs1;
    }
}
