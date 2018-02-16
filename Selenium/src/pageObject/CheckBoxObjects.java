package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;

public class CheckBoxObjects extends MainObjects{
	private WebElement clickOnThisCheckBox;
    private WebElement optionOneCheckBox;
    private WebElement optionTwoCheckBox;
    private WebElement optionThreeCheckBox;
    private WebElement optionFourCheckBox;
    private WebElement checkAllButton;
    private WebElement checkAllValidation;
    
    private WebElement messageAfterClickedT1;
    public final String url="/test/basic-checkbox-demo.html";
    protected RemoteWebDriver wb;
    
    public CheckBoxObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }

    public CheckBoxObjects clickOnThisCheckBoxClick() {
    	clickOnThisCheckBox.click();
    	return this;
    }
    
    public WebElement getMessageAfterClickedT1() {
    	return messageAfterClickedT1;
    }
    
    public CheckBoxObjects optionOneCheckBoxClick() {
    	optionOneCheckBox.click();
    	return this;
    }
    public CheckBoxObjects optionTwoCheckBoxClick() {
    	optionTwoCheckBox.click();
    	return this;
    }
    public CheckBoxObjects optionThreeCheckBoxClick() {
    	optionThreeCheckBox.click();
    	return this;
    }
    public CheckBoxObjects optionFourCheckBoxClick() {
    	optionFourCheckBox.click();
    	return this;
    }
    public WebElement checkAllButtonClick() {
    	return checkAllButton;
    }
    public WebElement getCheckAllValidation() {
    	return checkAllValidation;
    }
    
    public CheckBoxObjects initElements(RemoteWebDriver wb){
    	clickOnThisCheckBox=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/div[1]/label[1]/input"));
    	messageAfterClickedT1=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/div[2]"));
    	
    	optionOneCheckBox=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input"));
    	optionTwoCheckBox=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[1]/input"));
    	optionThreeCheckBox=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label[1]/input"));
    	optionFourCheckBox=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label[1]/input"));
    	checkAllButton=wb.findElement(By.id("check1"));
    	
    	checkAllValidation=wb.findElement(By.xpath("//*[@id=\"isChkd\"]"));
        return this;
    }

}
