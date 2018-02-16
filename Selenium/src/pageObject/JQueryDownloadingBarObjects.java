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
	
	public final String url="/test/jquery-download-progress-bar-demo.html";
    protected RemoteWebDriver wb;

    public JQueryDownloadingBarObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }

    public WebElement startDownloadClick() {
    	cancelDownload=wb.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
    	return startDownload;
    }
    public WebElement cancelDownloadClick() {
    	return cancelDownload;
    }
    public WebElement closeDownloadClick() {
    	return closeDownload;
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
