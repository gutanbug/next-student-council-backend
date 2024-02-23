package com.dku.council.domain.oauth.exception;


import com.dku.council.global.error.exception.LocalizedMessageException;
import org.springframework.http.HttpStatus;

public class InvalidOauthClientIdException extends LocalizedMessageException {
    public InvalidOauthClientIdException(String clientId) {
        super(HttpStatus.BAD_REQUEST, "invalid.oauth-client-id: " + clientId);
    }
}
