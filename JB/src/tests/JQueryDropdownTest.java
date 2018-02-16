package tests;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.JQueryDropdownObjects;

public class JQueryDropdownTest {
	private RemoteWebDriver wb;
	private JQueryDropdownObjects rbp;

	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erazer\\Desktop\\Selenium\\chromedriver.exe");
		wb = new ChromeDriver();
        wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(1000);
	}
	@Test
	public void selectCountryTest() throws Exception{
		rbp = new JQueryDropdownObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.selectCountryClick();
		Thread.sleep(500);
		rbp.selectCountrySelect();
	}
	@Test
	public void selectStateTest() throws Exception{
		rbp = new JQueryDropdownObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.selectStateClick();
		Thread.sleep(500);
		//rbp.selectStateSelect();
	}
	@Test
	public void selectOutTerritoriesTest() throws Exception{
		rbp = new JQueryDropdownObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.selectOutTerritoriesClick(wb);
		Thread.sleep(2000);
		rbp.selectOutTerritoriesSelect();
	}
	@Test
	public void selectFileTest() throws Exception{
		rbp = new JQueryDropdownObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.selectFileSelect();
	}
	@After
    public void tearDown() throws Exception {
    	Thread.sleep(1000);
        wb.close();
        wb.quit();
    }
}
