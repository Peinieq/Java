package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstFormObjects extends MainObjects {
	private WebElement enterMessage;
	private WebElement showMessage;
	private WebElement messageAfterClicked;
	private WebElement enterA;
	private WebElement enterB;
	private WebElement getTotal;
	private WebElement messageAfterClicked2;
	
	
	private final String url="http://www.seleniumeasy.com/test/basic-first-form-demo.html";
    protected RemoteWebDriver wb;
    
    public FirstFormObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }
    public FirstFormObjects openViaUrl() {
    	wb.get(this.url);
    	return this;
    }
    public FirstFormObjects enterMessageEnter(String message) {
    	enterMessage.sendKeys(message);
    	return this;
    }
    public FirstFormObjects showMessageClick() {
    	showMessage.click();
    	return this;
    }
    public WebElement getMessageAfterClicked() {
    	return messageAfterClicked;
    }
    
    
    public FirstFormObjects enterAEnter(String message) {
    	enterA.sendKeys(message);
    	return this;
    }
    public FirstFormObjects enterBEnter(String message) {
    	enterB.sendKeys(message);
    	return this;
    }
    public FirstFormObjects getTotalClick() {
    	getTotal.click();
    	return this;
    }
    public WebElement getMessageAfterClicked2() {
    	return messageAfterClicked2;
    }
    
    
    
    public FirstFormObjects initElements(RemoteWebDriver wb){
    	enterMessage=wb.findElement(By.id("user-message"));
    	showMessage=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/form[1]/button[1]"));
    	messageAfterClicked=wb.findElement(By.id("display"));
    	
    	enterA=wb.findElement(By.id("sum1"));
    	enterB=wb.findElement(By.id("sum2"));
    	getTotal=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/form[1]/button[1]"));
    	messageAfterClicked2=wb.findElement(By.id("displayvalue"));
    	
        return this;
    }
}
