package tools;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StorageFulfilmentAnalyzerTest {

    @Before
    public void setMaxFulfilment() {
        StorageFulfilmentAnalyzer.setStorageCapacity(2);
    }

    @Test
    public void shouldChangeNumberOfPackagesAndIncreaseValueOfFulfilment() {
        StorageFulfilmentAnalyzer.incrementNumberOfPackages();
        StorageFulfilmentAnalyzer.incrementNumberOfPackages();
        Assert.assertTrue(Double.valueOf(0.0).equals(StorageFulfilmentAnalyzer.getActualFulfilment()));
        
        StorageFulfilmentAnalyzer.decrementNumberOfPackages();
        StorageFulfilmentAnalyzer.decrementNumberOfPackages();
        Assert.assertTrue(Double.valueOf(0.0).equals(StorageFulfilmentAnalyzer.getActualFulfilment()));


    }
}
