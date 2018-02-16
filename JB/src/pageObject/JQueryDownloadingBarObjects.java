package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JQueryDownloadingBarObjects {
	private WebElement startDownload;
	private WebElement cancelDownload;
	private WebElement closeDownload;
	private WebElement downloadEndValidation;
	private WebElement cancelValidation;
	
	private final String url="http://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html";
    protected RemoteWebDriver wb;

    public JQueryDownloadingBarObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }
    public JQueryDownloadingBarObjects openViaUrl() {
    	wb.get(this.url);
    	return this;
    }
    public JQueryDownloadingBarObjects startDownloadClick() {
    	startDownload.click();
    	cancelDownload=wb.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
    	return this;
    }
    public JQueryDownloadingBarObjects cancelDownloadClick() {
    	cancelDownload.click();
    	return this;
    }
    public JQueryDownloadingBarObjects closeDownloadClick() {
    	closeDownload.click();
    	return this;
    }
    public WebElement getDownloadEndValidation() {
    	closeDownload=wb.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
    	return downloadEndValidation;
    }
    public WebElement getCancelValidation() {
    	return cancelValidation;
    }
    public JQueryDownloadingBarObjects initElements(RemoteWebDriver wb){
    	startDownload=wb.findElement(By.xpath("//*[@id=\"downloadButton\"]"));
    	downloadEndValidation=wb.findElement(By.xpath("//*[@id=\"dialog\"]/div[1]"));
    	cancelValidation=wb.findElement(By.xpath("/html/body/div[3]"));
    	return this;
    }
}
