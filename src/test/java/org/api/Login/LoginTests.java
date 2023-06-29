package org.api.Login;

import io.restassured.response.Response;
import org.api.testdata.datamodel.Request.User;
import org.api.utils.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;
import static org.api.reporting.ExtentTestManager.startTest;


public class LoginTests extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(LoginTests.class);


    @DataProvider(name = "validUserData")
    public Object[][] createValidUserData() {
        return new Object[][]{
                {new User("eve.holt@reqres.in", "cityslicka")}

        };
    }

    @DataProvider(name = "invalidUserData")
    public Object[][] createInvalidUserData() {
        return new Object[][]{
                {new User("peter@klaven", "casd")},
                {new User("peter@klaven", "")}
        };
    }


    /**
     * Test verifies Login can be successful using Valid User Credentials
     *
     * @param userCredentials
     */
    @Test(dataProvider = "validUserData")
    public void LoginWithValidUserTest(User userCredentials, Method method) {
        startTest(method.getName(), method.getName().replace("_", " "));
        Response response = given()
                .relaxedHTTPSValidation()
                .contentType("application/json;charset=UTF-8")
                .body(userCredentials)
                .log().all()
                .when()
                .post("/api/login")
                .then()
                .log().all()
                .extract()
                .response();

        Assert.assertEquals(200, response.getStatusCode(), "Response Code should be 200");

        String token = response.path("token");
        Assert.assertNotNull(token);

    }

    /**
     * Test verifies Login fails for invalid User Credentials
     *
     * @param userCredentials
     */
    @Test(dataProvider = "invalidUserData")
    public void LoginWithInValidUserTest(User userCredentials, Method method) {
        startTest(method.getName(), method.getName().replace("_", " "));
        Response response = given()
                .relaxedHTTPSValidation()
                .contentType("application/json;charset=UTF-8")
                .body(userCredentials)
                .log().all()
                .when()
                .post("/api/login")
                .then()
                .log().all()
                .extract()
                .response();

        Assert.assertEquals(400, response.getStatusCode(), "Response Code should be 400");

        String errorMessage = response.path("error");
        Assert.assertNotNull(errorMessage);

    }


}
