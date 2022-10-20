package components;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Request {

    private static Request instance;

    public static Request getInstance() {
        if (Request.instance == null) {
            Request.instance = new Request();
        }
        return Request.instance;
    }

    public Response get(String path, Object... pathParams) {
        return given().get(path, pathParams);
    }
}
