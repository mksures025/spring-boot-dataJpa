package com.te.cms.controller;

import com.te.cms.dto.LoginDTO;
import com.te.cms.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/public")
public class AppUserController {

    private final AuthenticationManager authenticationManager;

    public ResponseEntity<SuccessResponse> login(@RequestBody LoginDTO loginDTO){

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserName(),loginDTO.getPassword()));
        return null;
    }
}
