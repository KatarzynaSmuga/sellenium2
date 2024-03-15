package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactPage {
//    //Krok 2 wybierz Subject Heading
//    WebElement dropdownList = driver.findElement(By.cssSelector("#id_contact"));
//    Select select = new Select(dropdownList);
//        select.selectByVisibleText("Webmaster");
//        log.info("Step 2: Subject Heading został wybrany.");
//
//    //Krok 3 wpisz email
//    WebElement emailInput = driver.findElement(By.cssSelector("#email"));
//        emailInput.sendKeys("mail@op.pl");
//        log.info("Step 3: email wpisany.");
//
//    //Krok 4 wpisz Oreder refference
//    //WebElement orderRef = driver.findElement(By.cssSelector("#id_order"));
//    WebElement orderRef = driver.findElement(By.id("id_order"));
//        orderRef.sendKeys("123567");
//        log.info("Step 4: order ref wpisany.");
//
//    //Krok 5 wpisz wiadomość
//    WebElement messageInput = driver.findElement(By.cssSelector("#message"));
//        messageInput.sendKeys("""
//                To jest pierwsza linijka tekstu,
//                to jest druga linijka
//                to jest ostatnia linijka...
//                """);
//        log.info("Step 5: Wiadomość wpisana.");
//
//    //Krok 6 dodaj plik
//    WebElement fileUpload = driver.findElement(By.id("fileUpload"));
//        fileUpload.sendKeys("C:\\Recovery.txt");
//        log.info("Step 6: Załadowano załącznik.");
//
//    //Krok 7 wysłanie formularza
//    WebElement submitMessage = driver.findElement(By.cssSelector("#submitMessage"));
//        submitMessage.click();
//        log.info("Step 7: Wysłanie formularza.");

    private Logger log = LoggerFactory.getLogger(ContactPage.class);
    @FindBy(css = "#id_contact") // Krok 2
    private WebElement dropdownList;
    @FindBy(css = "#email") // Krok 3
    private WebElement email;
    @FindBy(css = "#id_order") //Krok 4
    private WebElement idOrder;
    @FindBy(css = "#message") //Krok 5
    private WebElement message;

    @FindBy(id= "fileUpload") //Krok 6
        private WebElement fileInput;


    @FindBy(css = "#submitMessage") //Krok 7
    private WebElement buttonSendMessage;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectOptionFromDropdownList(String option) {
        Select select = new Select(dropdownList);
        select.selectByVisibleText(option);
        log.info("Step 2: Subject Heading został wybrany: " + option);
    }

    public void inputEmailAdress(String emailAdress) {
        email.sendKeys(emailAdress);
        log.info("Step 3: email wpisany: " + emailAdress);
    }

    public void inputOrderNumber(String idOrderNumber) {
        email.sendKeys(idOrderNumber);
        log.info("Step 4: order ref wpisany: " + idOrderNumber);
    }

    public void inputMessage(String messageTxt) {
        message.sendKeys(messageTxt);

        log.info("Step 5: Wiadomość wpisana.");
    }

    // krok6
    public void inputFile(String filePath) {
        fileInput.sendKeys(filePath);
//        log.info("Step 6: Załadowano załącznik.": +filePath );
    }

    // krok7
    public void clickSendButton() {
        buttonSendMessage.click();
    //        log.info("Step 7: Wysłanie formularza.");
    }
}
