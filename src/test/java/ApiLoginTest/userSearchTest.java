package ApiLoginTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class userSearchTest {
    private final static String URl_BASE = "https://petstore.swagger.io/v2/";

    @Test (description = "Тест на получение ответа: 200 ОК")
    public void getUserByName() {
        Response response =
                given()
                        .when()
                        .get(URl_BASE + "user/Tyra123")
                        .then()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .extract().response();
        Assert.assertEquals(response.statusCode(), 200, "Code is not 200 :(");
    }

    }
