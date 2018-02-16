package pageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class BasicSelectDropdownObject extends MainObjects{
	private WebElement selectDay;
	private WebElement dayValidation;
	private WebElement multiSelect;
	private WebElement getOneSelected;
	private WebElement getAllSelected;
	private WebElement selectedValidation;
	private WebElement ohioSelected;
	private WebElement floridaSelected;
	
	public final String url="/test/basic-select-dropdown-demo.html";
    protected RemoteWebDriver wb;
    //private Actions actions = new Actions(wb);
    
    public BasicSelectDropdownObject(RemoteWebDriver wb) {
    	this.wb=wb;
    }

    public BasicSelectDropdownObject selectDaySelect() {
    	Select Days = new Select(selectDay);
    	Days.selectByVisibleText("Saturday");
    	return this;
    }
    public WebElement getDayValidation() {
    	return dayValidation;
    }
    public BasicSelectDropdownObject selectMultiSelect() {
    	//Select States = new Select(multiSelect);
    	//States.selectByVisibleText("Ohio");
    	//States.selectByVisibleText("Florida");
    	
    	Actions actions = new Actions(wb);
    	actions.keyDown(Keys.LEFT_CONTROL)
    	.click(ohioSelected)
    	.click(floridaSelected)
    	.keyUp(Keys.LEFT_CONTROL);
    	
    	Action selectMultiple = actions.build();
    	selectMultiple.perform();
    	return this;
    }
    public WebElement getOneSelectedClick() {
    	return getOneSelected;
    }
    public WebElement getAllSelectedClick() {
    	return getAllSelected;
    }
    public WebElement getSelectedValidation() {
    	return selectedValidation;
    }
    public BasicSelectDropdownObject initElements(RemoteWebDriver wb) {
    	selectDay=wb.findElement(By.xpath("//*[@id=\"select-demo\"]"));
    	dayValidation=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]"));
    	multiSelect=wb.findElement(By.xpath("//*[@id=\"multi-select\"]"));
    	getOneSelected=wb.findElement(By.xpath("//*[@id=\"printMe\"]"));
    	getAllSelected=wb.findElement(By.xpath("//*[@id=\"printAll\"]"));
    	selectedValidation=wb.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]"));
    	ohioSelected=wb.findElement(By.xpath("//*[@id=\"multi-select\"]/option[5]"));
    	floridaSelected=wb.findElement(By.xpath("//*[@id=\"multi-select\"]/option[2]"));
    	return this;
    }
  
}
