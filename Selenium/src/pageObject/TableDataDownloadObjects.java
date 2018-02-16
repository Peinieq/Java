package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TableDataDownloadObjects extends MainObjects{
	private WebElement sortingName;
	private WebElement sortingNameValidation;
	private WebElement sortingPosition;
	private WebElement sortingPositionValidation;
	private WebElement sortingOffice;
	private WebElement sortingOfficeValidation;
	private WebElement sortingAge;
	private WebElement sortingAgeValidation;
	private WebElement sortingStartDate;
	private WebElement sortingStartDateValidation;
	private WebElement sortingSalary;
	private WebElement sortingSalaryValidation;
	private WebElement enterSearch;
	private WebElement enterSearchValidation;
	private WebElement previousButton;
	private WebElement firstButton;
	private WebElement secondButton;
	private WebElement thirdButton;
	private WebElement fourthButton;
	private WebElement nextButton;
	private WebElement copyButton;
	private WebElement csvButton;
	private WebElement excelButton;
	private WebElement pdfButton;
	private WebElement printButton;
	
	public final String url="/test/table-data-download-demo.html";
    protected RemoteWebDriver wb;

    public TableDataDownloadObjects(RemoteWebDriver wb) {
    	this.wb=wb;
    }

    //NAME
    public TableDataDownloadObjects sortingNameClick() {
    	sortingName.click();
    	return this;
    }
    public WebElement getSortingNameValidation() {
    	return sortingNameValidation;
    }
    //POSITION
    public TableDataDownloadObjects sortingPositionClick() {
    	sortingPosition.click();
    	return this;
    }
    public WebElement getSortingPositionValidation() {
    	return sortingPositionValidation;
    }
    //OFFICE
    public TableDataDownloadObjects sortingOfficeClick() {
    	sortingOffice.click();
    	return this;
    }
    public WebElement getSortingOfficeValidation() {
    	return sortingOfficeValidation;
    }
    //AGE
    public TableDataDownloadObjects sortingAgeClick() {
    	sortingAge.click();
    	return this;
    }
    public WebElement getSortingAgeValidation() {
    	return sortingAgeValidation;
    }
    //START DATE
    public TableDataDownloadObjects sortingStartDateClick() {
    	sortingStartDate.click();
    	return this;
    }
    public WebElement getSortingStartDateValidation() {
    	return sortingStartDateValidation;
    }
    //SALARY
    public TableDataDownloadObjects sortingSalaryClick() {
    	sortingSalary.click();
    	return this;
    }
    public WebElement getSortingSalaryValidation() {
    	return sortingSalaryValidation;
    }
    //SEARCH
    public TableDataDownloadObjects enterSearchEnter() {
    	enterSearch.sendKeys("ass");
    	return this;
    }
    public WebElement getEnterSearchValidation() {
    	return enterSearchValidation;
    }
    //MOVEMENT BUTTONS
    public TableDataDownloadObjects previousButtonClick() {
    	previousButton.click();
    	return this;
    }
    public TableDataDownloadObjects firstButtonClick() {
    	firstButton.click();
    	return this;
    }
    public TableDataDownloadObjects secondButtonClick() {
    	secondButton.click();
    	return this;
    }
    public TableDataDownloadObjects thirdButtonClick() {
    	thirdButton.click();
    	return this;
    }
    public TableDataDownloadObjects fourthButtonClick() {
    	fourthButton.click();
    	return this;
    }
    public TableDataDownloadObjects nextButtonClick() {
    	nextButton.click();
    	return this;
    }
    public TableDataDownloadObjects singleInitElement(RemoteWebDriver wb) {
    	previousButton=wb.findElement(By.xpath("//*[@id=\"example_previous\"]"));
    	return this;
    }
    public TableDataDownloadObjects copyButtonClick() {
    	copyButton.click();
    	return this;
    }
    public TableDataDownloadObjects csvButtonClick() {
    	csvButton.click();
    	return this;
    }
    public TableDataDownloadObjects excelButtonClick() {
    	excelButton.click();
    	return this;
    }
    public TableDataDownloadObjects pdfButtonClick() {
    	pdfButton.click();
    	return this;
    }
    public TableDataDownloadObjects printButtonClick() {
    	printButton.click();
    	return this;
    }
    public TableDataDownloadObjects initElements(RemoteWebDriver wb){
    	sortingName=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[1]"));
    	sortingNameValidation=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[1]"));
    	sortingPosition=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[2]"));
    	sortingPositionValidation=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[2]"));
    	sortingOffice=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[3]"));
    	sortingOfficeValidation=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[3]"));
    	sortingAge=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[4]"));
    	sortingAgeValidation=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[4]"));
    	sortingStartDate=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[5]"));
    	sortingStartDateValidation=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[5]"));
    	sortingSalary=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[6]"));
    	sortingSalaryValidation=wb.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[6]"));
    	enterSearch=wb.findElement(By.xpath("//*[@id=\"example_filter\"]/label/input"));
    	enterSearchValidation=wb.findElement(By.xpath("//*[@id=\"example_info\"]"));
    	//previousButton=wb.findElement(By.xpath("//*[@id=\"example_previous\"]"));
    	firstButton=wb.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[1]"));
    	secondButton=wb.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[2]"));
    	thirdButton=wb.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[3]"));
    	fourthButton=wb.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[4]"));
    	nextButton=wb.findElement(By.xpath("//*[@id=\"example_next\"]"));
    	copyButton=wb.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/a[1]"));
    	csvButton=wb.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/a[2]"));
    	excelButton=wb.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/a[3]"));
    	pdfButton=wb.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/a[4]"));
    	printButton=wb.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[1]/a[5]"));

    	return this;
    }
}
