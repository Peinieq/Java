package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BootstrapDownloadProgressObjects extends MainObjects{
	private WebElement buttonDownload;
	private WebElement feedbackClick;
	private WebElement feedbackCircle;
	
	public final String url="/test/bootstrap-download-progress-demo.html";
    protected RemoteWebDriver wb;
    
    public BootstrapDownloadProgressObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }
    public WebElement getButtonDownload() {
    	return buttonDownload;
    }
    public WebElement getFeedback() {
    	return feedbackClick;
    }
    public WebElement getFeedbackCircle() {
    	return feedbackCircle;
    }
    public BootstrapDownloadProgressObjects initElements(RemoteWebDriver wb) {
    	buttonDownload=wb.findElement(By.xpath("//*[@id=\"cricle-btn\"]"));
    	feedbackClick=wb.findElement(By.xpath("//*[@id=\"cricle-btn\"]"));
    	feedbackCircle=wb.findElement(By.xpath("//*[@id=\"circle\"]"));
    	return this;
    }
}
