package factory;

import domain.User;

import java.util.List;

public class DAOFactoryProviderHelper implements Factory {

    private Factory source;

    public void setSource(Factory source) {
        this.source = source;
    }

    @Override
    public User selectUserById(int id) {
        return source.selectUserById(id);
    }

    @Override
    public List selectAllUsers() {
        return source.selectAllUsers();
    }
}
