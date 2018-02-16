package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RadioButtonObjects extends MainObjects {

	private WebElement maleRadioButtonT1;
    private WebElement femaleRadioButtonT1;
    private WebElement maleRadioButtonT2;
    private WebElement femaleRadioButtonT2;
    private WebElement buttonCheckT1;
    private WebElement buttonCheckT2;
    private WebElement zeroToFiveRadioButton;
    private WebElement fiveToFifteenRadioButton;
    private WebElement fifteenToFiftyRadioButton;
    
    private WebElement messageAfterClickedT1;
    private WebElement messageAfterClickedT2;
    private final String url="http://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
    protected RemoteWebDriver wb;
    
    public RadioButtonObjects(RemoteWebDriver wb) {
		this.wb=wb;
	}
    
	public RadioButtonObjects openViaUrl(){
        wb.get(this.url);
        return this;
    }
    
    public RadioButtonObjects femaleCheckBoxClickT1(){
        femaleRadioButtonT1.click();
        return this;
    }

    public RadioButtonObjects maleCheckBoxClickT1(){
        this.maleRadioButtonT1.click();
        return this;
    }
    public RadioButtonObjects buttonCheckClickT1() throws InterruptedException {
        buttonCheckT1.click();
        return this;
    }
    
    public WebElement getMessageAfterClickedT1() {
        return messageAfterClickedT1;
    }
    public RadioButtonObjects femaleCheckBoxClickT2(){
        femaleRadioButtonT2.click();
        return this;
    }

    public RadioButtonObjects maleCheckBoxClickT2(){
        this.maleRadioButtonT2.click();
        return this;
    }
    public RadioButtonObjects buttonCheckClickT2() throws InterruptedException {
        buttonCheckT2.click();
        return this;
    }
    public RadioButtonObjects zeroToFiveRadioButton(){
    	zeroToFiveRadioButton.click();
        return this;
    }
    public RadioButtonObjects fiveToFifteenRadioButton(){
    	fiveToFifteenRadioButton.click();
        return this;
    }
    public RadioButtonObjects fifteenToFiftyRadioButton(){
    	fifteenToFiftyRadioButton.click();
        return this;
    }
    public WebElement getMessageAfterClickedT2() {
        return messageAfterClickedT2;
    }
	public RadioButtonObjects initElements(RemoteWebDriver wb){
        maleRadioButtonT1=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input"));
        femaleRadioButtonT1=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input"));
        buttonCheckT1=wb.findElement(By.id("buttoncheck"));
        messageAfterClickedT1=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]"));
        
        maleRadioButtonT2=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input"));
        femaleRadioButtonT2=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[2]/input"));
        zeroToFiveRadioButton=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[1]/input"));
        fiveToFifteenRadioButton=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[2]/input"));
        fifteenToFiftyRadioButton=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[3]/input"));
        messageAfterClickedT2=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]"));
        buttonCheckT2=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button[1]"));
        return this;
    }
}
