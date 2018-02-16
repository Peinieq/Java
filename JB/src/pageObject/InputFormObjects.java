package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class InputFormObjects extends MainObjects{
	private WebElement enterFirstName;
	private WebElement firstNameInputFieldValidation1;
	private WebElement firstNameInputFieldValidation2;
	private WebElement enterLastName;
	private WebElement lastNameInputFieldValidation1;
	private WebElement lastNameInputFieldValidation2;
	private WebElement enterEMail;
	private WebElement eMailInputFieldValidation1;
	private WebElement eMailInputFieldValidation2;
	private WebElement enterPhone;
	private WebElement phoneInputFieldValidation1;
	private WebElement phoneInputFieldValidation2;
	private WebElement enterAdress;
	private WebElement adressInputFieldValidation1;
	private WebElement adressInputFieldValidation2;
	private WebElement enterCity;
	private WebElement cityInputFieldValidation1;
	private WebElement cityInputFieldValidation2;
	private WebElement chooseState;
	private WebElement stateChooseFieldValidation;
	private WebElement enterZipCode;
	private WebElement zipCodeInputFieldValidation1;
	private WebElement zipCodeInputFieldValidation2;
	private WebElement enterWebsite;
	private WebElement enterHostingYes;
	private WebElement enterHostingNo;
	private WebElement enterProjectDesc;
	private WebElement projectDescInputFieldValidation1;
	private WebElement projectDescInputFieldValidation2;
	private WebElement sendButton;
	private WebElement feedback1;
	private WebElement feedback2;
	private WebElement feedback3;
	private WebElement feedback4;
	private WebElement feedback5;
	private WebElement feedback6;
	private WebElement feedback7;
	private WebElement feedback8;
	private WebElement feedback9;

	
	private final String url="http://www.seleniumeasy.com/test/input-form-demo.html";
    protected RemoteWebDriver wb;
    // WebDriver
    public InputFormObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }
    public InputFormObjects openViaUrl() {
    	wb.get(this.url);
    	return this;
    }
    //First Name
    public InputFormObjects enterFirstNameEnter(String message) {
    	enterFirstName.sendKeys(message);
    	return this;
    }
    public WebElement getFirstNameValidation1() {
    	return firstNameInputFieldValidation1;
    }
    public WebElement getFirstNameValidation2() {
    	return firstNameInputFieldValidation2;
    }
    //Last Name
    public InputFormObjects enterLastNameEnter(String message) {
    	enterLastName.sendKeys(message);
    	return this;
    }
    public WebElement getLastNameValidation1() {
    	return lastNameInputFieldValidation1;
    }
    public WebElement getLastNameValidation2() {
    	return lastNameInputFieldValidation2;
    }
    //EMAIL
    public InputFormObjects enterEMailEnter(String message) {
    	enterEMail.sendKeys(message);
    	return this;
    }
    public WebElement getEMailValidation1() {
    	return eMailInputFieldValidation1;
    }
    public WebElement getEMailValidation2() {
    	return eMailInputFieldValidation2;
    }
    //Phone
    public InputFormObjects enterPhoneEnter(String message) {
    	enterPhone.sendKeys(message);
    	return this;
    }
    public WebElement getPhoneValidation1() {
    	return phoneInputFieldValidation1;
    }
    public WebElement getPhoneValidation2() {
    	return phoneInputFieldValidation2;
    }
    //Adress
    public InputFormObjects enterAdressEnter(String message) {
    	enterAdress.sendKeys(message);
    	return this;
    }
    public WebElement getAdressValidation1() {
    	return adressInputFieldValidation1;
    }
    public WebElement getAdressValidation2() {
    	return adressInputFieldValidation2;
    }
    //City
    public InputFormObjects enterCityEnter(String message) {
    	enterCity.sendKeys(message);
    	return this;
    }
    public WebElement getCityValidation1() {
    	return cityInputFieldValidation1;
    }
    public WebElement getCityValidation2() {
    	return cityInputFieldValidation2;
    }
    //State
    public InputFormObjects chooseStateChoose() {
    	Select States = new Select(chooseState);
    	States.selectByVisibleText("Hawaii");
    	return this;
    }
    public WebElement getStateValidation() {
    	return stateChooseFieldValidation;
    }
    //Zip Code
    public InputFormObjects enterZipCodeEnter(String message) {
    	enterZipCode.sendKeys(message);
    	return this;
    }
    public WebElement getZipCodeValidation1() {
    	return zipCodeInputFieldValidation1;
    }
    public WebElement getZipCodeValidation2() {
    	return zipCodeInputFieldValidation2;
    }
    //Website
    public InputFormObjects enterWebsiteEnter(String message) {
    	enterWebsite.sendKeys(message);
    	return this;
    }
    //Hosting
    public InputFormObjects enterHostingYesEnter() {
    	enterHostingYes.click();
    	return this;
    }
    public InputFormObjects enterHostingNoEnter() {
    	enterHostingNo.click();
    	return this;
    }
    //Project description
    public InputFormObjects enterProjectDescEnter(String message) {
    	enterProjectDesc.sendKeys(message);
    	return this;
    }
    public WebElement getProjectDescValidation1() {
    	return projectDescInputFieldValidation1;
    }
    public WebElement getProjectDescValidation2() {
    	return projectDescInputFieldValidation2;
    }
    //Send button
    public InputFormObjects sendButtonClick() {
    	sendButton.click();
    	return this;
    }
    //Feedback's
    public WebElement feedback1Validation() {
    	return feedback1;
    }
    public WebElement feedback2Validation() {
    	return feedback2;
    }
    public WebElement feedback3Validation() {
    	return feedback3;
    }
    public WebElement feedback4Validation() {
    	return feedback4;
    }
    public WebElement feedback5Validation() {
    	return feedback5;
    }
    public WebElement feedback6Validation() {
    	return feedback6;
    }
    public WebElement feedback7Validation() {
    	return feedback7;
    }
    public WebElement feedback8Validation() {
    	return feedback8;
    }
    public WebElement feedback9Validation() {
    	return feedback9;
    }
    
    public InputFormObjects initElements(RemoteWebDriver wb){
    	enterFirstName=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div[1]/div[1]/input"));
    	//nameInputField = wb.findElement(By.cssSelector("#contact_form > fieldset > div:nth-child(2) > div > div > input"));
    	firstNameInputFieldValidation1 = wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/small[1]"));
    	firstNameInputFieldValidation2 = wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/small[2]"));
    	enterLastName=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[2]/div[1]/div[1]/input"));
    	lastNameInputFieldValidation1 = wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[2]/div/small[1]"));
    	lastNameInputFieldValidation2 = wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[2]/div/small[2]"));
    	enterEMail=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[3]/div[1]/div[1]/input"));
    	eMailInputFieldValidation1=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[3]/div/small[1]"));
    	eMailInputFieldValidation2=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[3]/div/small[2]"));
    	enterPhone=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]/div[1]/div[1]/input"));
    	phoneInputFieldValidation1=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]/div/small[1]"));
    	phoneInputFieldValidation2=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]/div/small[2]"));
    	enterAdress=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[5]/div[1]/div[1]/input"));
    	adressInputFieldValidation1=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[5]/div/small[1]"));
    	adressInputFieldValidation2=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[5]/div/small[2]"));
    	enterCity=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]/div[1]/div[1]/input"));
    	cityInputFieldValidation1=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]/div/small[1]"));
    	cityInputFieldValidation2=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]/div/small[2]"));
    	chooseState=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select"));
    	stateChooseFieldValidation=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/small"));
    	enterZipCode=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/div/input"));
    	zipCodeInputFieldValidation1=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/small[1]"));
    	zipCodeInputFieldValidation2=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/small[2]"));
    	enterWebsite=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[9]/div/div/input"));
    	enterHostingYes=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[10]/div/div[1]/label/input"));
    	enterHostingNo=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[10]/div/div[2]/label/input"));
    	enterProjectDesc=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/div/textarea"));
    	projectDescInputFieldValidation1=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/small[1]"));
    	projectDescInputFieldValidation2=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/small[2]"));
    	sendButton=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[13]/div/button"));
        feedback1=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]"));
    	feedback2=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[2]"));
    	feedback3=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[3]"));
    	feedback4=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]"));
    	feedback5=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[5]"));
    	feedback6=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]"));
    	feedback7=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[7]"));
    	feedback8=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[8]"));
    	feedback9=wb.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[11]"));
    	return this;
    }
}
