package com.oauth.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class SetupController {

    @GetMapping
    public ResponseEntity<?> getTest() {
        return new ResponseEntity<>("Running", HttpStatus.OK);
    }
}
