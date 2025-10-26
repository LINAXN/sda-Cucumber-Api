package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class CLAddContactPage {

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By phone = By.id("phone");
    private By street1 = By.id("street1");
    private By street2 = By.id("street2");
    private By city = By.id("city");
    private By stateProvince = By.id("stateProvince");
    private By postalCode = By.id("postalCode");
    private By country = By.id("country");
    private By submit = By.id("submit");


    public CLAddContactPage enterFirstName(String firstName) {
        Driver.getDriver().findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public CLAddContactPage enterLastName(String lastName) {
        Driver.getDriver().findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public CLAddContactPage enterEmail(String email) {
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    public CLAddContactPage enterPhone(String phone) {
        Driver.getDriver().findElement(this.phone).sendKeys(phone);
        return this;
    }

    public CLAddContactPage enterStreet1(String street1) {
        Driver.getDriver().findElement(this.street1).sendKeys(street1);
        return this;
    }

    public CLAddContactPage enterStreet2(String street2) {
        Driver.getDriver().findElement(this.street2).sendKeys(street2);
        return this;
    }

    public CLAddContactPage enterCity(String city) {
        Driver.getDriver().findElement(this.city).sendKeys(city);
        return this;
    }

    public CLAddContactPage enterStateProvince(String stateProvince) {
        Driver.getDriver().findElement(this.stateProvince).sendKeys(stateProvince);
        return this;
    }

    public CLAddContactPage enterPostalCode(String postalCode) {
        Driver.getDriver().findElement(this.postalCode).sendKeys(postalCode);
        return this;
    }

    public CLAddContactPage enterCountry(String country) {
        Driver.getDriver().findElement(this.country).sendKeys(country);
        return this;
    }

    public void clickSubmit() {
        Driver.getDriver().findElement(submit).click();
    }


}
