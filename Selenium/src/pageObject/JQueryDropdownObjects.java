package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class JQueryDropdownObjects extends MainObjects{
	private WebElement selectCountry1;
	private WebElement selectCountry2;
	private WebElement selectState1;
	private WebElement selectState2;
	private WebElement selectOutTerritories1;
	private WebElement selectOutTerritories2;
	private WebElement selectFile;
	
	public final String url="/test/jquery-dropdown-search-demo.html";
    protected RemoteWebDriver wb;
    
    public JQueryDropdownObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }

    public JQueryDropdownObjects selectCountryClick() {
    	selectCountry1.click();
    	selectCountry2=wb.findElement(By.xpath("//*[@id=\"select2-country-results\"]/li[4]"));
    	return this;
    }
    public JQueryDropdownObjects selectCountrySelect() {
    	selectCountry2.click();
    	return this;
    }
    public JQueryDropdownObjects selectStateClick() {
    	selectState1.click();
    	//selectState2=wb.findElement(By.xpath("//*[@id=\"select2-89z4-result-3xdj-AZ\"]"));
    	return this;
    }
    public JQueryDropdownObjects selectStateSelect() {
    	selectState2.click();
    	return this;
    }
    public JQueryDropdownObjects selectOutTerritoriesClick(RemoteWebDriver wb) {
    	selectOutTerritories1.click();
    	selectOutTerritories2=wb.findElement(By.xpath("//*[@id=\"select2-nnab-result-w6tj-PR\"]"));
    	return this;
    }
    public JQueryDropdownObjects selectOutTerritoriesSelect() {
    	selectOutTerritories2.click();
    	return this;
    }
    public JQueryDropdownObjects selectFileSelect() {
    	Select Files = new Select(selectFile);
    	Files.selectByVisibleText("C");
    	return this;
    }
    public JQueryDropdownObjects initElements(RemoteWebDriver wb) {
    	selectCountry1=wb.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/span/span[1]/span"));
    	
    	//selectState1=wb.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span"));
    	
    	selectOutTerritories1=wb.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div[2]/span/span[1]/span/span[2]"));
    	
    	selectFile=wb.findElement(By.xpath("//*[@id=\"files\"]"));
    	
    	return this;
    }
}
