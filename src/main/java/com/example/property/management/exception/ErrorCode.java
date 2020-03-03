package com.example.property.management.exception;

public interface ErrorCode {

    String SUCCESS = "0";
    String SYSTEM_EXCEPTION = "9999";

    String AUTHENTICATION_ERROR = "1001";

    String ENTITY_REPEAT = "2001";
    String RESOURCE_NOT_FOUND = "3001";

    String TENANT_REPEAT_WITH_HOUSE = "4001";

}
