package stepdefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

import static base_urls.CLBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static utilities.ObjectMapperUtils.getJsonNode;

public class ContactsStepDefinitions {
Response response;
JsonNode payload;
static String contactid;
@When("send the get request to get all contact")
public void send_the_get_request_to_get_all_contact() {
    response= given(spec).get("/contacts");
    response.prettyPrint();
}
@Then("status code should be {int}")
public void status_code_should_be(Integer statusCode) {
response.then().statusCode(statusCode);
}
@Then("response body should be contain contact body")
public void response_body_should_be_contain_contact_body() {
    response.then()
            .body("", hasSize(greaterThan(0)));
}


    @Given("prepare payload to create contact")
    public void prepare_payload_to_create_contact() throws IOException {
payload = getJsonNode("Contact_body");
//        System.out.println(payload.toPrettyString());
    }
    @When("send post request to create contact")
    public void send_post_request_to_create_contact() {
        response=  given(spec).body(payload).post("/contacts");
        response.prettyPrint();
    }
    @Then("response body should be contain created contact")
    public void response_body_should_be_contain_created_contact() {
        response.then()
                .body(
                        "firstName", equalTo(payload.get("firstName").asText()),
                        "lastName", equalTo(payload.get("lastName").asText()),
                        "birthdate", equalTo(payload.get("birthdate").asText()),
                        "email", equalTo(payload.get("email").asText()),
                        "phone", equalTo(payload.get("phone").asText()),
                        "street1", equalTo(payload.get("street1").asText()),
                        "street2", equalTo(payload.get("street2").asText()),
                        "city", equalTo(payload.get("city").asText()),
                        "stateProvince", equalTo(payload.get("stateProvince").asText()),
                        "postalCode", equalTo(payload.get("postalCode").asText()),
                        "country", equalTo(payload.get("country").asText())

                );
        contactid = response.jsonPath().getString("_id");
        System.out.println("contactid = " + contactid);
    }

    @When("send the get request to get contact by id")
    public void send_the_get_request_to_get_contact_by_id() {
  response = given(spec).get("/contacts/"+contactid);
        System.out.println("contactid = " + contactid);
//  response.prettyPrint();
    }
    @Then("response body should contain corresponding contact")
    public void response_body_should_contain_corresponding_contact() {

    }
    @Given("prepare payload to update contact")
    public void prepare_payload_to_update_contact() {
            //https://thinking-tester-contact-list.herokuapp.com/contacts/id
            System.out.println("contactId = " + contactid);
            response = given(spec).get("/contacts/" + contactid);
            response.prettyPrint();
    }
    @When("send put request to update contact")
    public void send_put_request_to_update_contact() {
        payload = getJsonNode("contact_body_updated");
    }
    @Then("response body should contain created contact")
    public void response_body_should_contain_created_contact() {

        response = given(spec).body(payload).put("/contacts/" + contactid);
    }

}
