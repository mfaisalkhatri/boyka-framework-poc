package io.github.mfaislakhatri.api.requests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Tokencreds {
    private String password;
    private String username;
}