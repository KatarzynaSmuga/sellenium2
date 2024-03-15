package tests;

import Base.BaseTest;
import Pages.ContactPage;
import Pages.MainPage;
import Pages.SuccessfullMessagePage;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class FillFormAdvanceTest extends BaseTest
{
    private Logger log = LoggerFactory.getLogger(FillFormBasicTest.class);
    MainPage mainPage;
    ContactPage contactPage;
    SuccessfullMessagePage successfullMessagePage;


    @Test
//    @ParameterizedTest
//    @CsvFileSource(resources = "/browsers.csv")
    void fillFormBasicScenario() // przekazujemy wartość jako parametr we wszystkich metodach
    {
        mainPage = new MainPage(driver);
        contactPage = new ContactPage(driver);
        successfullMessagePage = new SuccessfullMessagePage(driver);

//        Krok 1 - kliknąć contact us na MailnPage
        mainPage.clickContactLink();
//        Krok 2 - uzupełnić formularz na ContactPage
        contactPage.selectOptionFromDropdownList("Webmaster");
        contactPage.inputEmailAdress("mail@mail.com");
        contactPage.inputOrderNumber("123456789");
        contactPage.inputMessage("""
                linia No 1
                linia No2
                koniec
                ®""");
        contactPage.inputFile("C:\\log.txt");
        contactPage.clickSendButton();
//        Krok 3 - Sprawdzić poprawność wysłania wiadomości
        assertThat(successfullMessagePage.getSuccessMessageTxt()).isEqualTo(expectedMessage);
        log.info("Test koniec");
    }

}