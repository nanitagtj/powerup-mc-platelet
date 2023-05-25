package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NameCouldNotBeEmptyException;

public class Constants {

    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "something is going bad";
    public static final String DISH_CREATED_MESSAGE = "Dish created successfully";
    public static final String DISH_UPDATED_MESSAGE = "Dish updated successfully";
    public static final String USER_FOUND = "User found";

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final Long CLIENT_ROLE_ID = 1L;
    public static final Long EMPLOYEE_ROLE_ID = 2L;
    public static final Long PROVIDER_ROLE_ID = 3L;
    public static final int MAX_PAGE_SIZE = 2;
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String DISH_ALREADY_EXISTS_MESSAGE = "Dish already exists";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String RESTAURANT_CREATED_MESSAGE = "Restaurant created successfully";
    public static final String RESTAURANT_DELETED_MESSAGE = "Restaurant deleted successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String NAME_COULD_NOT_BE_EMPTY = "Name could not be empty";
    public static final String NIT_MUST_BE_NUMERIC = "Nit must be numeric";
    public static final String RESTAURANT_ALREADY_EXISTS_MESSAGE = "Restaurant already exists";
    public static final String SWAGGER_TITLE_MESSAGE = "Restaurant API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "Restaurant microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}
