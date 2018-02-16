package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.TableDataDownloadObjects;

public class TableDataDownloadTest {

	private RemoteWebDriver wb;
	private TableDataDownloadObjects rbp;
	
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erazer\\Desktop\\Selenium\\chromedriver.exe");
		wb = new ChromeDriver();
        wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(1000);
	}
	@Test
	public void sortingTest() throws Exception{
		rbp = new TableDataDownloadObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		
		rbp.sortingNameClick();
		Assert.assertEquals("descending", rbp.getSortingNameValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		rbp.sortingNameClick();
		Assert.assertEquals("ascending", rbp.getSortingNameValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		
		rbp.sortingPositionClick();
		Assert.assertEquals("ascending", rbp.getSortingPositionValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		rbp.sortingPositionClick();
		Assert.assertEquals("descending", rbp.getSortingPositionValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		
		rbp.sortingOfficeClick();
		Assert.assertEquals("ascending", rbp.getSortingOfficeValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		rbp.sortingOfficeClick();
		Assert.assertEquals("descending", rbp.getSortingOfficeValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		
		rbp.sortingAgeClick();
		Assert.assertEquals("ascending", rbp.getSortingAgeValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		rbp.sortingAgeClick();
		Assert.assertEquals("descending", rbp.getSortingAgeValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		
		rbp.sortingStartDateClick();
		Assert.assertEquals("ascending", rbp.getSortingStartDateValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		rbp.sortingStartDateClick();
		Assert.assertEquals("descending", rbp.getSortingStartDateValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		
		rbp.sortingSalaryClick();
		Assert.assertEquals("ascending", rbp.getSortingSalaryValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
		rbp.sortingSalaryClick();
		Assert.assertEquals("descending", rbp.getSortingSalaryValidation().getAttribute("aria-sort"));
		Thread.sleep(1000);
	}
	@Test
	public void searchTest() throws Exception{
		rbp = new TableDataDownloadObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.enterSearchEnter();
		Assert.assertEquals("Showing 1 to 2 of 2 entries (filtered from 31 total entries)", rbp.getEnterSearchValidation().getText());
	}
	@Test
	public void nextAndPreviousTest() throws Exception{
		rbp = new TableDataDownloadObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.nextButtonClick();
		rbp.singleInitElement(wb);
		Assert.assertEquals("Showing 11 to 20 of 31 entries", rbp.getEnterSearchValidation().getText());
		rbp.previousButtonClick();
		Assert.assertEquals("Showing 1 to 10 of 31 entries", rbp.getEnterSearchValidation().getText());
	}
	@Test
	public void moveFirstTest() throws Exception{
		rbp = new TableDataDownloadObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.firstButtonClick();
		Assert.assertEquals("Showing 1 to 10 of 31 entries", rbp.getEnterSearchValidation().getText());
	}
	@Test
	public void moveSecondTest() throws Exception{
		rbp = new TableDataDownloadObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.secondButtonClick();
		Assert.assertEquals("Showing 11 to 20 of 31 entries", rbp.getEnterSearchValidation().getText());
	}
	@Test
	public void moveThirdTest() throws Exception{
		rbp = new TableDataDownloadObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.thirdButtonClick();
		Assert.assertEquals("Showing 21 to 30 of 31 entries", rbp.getEnterSearchValidation().getText());
	}
	@Test
	public void moveFourthTest() throws Exception{
		rbp = new TableDataDownloadObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.fourthButtonClick();
		Assert.assertEquals("Showing 31 to 31 of 31 entries", rbp.getEnterSearchValidation().getText());
	}
	@Test
	public void manipulateTest() throws Exception{
		rbp = new TableDataDownloadObjects(wb);
		rbp.openViaUrl();
		rbp.initElements(wb);
		rbp.copyButtonClick();
		Thread.sleep(2000);
		rbp.csvButtonClick();
		Thread.sleep(2000);
		rbp.excelButtonClick();
		Thread.sleep(2000);
		rbp.pdfButtonClick();
		Thread.sleep(2000);
		rbp.printButtonClick();
	}
	
	@After
    public void tearDown() throws Exception {
    	Thread.sleep(1000);
        wb.close();
        wb.quit();
    }
}
