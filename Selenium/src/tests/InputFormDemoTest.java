package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.InputFormObjects;
import pageObject.MainObjects;

public class InputFormDemoTest {
	private RemoteWebDriver wb;
	private InputFormObjects rbp;
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
	public void enterFirstNameTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterFirstNameEnter("Karol");	
		
		//dostawanie siê do parametru textboxa
		//Assert.assertEquals(firstName, rbp.nameInputField.getAttribute("value"));
		Assert.assertEquals("VALID", rbp.getFirstNameValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getFirstNameValidation2().getAttribute("data-bv-result"));
	}
	@Test
	public void enterLastNameTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterLastNameEnter("Opitz");
		
		Assert.assertEquals("VALID", rbp.getLastNameValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getLastNameValidation2().getAttribute("data-bv-result"));
	}
	
	@Test
	public void enterEMailTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterEMailEnter("karol-opitz@wp.pl");	
		
		Assert.assertEquals("VALID", rbp.getEMailValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getEMailValidation2().getAttribute("data-bv-result"));
	}
	@Test
	public void enterPhoneTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterPhoneEnter("(845)555-1212");	
		
		Assert.assertEquals("VALID", rbp.getPhoneValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getPhoneValidation2().getAttribute("data-bv-result"));
	}
	@Test
	public void enterAdressTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterAdressEnter("Kalinowa");	
		
		Assert.assertEquals("VALID", rbp.getAdressValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getAdressValidation2().getAttribute("data-bv-result"));
	}
	@Test
	public void enterCityTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterCityEnter("Turek");	
		
		Assert.assertEquals("VALID", rbp.getCityValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getCityValidation2().getAttribute("data-bv-result"));
	}
	@Test
	public void chooseStateTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.chooseStateChoose();
		
		Assert.assertEquals("VALID", rbp.getStateValidation().getAttribute("data-bv-result"));
	}
	@Test
	public void enterZipCodeTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterZipCodeEnter("01040");
		
		Assert.assertEquals("VALID", rbp.getZipCodeValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getZipCodeValidation2().getAttribute("data-bv-result"));
	}
	@Test
	public void enterWebsiteTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterWebsiteEnter("wp.pl");
	}
	@Test
	public void enterHostingYesNoTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterHostingNoEnter();
		rbp.enterHostingYesEnter();
	}
	@Test
	public void enterProjectDescTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		rbp.enterProjectDescEnter("The county courthouse is a historic building that is located in the oldest town in the state.");
		Assert.assertEquals("VALID", rbp.getProjectDescValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getProjectDescValidation2().getAttribute("data-bv-result"));
	}
	@Test
	public void sendButtonTest() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		mo.buttonClick(rbp.sendButtonClick());
	}
 	@Test
	public void checkAllTests() throws Exception{
		rbp = new InputFormObjects(wb);
		mo.openViaUrl(rbp.url);
		rbp.initElements(wb);
		
		rbp.enterFirstNameEnter("Karol");
		Assert.assertEquals("VALID", rbp.getFirstNameValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getFirstNameValidation2().getAttribute("data-bv-result"));
	
		rbp.enterLastNameEnter("Opitz");
		Assert.assertEquals("VALID", rbp.getLastNameValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getLastNameValidation2().getAttribute("data-bv-result"));
		
		rbp.enterEMailEnter("karol-opitz@wp.pl");	
		Assert.assertEquals("VALID", rbp.getEMailValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getEMailValidation2().getAttribute("data-bv-result"));
	
		rbp.enterPhoneEnter("(845)555-1212");
		Assert.assertEquals("VALID", rbp.getPhoneValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getPhoneValidation2().getAttribute("data-bv-result"));
	
		rbp.enterAdressEnter("Kalinowa");	
		Assert.assertEquals("VALID", rbp.getAdressValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getAdressValidation2().getAttribute("data-bv-result"));
	
		rbp.enterCityEnter("Turek");	
		Assert.assertEquals("VALID", rbp.getCityValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getCityValidation2().getAttribute("data-bv-result"));
	
		rbp.chooseStateChoose();
		Assert.assertEquals("VALID", rbp.getStateValidation().getAttribute("data-bv-result"));
		
		rbp.enterZipCodeEnter("01040");
		Assert.assertEquals("VALID", rbp.getZipCodeValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getZipCodeValidation2().getAttribute("data-bv-result"));
		
		rbp.enterWebsiteEnter("wp.pl");
		
		rbp.enterHostingNoEnter();
		rbp.enterHostingYesEnter();
		
		rbp.enterProjectDescEnter("The county courthouse is a historic building that is located in the oldest town in the state.");
		Assert.assertEquals("VALID", rbp.getProjectDescValidation1().getAttribute("data-bv-result"));
		Assert.assertEquals("VALID", rbp.getProjectDescValidation2().getAttribute("data-bv-result"));
		
		rbp.sendButtonClick();
		Assert.assertEquals("form-group has-feedback", rbp.feedback1Validation().getAttribute("class"));
		Assert.assertEquals("form-group has-feedback", rbp.feedback2Validation().getAttribute("class"));
		Assert.assertEquals("form-group has-feedback", rbp.feedback3Validation().getAttribute("class"));
		Assert.assertEquals("form-group has-feedback", rbp.feedback4Validation().getAttribute("class"));
		Assert.assertEquals("form-group has-feedback", rbp.feedback5Validation().getAttribute("class"));
		Assert.assertEquals("form-group has-feedback", rbp.feedback6Validation().getAttribute("class"));
		Assert.assertEquals("form-group has-feedback", rbp.feedback7Validation().getAttribute("class"));
		Assert.assertEquals("form-group has-feedback", rbp.feedback8Validation().getAttribute("class"));
		Assert.assertEquals("form-group has-feedback", rbp.feedback9Validation().getAttribute("class"));
	}
	@After
    public void tearDown() throws Exception {
    	Thread.sleep(2000);
        wb.close();
        wb.quit();
    }
}
