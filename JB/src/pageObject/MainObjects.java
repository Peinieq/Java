package pageObject;


import org.openqa.selenium.remote.RemoteWebDriver;

public class MainObjects {
    private final String url="http://www.seleniumeasy.com";
    protected RemoteWebDriver wb;
    public MainObjects() {
    	
    }
    public MainObjects(RemoteWebDriver wb) {
        this.wb = wb;
    }

    public MainObjects openViaUrl(){
        wb.get(this.url);
        return this;
    }
    
}
