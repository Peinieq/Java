package tests;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.MainObjects;
import pageObject.RadioButtonObjects;

public class RadioButtonDemoTest {
		private RemoteWebDriver wb;
	    private RadioButtonObjects rbp;
	    private MainObjects mo;
	    
		 	@Before
		    public void setUp() throws Exception {
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erazer\\Desktop\\Selenium\\chromedriver.exe");
		        wb = new ChromeDriver();
		        wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		        //wb.manage().window().maximize();
		        mo = new MainObjects(wb);
		        Thread.sleep(1000);
		    }
		 	@Test
		    public void maleTestT1() throws Exception {
		        rbp = new RadioButtonObjects(wb);
		        mo.openViaUrl(rbp.url);
		        rbp.initElements(wb);
		        rbp.maleCheckBoxClickT1();
		        mo.buttonClick(rbp.buttonCheckClickT1());

		        Assert.assertEquals("Radio button 'Male' is checked",rbp.getMessageAfterClickedT1().getText());
		    }

		    @Test
		    public void femaleTestT1() throws Exception {
		        rbp = new RadioButtonObjects(wb);
		        mo.openViaUrl(rbp.url);
		        rbp.initElements(wb);
		        rbp.femaleCheckBoxClickT1();
		        mo.buttonClick(rbp.buttonCheckClickT1());

		        Assert.assertEquals("Radio button 'Female' is checked",rbp.getMessageAfterClickedT1().getText());
		    }
		    @Test
		    public void maleTestZeroToFiveT2() throws Exception {
		        rbp = new RadioButtonObjects(wb);
		        mo.openViaUrl(rbp.url);
		        rbp.initElements(wb);
		        rbp.maleCheckBoxClickT2();
		        rbp.zeroToFiveRadioButton();
		        mo.buttonClick(rbp.buttonCheckClickT2());

		        Assert.assertEquals("Sex : Male"+"\nAge group: 0 - 5",rbp.getMessageAfterClickedT2().getText());
		    }
		    @Test
		    public void maleTestFiveToFifteenT2() throws Exception {
		        rbp = new RadioButtonObjects(wb);
		        mo.openViaUrl(rbp.url);
		        rbp.initElements(wb);
		        rbp.maleCheckBoxClickT2();
		        rbp.fiveToFifteenRadioButton();
		        mo.buttonClick(rbp.buttonCheckClickT2());

		        Assert.assertEquals("Sex : Male"+"\nAge group: 5 - 15",rbp.getMessageAfterClickedT2().getText());
		    }
		    @Test
		    public void maleTestFifteenToFiftyT2() throws Exception {
		        rbp = new RadioButtonObjects(wb);
		        mo.openViaUrl(rbp.url);
		        rbp.initElements(wb);
		        rbp.maleCheckBoxClickT2();
		        rbp.fifteenToFiftyRadioButton();
		        mo.buttonClick(rbp.buttonCheckClickT2());

		        Assert.assertEquals("Sex : Male"+"\nAge group: 15 - 50",rbp.getMessageAfterClickedT2().getText());
		    }
		    

		    @Test
		    public void femaleTestZeroToFiveT2() throws Exception {
		        rbp = new RadioButtonObjects(wb);
		        mo.openViaUrl(rbp.url);
		        rbp.initElements(wb);
		        rbp.femaleCheckBoxClickT2();
		        rbp.zeroToFiveRadioButton();
		        mo.buttonClick(rbp.buttonCheckClickT2());

		        Assert.assertEquals("Sex : Female\n"+"Age group: 0 - 5",rbp.getMessageAfterClickedT2().getText());
		    }
		    @Test
		    public void femaleTestFiveToFifteenT2() throws Exception {
		        rbp = new RadioButtonObjects(wb);
		        mo.openViaUrl(rbp.url);
		        rbp.initElements(wb);
		        rbp.femaleCheckBoxClickT2();
		        rbp.fiveToFifteenRadioButton();
		        mo.buttonClick(rbp.buttonCheckClickT2());

		        Assert.assertEquals("Sex : Female"+"\nAge group: 5 - 15",rbp.getMessageAfterClickedT2().getText());
		    }
		    @Test
		    public void femaleTestFifteenToFiftyT2() throws Exception {
		        rbp = new RadioButtonObjects(wb);
		        mo.openViaUrl(rbp.url);
		        rbp.initElements(wb);
		        rbp.femaleCheckBoxClickT2();
		        rbp.fifteenToFiftyRadioButton();
		        mo.buttonClick(rbp.buttonCheckClickT2());

		        Assert.assertEquals("Sex : Female"+"\nAge group: 15 - 50",rbp.getMessageAfterClickedT2().getText());
		    }
		    @After
		    public void tearDown() throws Exception {
		    	Thread.sleep(2000);
		        wb.close();
		        wb.quit();
		    }
	}
