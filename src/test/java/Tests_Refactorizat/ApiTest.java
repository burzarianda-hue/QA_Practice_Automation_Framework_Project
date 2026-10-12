package Tests_Refactorizat;

import com.aventstack.chaintest.plugins.ChainTestListener;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Listeners(ChainTestListener.class)
public class ApiTest {

    @Test
    public void createPetTest() {

        String petData = """
                {
                    "id": 12345,
                    "name": "QA Test Dog",
                    "photoUrls": [],
                    "tags": [],
                    "status": "available"
                }
                """;

        Response response = given()
                .header("Content-Type", "application/json")
                .body(petData)
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        Assert.assertTrue(
                response.getStatusCode() == 200
                        || response.getStatusCode() == 201,
                "Verificarea creării animalului a eșuat"
        );

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "QA Test Dog",
                "Numele animalului din răspuns nu corespunde"
        );

        Assert.assertEquals(
                response.jsonPath().getString("status"),
                "available",
                "Statusul animalului din răspuns nu corespunde"
        );
    }
}
