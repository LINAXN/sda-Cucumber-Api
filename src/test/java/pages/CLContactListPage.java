package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class CLContactListPage {

    private By addContact = By.id("add-contact");


    public CLAddContactPage clickAddContact() {
        Driver.getDriver().findElement(addContact).click();
        return new CLAddContactPage();


}}
