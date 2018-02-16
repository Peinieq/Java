package sources;

import factory.Factory;
import factory.implementation.CSVFactory;
import factory.implementation.DBFFactory;
import factory.implementation.XMLFactory;

public enum Source {
    CSV (new CSVFactory()),
    DBF (new DBFFactory()),
    XML (new XMLFactory());

    Factory factory;

    Source(Factory factory) {
        this.factory = factory;
    }

    public Factory getFactory() {
        return factory;
    }
}
