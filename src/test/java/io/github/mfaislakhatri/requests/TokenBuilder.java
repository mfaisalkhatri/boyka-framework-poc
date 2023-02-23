package io.github.mfaislakhatri.requests;

public class TokenBuilder {
    public Tokencreds tokenBuilder () {
        return Tokencreds.builder ()
                .username ("admin")
                .password ("password123")
                .build ();
    }
}