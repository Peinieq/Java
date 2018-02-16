package testJB;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.configuration.AnnotationBuilder;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import steps.FirstPageSteps;



public class RunFirstTest extends JUnitStories {
    private RemoteWebDriver wb;
	
	@BeforeStory
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erazer\\Desktop\\Selenium\\chromedriver.exe");
		wb = new ChromeDriver();
        wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(1000);
	}
	
	public RunFirstTest() {
		super();
		this.configuredEmbedder().candidateSteps().add(new FirstPageSteps());
	}
	
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("stories/run_first_test.story");
	}
}
