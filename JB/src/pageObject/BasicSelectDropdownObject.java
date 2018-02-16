package pageObject;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicSelectDropdownObject extends MainObjects{
	private WebElement selectDay;
	private WebElement dayValidation;
	private WebElement multiSelect;
	private WebElement getOneSelected;
	private WebElement getAllSelected;
	private WebElement selectedValidation;
	
	
	private final String url="http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    protected RemoteWebDriver wb;
    
    public BasicSelectDropdownObject(RemoteWebDriver wb) {
    	this.wb=wb;
    }
    public BasicSelectDropdownObject openViaUrl() {
    	wb.get(this.url);
    	return this;
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
    	Select States = new Select(multiSelect);
    	States.selectByVisibleText("Ohio");
    	States.selectByVisibleText("Florida");

    	return this;
    }
    public BasicSelectDropdownObject getOneSelectedClick() {
    	getOneSelected.click();
    	return this;
    }
    public BasicSelectDropdownObject getAllSelectedClick() {
    	getAllSelected.click();
    	return this;
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
    	return this;
    }
  
}
