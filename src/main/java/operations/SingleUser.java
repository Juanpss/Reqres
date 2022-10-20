package operations;

import components.Request;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utils.JSONConverter;

public class SingleUser {

    private final Request request;
    private final JSONConverter jsonConverter;

    public SingleUser() {
        this.request = Request.getInstance();
        this.jsonConverter = new JSONConverter();
    }

    public JSONObject getTestDataJSONObject() {
        return (JSONObject) ((JSONObject) jsonConverter
                .getObjectFromJSON("src/main/resources/test-data/api-test-data.json"))
                .get("reqres");
    }

    @Step("Getting endpoint response for single user")
    public Response getSingleUserResponse(int userId) {
        JSONObject testData = getTestDataJSONObject();
        return this.request.get(
                ""+(String) ((JSONObject) testData.get("singleUser")).get("path")+""+userId+""
        );
    }


    @Step("Verifying response status code")
    public boolean isExpectedStatusCode(Response response, int statusCode) {
        return response.getStatusCode() == statusCode;
    }

    @Step("Verifying response property value corresponds to the expected Class")
    public boolean isResponsePropertyValueOfTheExpectedClass(Response response, String property, Class<?> expectedClass) {
        JsonPath jsonPath = response.jsonPath();
        return expectedClass.isInstance(jsonPath.get("data."+property+""));
    }
}
