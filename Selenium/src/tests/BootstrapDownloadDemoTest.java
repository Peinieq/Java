package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.BootstrapDownloadProgressObjects;
import pageObject.MainObjects;

public class BootstrapDownloadDemoTest {
	private RemoteWebDriver wb;
	private BootstrapDownloadProgressObjects rbp;
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
	public void downloadTest() throws Exception{
		rbp = new BootstrapDownloadProgressObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		
		mo.buttonClick(rbp.getButtonDownload());
		Thread.sleep(500);
		Assert.assertEquals("btn btn-block btn-primary active", rbp.getFeedback().getAttribute("class"));
		Thread.sleep(23000);
		Assert.assertEquals("circle end complate", rbp.getFeedbackCircle().getAttribute("class"));
	}
	@After
    public void tearDown() throws Exception {
    	Thread.sleep(2000);
        wb.close();
        wb.quit();
    }
}
