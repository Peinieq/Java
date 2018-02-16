package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.FirstFormObjects;
import pageObject.MainObjects;

public class FirstFormDemoTest {
	private RemoteWebDriver wb;
	private FirstFormObjects rbp;
	private MainObjects mo;
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erazer\\Desktop\\Selenium\\chromedriver.exe");
		wb = new ChromeDriver();
        wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mo = new MainObjects(wb);
        Thread.sleep(1000);
	}
	@Test
	public void enterMessageTest() throws Exception{
		rbp = new FirstFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterMessageEnter("Witaj Karol");
		mo.buttonClick(rbp.showMessageClick());
		
		Assert.assertEquals("Witaj Karol", rbp.getMessageAfterClicked().getText());
	}
	@Test
	public void enterAandBadding() throws Exception{
		rbp = new FirstFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterAEnter("4");
		rbp.enterBEnter("5");
		mo.buttonClick(rbp.getTotalClick());
		
		Assert.assertEquals("9", rbp.getMessageAfterClicked2().getText());
	}
	@After
    public void tearDown() throws Exception {
    	Thread.sleep(2000);
        wb.close();
        wb.quit();
    }
}
