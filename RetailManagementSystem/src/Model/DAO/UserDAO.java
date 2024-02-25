package model.dao;

import model.dto.UserModel;

public interface UserDAO {
    int addAdmin(UserModel user) throws Exception;
    int getAdminId() throws Exception;
    int loginAdmin(UserModel user) throws Exception;
}
