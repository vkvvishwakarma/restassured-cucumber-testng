package stepDefinitions;

import ServiceImplementation.Service;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;

public class ApiServiceStepDefintionTest {
    RequestSpecBuilder requestSpecBuilder;
    Service service = new Service();
    @Given("user fetch the record with get url {string}")
    public void userFetchTheRecordWithGetUrl(String URL) {
        requestSpecBuilder = service.setRequestBaseURL(URL);
    }

    @When("user hit the endpoint {string} to get response for {string} number {string}")
    public void userHitTheEndpointToGetResponseForNumber(String resources, String paramKey, String paramValue) {
        requestSpecBuilder = requestSpecBuilder.addQueryParam(paramKey, paramValue);
        requestSpecBuilder = service.addServiceResources(resources);
            service.hitTheEndPointWithFormedRequest(requestSpecBuilder);
    }

    @Then("verify the response")
    public void verifyTheResponse() {
        System.out.println("need to implement");
    }


}
