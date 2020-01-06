package com.example.jumpstart.model;

import java.io.Serializable;
//Via Java Serialization you can stream your Java object to a sequence of byte
// and restore these objects from this stream of bytes.
public class JwtResponse implements Serializable {
    public static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken(){
        return this.jwttoken;
    }
}
