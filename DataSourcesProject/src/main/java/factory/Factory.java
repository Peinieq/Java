package factory;

import domain.User;

import java.util.List;

public interface Factory {
    User selectUserById(int id);
    List selectAllUsers();
}
