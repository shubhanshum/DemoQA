package com.demoqa.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class RunnerTest {

	protected static 
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	@Parameters({ "browserName","url" })
    @BeforeClass
    public void Setup(String browserName,String url){
		DesiredCapabilities caps=null;
		if (browserName.equalsIgnoreCase("chrome")) {
			caps=new DesiredCapabilities();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headed");
			chromeOptions.addArguments("--ignore-ssl-errors=yes");
			chromeOptions.addArguments("--ignore-certificate-errors");
			caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			caps.setPlatform(Platform.LINUX);
			caps.setCapability("browserName", "chrome");
			caps.acceptInsecureCerts();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			try {
				threadLocalDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
				System.out.println("Started chrome browser");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			//threadLocalDriver.set(new ChromeDriver(chromeOptions));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			caps=new DesiredCapabilities();
			FirefoxOptions firefoxOptions=new FirefoxOptions();
			firefoxOptions.addArguments("-headless");
			firefoxOptions.addArguments("--ignore-ssl-errors=yes");
			firefoxOptions.addArguments("--ignore-certificate-errors");
			caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
			caps.setPlatform(Platform.LINUX);
			caps.setCapability("browserName", "firefox");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			try {
				threadLocalDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
				System.out.println("Started firefox browser");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			//threadLocalDriver.set(new FirefoxDriver(firefoxOptions));
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			caps=new DesiredCapabilities();
			EdgeOptions edgeOptions=new EdgeOptions();
			edgeOptions.addArguments("--headless");
			edgeOptions.addArguments("--ignore-ssl-errors=yes");
			edgeOptions.addArguments("--ignore-certificate-errors");
			caps.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
			caps.setPlatform(Platform.LINUX);
			caps.setCapability("browserName", "edge");
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
			try {
				threadLocalDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
				System.out.println("Started edge browser");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			//threadLocalDriver.set(new EdgeDriver(edgeOptions));
		}
		else {
			System.out.println("Browser not specified");
		}
        
        getDriver().get(url);
        //getDriver().manage().window().maximize();
        getDriver().manage().window().setSize(new Dimension(2024, 880));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    @AfterClass
    public void tearDown(){
        getDriver().quit();
        threadLocalDriver.remove();
    }
}
