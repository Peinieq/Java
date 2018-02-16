package factory;

import domain.User;
import sources.Source;

import java.util.List;

public enum  DAOFactoryProvider implements Factory {
    INSTANCE;

    private Factory factory;

    public void setSource(Source source) {
        factory = source.getFactory();
    }

    public Factory getFactoryInstance() {
        return factory;
    }

    @Override
    public User selectUserById(int id) {
        return factory.selectUserById(id);
    }

    @Override
    public List selectAllUsers() {
        return factory.selectAllUsers();
    }
}
