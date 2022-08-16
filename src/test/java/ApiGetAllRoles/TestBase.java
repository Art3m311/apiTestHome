package ApiGetAllRoles;

import PojoClasses.ReqAuthBody;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class TestBase {
    public String cookies;

    @BeforeTest
    public void login() {
        System.out.println("\nLogin\n");
        String authUrl = "https://api.c2mnext-rc.k2.env.timo.group/api/v2/Auth/Login";
        ReqAuthBody reqAuthBody = new ReqAuthBody();
        cookies = given()
                .body(reqAuthBody)
                .when()
                .contentType(ContentType.JSON)
                .post(authUrl)
                .then().log().all()
                .extract().header("Set-cookie");
        System.out.println("My taken cookies: " + cookies);
    }

    @AfterTest
    public void logout() {
        System.out.println("\nLogout\n");
        String logoutUrl = "https://api.c2mnext-rc.k2.env.timo.group/api/v2/Auth/Logout";
        given()
                .cookie(cookies)
                .when()
                .contentType(ContentType.JSON)
                .post(logoutUrl)
                .then().log().all();
    }
}
