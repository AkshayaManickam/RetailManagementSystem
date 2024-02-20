package Model.DAO;

import Model.DTO.UserModel;

public interface UserDAO {
    int addAdmin(UserModel user) throws Exception;
    int getAdminId() throws Exception;
}
