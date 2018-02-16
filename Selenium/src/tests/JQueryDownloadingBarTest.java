package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.JQueryDownloadingBarObjects;
import pageObject.MainObjects;

public class JQueryDownloadingBarTest {
	private RemoteWebDriver wb;
	private JQueryDownloadingBarObjects rbp;
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
	public void downloadingTest() throws Exception{
		rbp = new JQueryDownloadingBarObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		mo.buttonClick(rbp.startDownloadClick());
		Thread.sleep(1500);
		mo.buttonClick(rbp.cancelDownloadClick());
		Thread.sleep(1500);
		Assert.assertEquals("height: auto; width: 300px; top: 315px; left: 358.5px; display: none;", rbp.getCancelValidation().getAttribute("style"));
		Thread.sleep(1500);
		mo.buttonClick(rbp.startDownloadClick());
		Thread.sleep(9000);
		Assert.assertEquals("Complete!", rbp.getDownloadEndValidation().getText());
		mo.buttonClick(rbp.closeDownloadClick());
		
	}
	@After
    public void tearDown() throws Exception {
    	Thread.sleep(1000);
        wb.close();
        wb.quit();
    }
}
