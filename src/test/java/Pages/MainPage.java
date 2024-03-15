package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {
//    WebElement contactUsLink = driver.findElement(By.cssSelector("#contact-link a")); to linia 12 i13
//            contactUsLink.click();
//            log.info("Step 1: Contact us kliknięty.");
protected Logger log = LoggerFactory.getLogger(MainPage.class);
    @FindBy(css="#contact-link a")
    private WebElement contactUsLink;

    //operacje na polach metody
    public void clickContactLink(){
        contactUsLink.click();
        log.info("Step 1: Contact us kliknięty.");
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this); //inicjalizuje wszystkie web elementy
    }
}

