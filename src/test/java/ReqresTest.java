import io.qameta.allure.*;
import org.apache.logging.log4j.*;
import org.testng.annotations.*;
import operations.SingleUser;
import io.restassured.response.Response;
import org.json.simple.JSONObject;


import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class ReqresTest {

    private final Logger logger = LogManager.getLogger(ReqresTest.class);
    private final SingleUser singleUser = new SingleUser();

    @BeforeClass
    void setUp() {
        JSONObject testData = singleUser.getTestDataJSONObject();
        baseURI = (String) testData.get("baseUri");
    }

    @Test(description = "Verifying GET response from single user endpoint")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify status code and properties for GET response from single user endpoint")
    @Parameters({"userId"})
    void verifyGetSingleUserResponse(int userId) {
        logger.info("Getting endpoint response for user with id: "+userId+"");
        Response response = singleUser.getSingleUserResponse(userId);
        String[] responseProperties = {"id", "email", "first_name", "last_name", "avatar"};
        logger.info("Verifying response status code is 200");
        assertTrue(singleUser.isExpectedStatusCode(response, 200),
                "Expected 200 status code but got "+response.getStatusCode()+" status code");
        for (String property: responseProperties) {
            Class<?> expectedClass = property.equals("id") ? Integer.class : String.class;
            logger.info("Verifying data."+property+" is an instance of "+expectedClass+"");
            assertTrue(singleUser.isResponsePropertyValueOfTheExpectedClass(response, property, expectedClass),
                    "data."+property+" is not an instance of "+expectedClass+"");
        }
    }
}
