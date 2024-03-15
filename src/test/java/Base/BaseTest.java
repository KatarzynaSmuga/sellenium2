package Base;

import Test.FillFormAdvanceTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseTest {
    protected final String appUrl = "http://www.automationpractice.pl/index.php";
    protected final String browserName = "chrome";
    protected final boolean headlessBrowser = false; //przełaczamy na true poza developerka
    protected WebDriver driver;
    protected Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    void setApp() {
        log.info("start test");
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //czekanie
        //otwarcie przegladarki

        //  System.out.println("start test");
        driver.get(appUrl);
    }

    @AfterEach
    void teardown() {
        driver.quit();
        //driver.close(); na odwrót mozna close i potem quite
        log.info("zamkniecie całego procesu przeglądarki");
    }


    protected WebDriver getDriver() {
        switch (this.browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--remote-allow-origins=*");//przejecie kontroli przez kod
                if (this.headlessBrowser) {///domyślnie true
                    chromeOptions.addArguments("--headless"); //wybór drivera dostepny w całej klasie
                }
                driver = new ChromeDriver(chromeOptions); //otórz z tymi opcjami powyżej

            }
            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--remote-allow-origins=*");
                if (this.headlessBrowser) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);

            }
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                options.addArguments("--start-maximized");
                options.addArguments("--remote-allow-origins=*");
                if (this.headlessBrowser) {
                    options.addArguments("--headless");
                }
                driver = new EdgeDriver(options);
            }
            default -> {
                System.out.println("Nie wspierana przegladarka");
            }
        }
        return driver;
    }
}
