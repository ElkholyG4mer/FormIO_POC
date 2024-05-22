import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.FormPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest {
    private SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    @Description("This is a ssetup class for our test cases")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Validate that the user can create an new form from scratch")
    private void validateFormCreation(){
        new FormPage(driver).navigateLoginPage().login().navigateFormPage()
                .dragAndDropFormElements("textfield").enterFormElementAttributes();

    }

    @AfterMethod
    @Description("Close the browser after test")
    public void tearDown(){
        driver.quit();
    }
}
