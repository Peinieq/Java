package factory.implementation;

import domain.User;
import factory.Factory;

import java.util.List;

public class CSVFactory implements Factory {
    @Override
    public List selectAllUsers() {
        return null;
    }

    @Override
    public User selectUserById(int id) {
        return null;
    }
}
