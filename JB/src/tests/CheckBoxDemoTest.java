package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.CheckBoxObjects;

public class CheckBoxDemoTest {
		private RemoteWebDriver wb;
		private CheckBoxObjects rbp;
		@Before
		public void setUp() throws Exception{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erazer\\Desktop\\Selenium\\chromedriver.exe");
			wb = new ChromeDriver();
	        wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        Thread.sleep(1000);
		}
		
		@Test
		public void clickOnThisTest() throws Exception{
			rbp = new CheckBoxObjects(wb);
			rbp.openViaUrl();
			rbp.initElements(wb);
			rbp.clickOnThisCheckBoxClick();
			
			Assert.assertEquals("Success - Check box is checked", rbp.getMessageAfterClickedT1().getText());
		}
		
		@Test
		public void optionOneTest() throws Exception{
			rbp = new CheckBoxObjects(wb);
			rbp.openViaUrl();
			rbp.initElements(wb);
			rbp.optionOneCheckBoxClick();
		}
		
		@Test
		public void optionTwoTest() throws Exception{
			rbp = new CheckBoxObjects(wb);
			rbp.openViaUrl();
			rbp.initElements(wb);
			rbp.optionTwoCheckBoxClick();
		}
		@Test
		public void optionThreeTest() throws Exception{
			rbp = new CheckBoxObjects(wb);
			rbp.openViaUrl();
			rbp.initElements(wb);
			rbp.optionThreeCheckBoxClick();
		}
		@Test
		public void optionFourTest() throws Exception{
			rbp = new CheckBoxObjects(wb);
			rbp.openViaUrl();
			rbp.initElements(wb);
			rbp.optionFourCheckBoxClick();
		}
		@Test
		public void checkAllTest() throws Exception{
			rbp = new CheckBoxObjects(wb);
			rbp.openViaUrl();
			rbp.initElements(wb);
			rbp.checkAllButtonClick();
			Assert.assertEquals("true", rbp.getCheckAllValidation().getAttribute("value"));
			Thread.sleep(1500);
			rbp.checkAllButtonClick();
			Assert.assertEquals("false", rbp.getCheckAllValidation().getAttribute("value"));
		}
		
		@After
	    public void tearDown() throws Exception {
	    	Thread.sleep(2000);
	        wb.close();
	        wb.quit();
	    }
}
