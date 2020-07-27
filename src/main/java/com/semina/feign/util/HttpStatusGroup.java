package com.semina.feign.util;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public interface HttpStatusGroup {
    Set<Integer> UNAUTH_STATUS_CODES = Arrays.stream(new HttpStatus[]{HttpStatus.UNAUTHORIZED, HttpStatus.FORBIDDEN})
            .map(s -> s.value()).collect(Collectors.toSet());
}
