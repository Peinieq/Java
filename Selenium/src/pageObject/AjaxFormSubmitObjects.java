package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AjaxFormSubmitObjects extends MainObjects{
	private WebElement enterName;
	private WebElement enterComment;
	private WebElement submitButton;
	private WebElement feedback;
	
	public final String url="/test/ajax-form-submit-demo.html";
    protected RemoteWebDriver wb;
    
    public AjaxFormSubmitObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }
    public AjaxFormSubmitObjects enterNameEnter(String message) {
    	enterName.sendKeys(message);
    	return this;
    }
    public AjaxFormSubmitObjects enterCommentEnter(String message) {
    	enterComment.sendKeys(message);
    	return this;
    }
    public WebElement getSubmitButton() {
    	return submitButton;
    }
    public WebElement feedbackValidation() {
    	return feedback;
    }
    
    public AjaxFormSubmitObjects initElements(RemoteWebDriver wb) {
    	enterName=wb.findElement(By.xpath("//*[@id=\"title\"]"));
    	enterComment=wb.findElement(By.xpath("//*[@id=\"description\"]"));
    	submitButton=wb.findElement(By.xpath("//*[@id=\"btn-submit\"]"));
    	feedback=wb.findElement(By.xpath("//*[@id=\"submit-control\"]"));
    	return this;
    }
}
