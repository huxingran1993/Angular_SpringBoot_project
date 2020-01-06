package com.example.jumpstart.controller;

import com.example.jumpstart.config.JwtTokenUtil;
import com.example.jumpstart.model.JwtRequest;
import com.example.jumpstart.model.JwtResponse;
import com.example.jumpstart.security.filters.JwtRequestFilter;
import com.example.jumpstart.services.JwtUserDetailsService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/api/authentication", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)throws Exception{
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw new Exception("User_DISABLED",e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }
    }

}
