package org.api.utils;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.config;
import static io.restassured.config.SSLConfig.sslConfig;


public abstract class TestBase {

    private static final Logger LOG = LoggerFactory.getLogger(TestBase.class);
    protected static String apiBaseUrl;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeClass(alwaysRun = true)
    public static void init() {

        RestAssured.defaultParser = Parser.JSON;
        String testEnv = System.getProperty("testEnv", "test");
        LOG.debug("user given test env as===" + testEnv + "===");

        switch (testEnv.toLowerCase()) {
            case "test":
                apiBaseUrl = "https://reqres.in";
                break;
        }

        RestAssured.baseURI = apiBaseUrl;
        LOG.info("RestAssured BaseURI : " + RestAssured.baseURI);

        RestAssured.config = config()
                .sslConfig(sslConfig()
                        .allowAllHostnames());
    }
}
