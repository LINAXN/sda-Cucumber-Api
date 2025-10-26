package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class CLSignInPage {

    private By email = By.id("email");
    private By password = By.id("password");
    private By submit = By.id("submit");

    public CLSignInPage enterEmail(String email) {
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    public CLSignInPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public void clickSubmit() {
        Driver.getDriver().findElement(submit).click();
    }


}
