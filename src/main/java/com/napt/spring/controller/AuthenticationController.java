package com.napt.spring.controller;

import com.napt.spring.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by napt2017 on 4/6/2017.
 */
@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;
    //https://www.youtube.com/watch?v=XrBdRWFLQOY

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException{
        //Perform the authentication
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        //Set authentication for context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Reload password post-authentication so we can generate token
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        Optional<String> optToken = this.tokenUtils.generateToken(userDetails);

        //Response token to client
        if(optToken.isPresent()){
            return ResponseEntity.ok(new AuthenticationResponse(optToken.get()));
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "refresh",method = RequestMethod.GET)
    public ResponseEntity<?> authenticationRequest(HttpServletRequest request){
        String token = request.getHeader(AppContant.tokenHeader);
        Optional<String> optUsername = this.tokenUtils.getUsernameFromToken(token);
        if(optUsername.isPresent()){
            SpringSecurityUser springSecurityUser = (SpringSecurityUser)this.userDetailsService.loadUserByUsername(optUsername.get());
            if(this.tokenUtils.canTokenBeRefreshed(token, springSecurityUser.getLastPasswordReset())){
                Optional<String> optRefreshToken = this.tokenUtils.refreshToken(token);
                if(optRefreshToken.isPresent()) {
                    return ResponseEntity.ok(new AuthenticationResponse(optRefreshToken.get()));
                }
            }
        }
        return ResponseEntity.badRequest().body(null);
    }
}
