package firstProject.service.first_service;

import firstProject.constants.FirstProjectConstants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class SpecificPetApiTest {
    private RequestSpecification givenRequest() {
        return RestAssured.given()
                .baseUri(FirstProjectConstants.BASE_URL_FIRST_PROJECT_SERVICE)
                .header(HttpHeaders.ACCEPT, FirstProjectConstants.VALID_ACCEPT);
    }

    private String petEndpointSet(String validId) {
        return String.format(FirstProjectConstants.GET_SPECIFIC_PET_ENDPOINT, validId);
    }

    @Test
    @DisplayName("Teste de Contrato")
    void shouldReturnSuccessValidatingSchema() {
        givenRequest().when()
                .get(petEndpointSet(FirstProjectConstants.VALID_ID))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath(FirstProjectConstants.GET_SPECIFIC_PET_SCHEMA));
    }

    @Test
    void shouldReturnSuccessWhenThereIsAValidId() {
        Response response = givenRequest().when()
                .get(petEndpointSet(FirstProjectConstants.VALID_ID))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat().body(FirstProjectConstants.FIELD_RESPONSE_SPECIFIC_PET_NAME, containsString(FirstProjectConstants.MESSAGE_RESPONSE_SPECIFIC_PET_NAME), FirstProjectConstants.FIELD_RESPONSE_SPECIFIC_PET_STATUS, containsString(FirstProjectConstants.MESSAGE_RESPONSE_SPECIFIC_PET_STATUS))
                .extract()
                .response();
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }

    @Test
    void shouldReturnNotFoundWhenThereIsAInvalidId() {
        Response response = givenRequest().when()
                .get(petEndpointSet(FirstProjectConstants.NONEXISTENT_ID))
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .response();
        System.out.println(response.statusCode());
    }

    @Test
    void shouldReturnNotFoundWhenThereIsAStringAsId() {
        Response response = givenRequest().when()
                .get(petEndpointSet(FirstProjectConstants.INVALID_ID))
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .response();
        System.out.println(response.statusCode());
    }

    @Test
    void shouldReturnMethodNotAllowedWhenSendRequestEqualsToPut() {
        Response response = givenRequest().when()
                .put(petEndpointSet(FirstProjectConstants.VALID_ID))
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
                .extract()
                .response();
        System.out.println(response.statusCode());
    }
}
