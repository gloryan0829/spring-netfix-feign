package com.semina.feign.util;

import org.springframework.http.HttpStatus;

public interface HttpUtil extends HttpStatusGroup {

    default boolean isUnAuthErrorCode(HttpStatus httpStatus) {
        return isUnAuthErrorCode(httpStatus.value());
    }

    default boolean isUnAuthErrorCode(int value) {
        return UNAUTH_STATUS_CODES.contains(value);
    }
}
