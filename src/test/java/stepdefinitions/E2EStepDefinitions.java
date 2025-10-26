package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;
import utilities.Driver;

import static utilities.ObjectMapperUtils.getJsonNode;

public class E2EStepDefinitions {

    AllPages pages = new AllPages();

    @Given("user goes to url {string}")
    public void userGoesToUrl(String url) {
        Driver.getDriver().get(url);
    }

    @When("user signs in")
    public void userSignsIn() {
        pages
                .getSignInPage()
                .enterEmail(getJsonNode("credentials").get("email").asText())
                .enterPassword(getJsonNode("credentials").get("password").asText())
                .clickSubmit();
    }


    @When("user fills the form")
    public void userFillsTheForm() {

    }

    @Then("asserts the added contact")
    public void assertsTheAddedContact() {

    }

    @And("close the browser")
    public void closeTheBrowser() {
        Driver.closeDriver();
    }
}


