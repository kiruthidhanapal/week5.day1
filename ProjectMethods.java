package week6.day6;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ProjectMethods{
public RemoteWebDriver driver;
@Parameters({"url","browserName"})
		@BeforeMethod
		public void StartBrowsers(String browserName,String url) {
		
		if (browserName.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
}else if(browserName.equals("Edge")) {
	WebDriverManager.edgedriver().setup();
	driver= new EdgeDriver();

		}
driver.manage().window().maximize();
driver.get(url);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
}