package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;

	public baseClass() {

		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\ADMIN\\eclipse-workspace\\AAK_Automation_Testing\\src\\test\\java\\properties\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}

	public static void openBrowser() throws InterruptedException {

		String browser = prop.getProperty("browsername");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser == "Edge") {
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\edgeDriver\\msedgedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20000));

		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);

	}

	public static void screenshots(String filename) {
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(
					"C:\\Users\\ADMIN\\eclipse-workspace\\AAK_Automation_Testing\\src\\test\\java\\screenshots\\screenshots"
							+ filename + ".jpg"));
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
