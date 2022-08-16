package ApiGetAllRoles;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllRolesTest extends TestBase {
    public String rolesUrl = "https://api.c2mnext-rc.k2.env.timo.group/api/v2/Dictionary/GetRoles";
    public int expectedCode = 200;

    @Test(description = "Проверка кода ответа 200")
    public void getAllRoles_SC() {
        System.out.println("\n" + cookies + "\n");
        int actualCode = given()
                            .cookie(cookies)
                            .when()
                            .contentType(ContentType.JSON)
                            .post(rolesUrl)
                            .then().log().all()
                            .extract().statusCode();
        Assert.assertEquals(expectedCode, actualCode, "Error status code is not 200!");
    }
}
