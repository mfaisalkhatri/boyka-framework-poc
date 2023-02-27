package io.github.mfaislakhatri.api.requests;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PartialBookingData {
    private String firstname;
    private int    totalprice;
}
