package sources;

import factory.implementation.CSVFactory;
import factory.implementation.DBFFactory;
import factory.implementation.XMLFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SourceTest {

    @Test
    public void shouldReturnCSVFactoryInstance() {
        assertTrue(Source.CSV.getFactory() instanceof CSVFactory);
    }

    @Test
    public void shouldReturnDBFFactoryInstance() {
        assertTrue(Source.DBF.getFactory() instanceof DBFFactory);
    }

    @Test
    public void shouldReturnXMLFactoryInstance() {
        assertTrue(Source.XML.getFactory() instanceof XMLFactory);
    }

    @Test
    public void shouldBeTheSameInstancesOfFactoryType() {
        assertTrue(Source.CSV.getFactory() == Source.CSV.getFactory());
        assertTrue(Source.DBF.getFactory() == Source.DBF.getFactory());
        assertTrue(Source.XML.getFactory() == Source.XML.getFactory());
    }
}
