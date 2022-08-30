package ServiceImplementation;

import io.restassured.builder.RequestSpecBuilder;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Service {
RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    public RequestSpecBuilder setRequestBaseURL(String Url){
        return requestSpecBuilder.setBaseUri(Url);
    }

//    public Map<String, ?> setBodyParams(String paramKeys ,  String value){
//        Map<String, ?> queryParameters  = new HashMap();
//        queryParameters.put(paramKeys,)
//    }

    public RequestSpecBuilder addServiceResources(String values){
      return  requestSpecBuilder.setBasePath(values);
    }

    public void hitTheEndPointWithFormedRequest(RequestSpecBuilder requestBuilder){
            given().log().all().spec(requestBuilder.build()).get().then().log().all();
    }

}
