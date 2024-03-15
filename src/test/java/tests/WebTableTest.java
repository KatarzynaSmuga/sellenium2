package tests;

import Base.BaseTest;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.Wait;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.time.Duration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTableTest extends BaseTest {

    private Logger log = LoggerFactory.getLogger(WebTableTest.class);
    @Test

    public void webTableVerification() {

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)) //max 30sek

                .pollingEvery(Duration.ofSeconds(5)) //Sprawdzaj co 5sek

                .ignoring(NoSuchElementException.class);

//Policz ile jest wierszy w tabeli

        List<WebElement> table = driver.findElements(By.cssSelector("#countries tbody tr"));

        int size = table.size();

        int countriesCount = size - 1;

        log.info("Number od countries = " + countriesCount);
        assertThat(countriesCount).isEqualTo(196);

//Zaznacz checkboxa obok Polski

        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".hasVisited[type='checkbox']"));

        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxes.get(139)));

        log.info("Checkbox - before click -> Selected: " + checkbox.isSelected());

        log.info("Checkbox - before click -> Displayed: " + checkbox.isDisplayed());

        log.info("Checkbox - before click -> Enabled: " + checkbox.isEnabled());

//Scroll to element

        new Actions(driver)

                .scrollToElement(checkboxes.get(145))

                .perform();

        checkbox.click();

        log.info("Click!");

        log.info("Checkbox - before click -> Selected: " + checkbox.isSelected());

        log.info("Checkbox - before click -> Displayed: " + checkbox.isDisplayed());

        log.info("Checkbox - before click -> Enabled: " + checkbox.isEnabled());

    }

}