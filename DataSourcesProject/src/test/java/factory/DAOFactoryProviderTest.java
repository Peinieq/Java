package factory;

import domain.User;
import factory.implementation.CSVFactory;
import factory.implementation.DBFFactory;
import factory.implementation.XMLFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import sources.Source;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DAOFactoryProvider.class})
public class DAOFactoryProviderTest {

    @Mock
    CSVFactory csvFactory;

    @Mock
    DBFFactory dbfFactory;

    @Mock
    XMLFactory xmlFactory;

    @InjectMocks
    private DAOFactoryProviderHelper helper = new DAOFactoryProviderHelper();

    @Before
    public void setUp() {
        initMocks(this);
        when(csvFactory.selectUserById(1)).thenReturn(new User(1, "testName1", 10));
        when(dbfFactory.selectUserById(1)).thenReturn(new User(1, "testName1", 10));
        when(xmlFactory.selectUserById(1)).thenReturn(new User(1, "testName1", 10));
    }

    @Test
    public void shouldReturnCSVFactoryInstance() {
        DAOFactoryProvider.INSTANCE.setSource(Source.CSV);
        assertTrue(DAOFactoryProvider.INSTANCE.getFactoryInstance() instanceof CSVFactory);
    }

    @Test
    public void shouldReturnDBFFactoryInstance() {
        DAOFactoryProvider.INSTANCE.setSource(Source.DBF);
        assertTrue(DAOFactoryProvider.INSTANCE.getFactoryInstance() instanceof DBFFactory);
    }

    @Test
    public void shouldReturnXMLFactoryInstance() {
        DAOFactoryProvider.INSTANCE.setSource(Source.XML);
        assertTrue(DAOFactoryProvider.INSTANCE.getFactoryInstance() instanceof XMLFactory);
    }

    @Test
    public void shouldBeTheSameCSVInstance() {
        DAOFactoryProvider.INSTANCE.setSource(Source.CSV);
        Factory expectedInstance = DAOFactoryProvider.INSTANCE.getFactoryInstance();
        DAOFactoryProvider.INSTANCE.setSource(Source.CSV);
        assertEquals(expectedInstance, DAOFactoryProvider.INSTANCE.getFactoryInstance());
    }

    @Test
    public void shouldReturnUserByIdFromCSVSource() {
        DAOFactoryProvider.INSTANCE.setSource(Source.CSV);
        User expectedUser = new User(1, "testName1", 10);
        helper.setSource(csvFactory);
        assertEquals(expectedUser, helper.selectUserById(1));
    }

    @Test
    public void shouldReturnUserByIdFromDBFSource() {
        DAOFactoryProvider.INSTANCE.setSource(Source.DBF);
        User expectedUser = new User(1, "testName1", 10);
        helper.setSource(dbfFactory);
        assertEquals(expectedUser, helper.selectUserById(1));
    }

    @Test
    public void shouldReturnUserByIdFromXMLSource() {
        DAOFactoryProvider.INSTANCE.setSource(Source.XML);
        User expectedUser = new User(1, "testName1", 10);
        helper.setSource(xmlFactory);
        assertEquals(expectedUser, helper.selectUserById(1));
    }

    @Test
    public void testDaoProviderMethodSelectUserById() {
        DAOFactoryProvider mockInstance = mock(DAOFactoryProvider.class);
        Whitebox.setInternalState(DAOFactoryProvider.class, "INSTANCE", mockInstance);
        User expectedUser = new User(1, "TestName", 20);

        when(mockInstance.selectUserById(1)).thenReturn(expectedUser);
        assertEquals(expectedUser, DAOFactoryProvider.INSTANCE.selectUserById(1));
    }


}
