package ServiceImplementation;

import io.restassured.builder.RequestSpecBuilder;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class Service {
RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    public RequestSpecBuilder setRequestBaseURL(String Url){
        return requestSpecBuilder.setBaseUri(Url);
    }

    public RequestSpecBuilder addServiceResources(String values){
      return  requestSpecBuilder.setBasePath(values);
    }

    public String hitTheEndPointWithFormedRequest(RequestSpecBuilder requestBuilder){
        String response = given().log().all().spec(requestBuilder.build()).get().then().log().all().statusCode(200).body("page",equalTo(2)).extract().response().asString();
        getTheKeyValue(parseTheJson(response),"page");
       return response ;
    }

    public JsonPath parseTheJson(String response){
        JsonPath jsonPath = new JsonPath(response);
        return jsonPath;
    }

    public String getTheKeyValue(JsonPath jsonPath, String path){
       return jsonPath.getString("path");
    }
}
