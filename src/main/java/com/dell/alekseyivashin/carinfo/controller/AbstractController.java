package com.dell.alekseyivashin.carinfo.controller;

import org.springframework.http.ResponseEntity;

public class AbstractController {
    protected ResponseEntity nonNullBodyOrError(Object body) {
        if (body != null) {
            return ResponseEntity.ok(body);
        }
        return ResponseEntity.badRequest().build();
    }
}
