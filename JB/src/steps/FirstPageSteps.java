package steps;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObject.AjaxFormSubmitObjects;
import pageObject.CheckBoxObjects;
import pageObject.FirstFormObjects;
import pageObject.RadioButtonObjects;

public class FirstPageSteps extends Steps{
	private FirstFormObjects rbp;
	private AjaxFormSubmitObjects afso;
	private RadioButtonObjects rbo;
	private CheckBoxObjects cbo;
	private final String AjaxUrl="http://www.seleniumeasy.com/test/ajax-form-submit-demo.html";
	private final String FfUrl="http://www.seleniumeasy.com/test/basic-first-form-demo.html";
    protected RemoteWebDriver wb;
    
	@When("user goes to start page")
	public void openViaURL() {
		rbp= new FirstFormObjects(wb);
		wb.get(this.FfUrl);
	}
	
	
    @When("user setUp Web Api")
    public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erazer\\Desktop\\Selenium\\chromedriver.exe");
		wb = new ChromeDriver();
        wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(1000);
	}
	
	@When("user enters message")
	public void enterMessageInInput() {
		rbp.enterMessageEnter("Witaj Karol");
	}
	
	@When("user clicks show message button")
	public void messageButtonClick() {
		rbp.showMessageClick();
	}
	
	@Then("message should be $message")
	public void getMessageAfterClick(String message) {
		Assert.assertEquals("Witaj Karol", rbp.getMessageAfterClicked().getText());
	}
	//AJAX
	
	@When("user enters AjaxName message")
	public void enterAjaxNameInput() {
		afso.enterNameEnter("Emil");
	}
	
	@When("user enters AjaxComment message")
	public void enterAjaxCommentInput() {
		afso.enterCommentEnter("Super gosc");
	}
	
	@When("user goes to Ajax page")
	public void openAjaxViaURL() {
		afso = new AjaxFormSubmitObjects(wb);
		afso.openViaUrl();
	}
	
	@When("user clicks Ajax Submit Button")
	public void ajaxSubmitButtonClick() {
		afso.submitButtonClick();
	}
	
	@Then("Ajax feedback should be $message")
	public void getAjaxSumbitFeedback(String message) {
		Assert.assertEquals(message, afso.feedbackValidation().getText());
	}
	
	//Radio Buttons Test
	
	@When("user goes to Radio Button page")
	public void openRadioViaURL() {
		rbo = new RadioButtonObjects(wb);
		rbo.openViaUrl();
	}
	
	@When("user clicks upper Male Radio Button")
	public void upperMaleRadioButtonClick() throws Exception {
		rbo.maleCheckBoxClickT1();
	}
	
	@When("user clicks upper Radio Button submit Button")
	public void upperSubmitClick() throws Exception {
		rbo.buttonCheckClickT1();
	}
	
	@Then("radio button message should be $message")
	public void getRadioButtonSumbitFeedback(String message) {
		Assert.assertEquals("Radio button '"+message+"' is checked",rbo.getMessageAfterClickedT1().getText());
	}
	
	@When("user clicks lower Male Radio Button")
	public void lowerMaleRadioButtonClick() {
		rbo.maleCheckBoxClickT2();
	}
	
	@When("user clicks lower 0-5 Radio Button")
	public void lowerZeroToFiveRadioButtonClick() {
		rbo.zeroToFiveRadioButton();
	}
	
	@When("user clicks lower submit Radio Button")
	public void lowerSubmitRadioButtonClick() throws Exception {
		rbo.buttonCheckClickT2();
	}
	
	@Then("lower radio button message should be ok")
	public void getLowerRadioButtonSumbitFeedback(){
		Assert.assertEquals("Sex : Male"+"\nAge group: 0 - 5",rbo.getMessageAfterClickedT2().getText());
	}

	//Checkbox page
	
	@When("user goes to CheckBox page")
	public void openCheckViaURL() {
		cbo = new CheckBoxObjects(wb);
		cbo.openViaUrl();
	}
	
	@When("user checks all 4 lower checkboxes")
	public void checkLowerFourChecboxes() {
		cbo.optionOneCheckBoxClick();
		cbo.optionTwoCheckBoxClick();
		cbo.optionThreeCheckBoxClick();
		cbo.optionFourCheckBoxClick();
	}
	
	@Then("message on CheckBox button should be Uncheck All")
	public void getMessageFromCheckboxButton() {
		Assert.assertEquals("Message is uncorrect","true", cbo.getCheckAllValidation().getAttribute("value"));
	}
}
