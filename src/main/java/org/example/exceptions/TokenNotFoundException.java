package org.example.exceptions;

import org.example.modals.response.common.ErrorResponse;

public class TokenNotFoundException extends RuntimeException {

    public TokenNotFoundException(ErrorResponse errorResponse, int statusCode){
        super(errorResponse.getMessage() + "status code " + statusCode);
    }
}
