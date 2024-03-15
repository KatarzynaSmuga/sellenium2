package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuccessfullMessagePage{
    //    //Krok 8 Weryfikacja Success message
////        log.info("Step 8: Weryfikacja Success message.");
////    //System.out.println("Test stop!");
//        log.info("Test stop!");
    private Logger log = LoggerFactory.getLogger(SuccessfullMessagePage.class);
    @FindBy(css = ".alert-success")
    private WebElement successMessage;
    public SuccessfullMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public String getSuccessMessageTxt() {
        return successMessage.getText();
    }
}