package io.github.mfaisalkhatri.api.requests;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PartialBookingData {
    private String firstname;
    private int    totalprice;
}
