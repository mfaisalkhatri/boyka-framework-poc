package io.github.mfaislakhatri.api.requests;

public class TokenBuilder {
    public Tokencreds tokenBuilder () {
        return Tokencreds.builder ()
                .username ("admin")
                .password ("password123")
                .build ();
    }
}