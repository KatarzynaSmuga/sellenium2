package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuccesfullMessagePage {
//    //Krok 8 Weryfikacja Succes message
//    WebElement succesMessage = driver.findElement(By.className("alert-success"));
//    String expectedMassage = "Your message has been successfully sent to our team.";
//    String actualMassage = succesMessage.getText();
//    assertThat(actualMassage).isEqualTo(expectedMassage);
//            log.info("Step 8: Weryfikacja Succes message.");

    protected Logger log = LoggerFactory.getLogger(SuccesfullMessagePage.class);
    @FindBy(className =".alert-success" )
    private WebElement successMessage;

    public SuccesfullMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    public String getSuccessMessageTxt(){
        return successMessage.getText();
    }
}
