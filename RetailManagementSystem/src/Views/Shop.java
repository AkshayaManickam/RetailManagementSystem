package Views;
import java.util.*;
import Controller.UserController;
import Model.DAO.UserDAO;
import Model.DAO.UserDAOImplementation;
import Model.DTO.UserModel;
public class Shop {
    UserModel model=new UserModel();
    UserDAO userdao=new UserDAOImplementation();
    UserController control=new UserController(userdao);
    private Scanner obj;
    public Shop(){
        obj=new Scanner(System.in);
    }
    public void shopPage() throws Exception{
        System.out.println("\nWELCOME TO ONLINE SHOPPING SYSTEM\n");
        int ch;
        do
        {
            System.out.println("*****************************************************\n");
            System.out.println("1 - REGISTER");
            System.out.println("2 - LOGIN TO SYSTEM");
            System.out.println("3 - EXIT");
            System.out.println("*****************************************************\n");
            System.out.print("Enter choice : ");
            ch=obj.nextInt();
            if(ch==1)
                register();
            else if(ch==3)
                loginSystem();
            else if(ch==4)
                System.out.println("Thank you !! Visit again.");
            else
                System.out.println("Wrong choice");
        }while(ch!=4);
    }
    public void register() throws Exception{
        String user_name,email,password,conform_password;
        System.out.println("\nWELCOME TO REGISTRATION PAGE\n");
		System.out.println("*****************************************************\n");
        obj.nextLine();
        System.out.println("Enter your name");
        user_name=obj.nextLine();
        System.out.println("Enter your email");
        email=obj.nextLine();
        System.out.println("Enter your password");
        password=obj.nextLine();
        System.out.println("Enter your conform password");
        conform_password=obj.nextLine();
        int a_id=getAId();
        model.setUserId(a_id);
        model.setUserName(user_name);
        model.setuserEmail(email);
        model.setUserPassword(password);
        if(password.equals(conform_password)){
            int result=control.addAdmin(model);
            if(result==1){
                System.out.println("REGISTRATION DONE SUCCESSFULLY !\n");
            }
            else{
                System.out.println("REGISTRATION FAILED !\n");
            }
        }
        else{
            System.out.println("Password not Match");
        }
    }
    public void loginSystem(){
       
    }
    public int getAId() throws Exception{
        int id=control.getAdminId();
        if(id==0){
            return 1;
        }
        else{
            return id+1;
        }
    }
}
