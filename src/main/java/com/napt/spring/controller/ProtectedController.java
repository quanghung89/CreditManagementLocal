package com.napt.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by napt2017 on 4/6/2017.
 */
@RestController
@RequestMapping("protected")
public class ProtectedController {
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> getProtectedData(){
        return ResponseEntity.ok("{Success:true}");
    }
}
