package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.AjaxFormSubmitObjects;
import pageObject.MainObjects;

public class AjaxFormDemoTest {
	private RemoteWebDriver wb;
	private AjaxFormSubmitObjects rbp;
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
	public void enterNameCommentSubmitTest() throws Exception{
		rbp = new AjaxFormSubmitObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterNameEnter("Karol");
		rbp.enterCommentEnter("Strona zadziwi³a mnie swoj¹ prostot¹ i ³atwoœci¹ z niej korzystania");
		mo.buttonClick(rbp.getSubmitButton());
		Thread.sleep(1000);
		
		Assert.assertEquals("Form submited Successfully!", rbp.feedbackValidation().getText());
	}
	
	@After
    public void tearDown() throws Exception {
    	Thread.sleep(2000);
        wb.close();
        wb.quit();
    }
}
