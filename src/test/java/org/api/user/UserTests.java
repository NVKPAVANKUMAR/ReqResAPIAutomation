package org.api.user;

import io.restassured.response.Response;
import org.api.testdata.builder.UserDetailsBuilder;
import org.api.testdata.datamodel.Request.UserWithJobDetails;
import org.api.testdata.datamodel.Response.UserDataResponse;
import org.api.testdata.datamodel.Response.UserDetails;
import org.api.utils.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;
import static org.api.reporting.ExtentTestManager.startTest;

public class UserTests extends TestBase {

    private static final Logger LOG = LoggerFactory.getLogger(UserTests.class);

    /**
     * This method creates Specified user and returns user ID
     *
     * @param user_Details
     * @return userId
     */
    public static UserDetails createUser(UserWithJobDetails user_Details) {
        Response createUserResponse =

                given()
                        .relaxedHTTPSValidation()
                        .contentType("application/json;charset=UTF-8")
                        .body(user_Details)
                        .when()
                        .post(TestBase.apiBaseUrl + "/api/users")
                        .then()
                        //.log().all()
                        .statusCode(201)
                        .extract()
                        .response();

        UserDetails userDetails = createUserResponse.as(UserDetails.class);
        return userDetails;

    }

    public static UserDetails updateUser(UserDetails userdetails) {
        Response createUserResponse =

                given()
                        .relaxedHTTPSValidation()
                        .contentType("application/json;charset=UTF-8")
                        .body(userdetails)
                        .when()
                        .put(TestBase.apiBaseUrl + "/api/users/2")
                        .then()
                        //   .log().all()
                        .statusCode(200)
                        .extract()
                        .response();

        return createUserResponse.as(UserDetails.class);

    }

    public static UserDataResponse getUserDetails(UserDetails userdetails) {

        Response createUserResponse =
                given()
                        .relaxedHTTPSValidation()
                        .contentType("application/json;charset=UTF-8")

                        .when()
                        .get(TestBase.apiBaseUrl + "/api/users/2")
                        .then()
                        //  .log().all()
                        .statusCode(200)
                        .extract()
                        .response();

        return createUserResponse.as(UserDataResponse.class);

    }

    @Test
    public void createUserTest(Method method) {
        startTest(method.getName(), method.getName().replace("_", " "));
        UserWithJobDetails userResource = UserDetailsBuilder.anyUserDetails().build();
        UserDetails userDetails = createUser(userResource);
        Assert.assertNotNull(userDetails.getId());

    }

    @Test(enabled = false)
    public void updateUserTest(Method method) {
        startTest(method.getName(), method.getName().replace("_", " "));
        UserWithJobDetails userResource = UserDetailsBuilder.anyUserDetails().build();
        UserDetails userDetails = createUser(userResource);
        System.out.println(userDetails.toString());
        //Modify UserDetails
        userDetails.setName("Hello");
        userDetails.setJob("TestJob");
        UserDetails updatedUserDetails = updateUser(userDetails);

        //Check User details correctly updated
        Assert.assertEquals(userDetails.getName(), updatedUserDetails.getName());
        Assert.assertEquals(userDetails.getJob(), updatedUserDetails.getJob());


        //Check Get User details return Updated user details.
        UserDataResponse userData = getUserDetails(userDetails);
        Assert.assertEquals(userData.getData().getFirst_name(), updatedUserDetails.getName());


    }

}
