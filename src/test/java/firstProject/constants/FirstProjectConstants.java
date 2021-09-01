package firstProject.constants;

public interface FirstProjectConstants {
    //region Base Url
    String BASE_URL_FIRST_PROJECT_SERVICE = "https://petstore.swagger.io";
    //endregion
    //region Headers
    String VALID_ACCEPT = "application/json";
    //endregion
    //region ID
    String VALID_ID = "1";
    String INVALID_ID = "test";
    String NONEXISTENT_ID = "4";
    //endregion
    //region Endpoints
    String GET_SPECIFIC_PET_ENDPOINT = "/v2/pet/%s";
    //endregion
    //region Schemas
    String GET_SPECIFIC_PET_SCHEMA = "schemas/firstProject/specificPetSchema.json";
    //endregion
    //region Response Specific Pet
    String FIELD_RESPONSE_SPECIFIC_PET_NAME = "name";
    String MESSAGE_RESPONSE_SPECIFIC_PET_NAME = "pet001";
    String FIELD_RESPONSE_SPECIFIC_PET_STATUS = "status";
    String MESSAGE_RESPONSE_SPECIFIC_PET_STATUS = "ok";
    //endregion
}
