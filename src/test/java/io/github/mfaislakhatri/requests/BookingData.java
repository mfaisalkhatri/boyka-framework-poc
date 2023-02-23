package io.github.mfaislakhatri.requests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookingData {
    private String       additionalneeds;
    private BookingDates bookingdates;
    private boolean      depositpaid;
    private String       firstname;
    private String       lastname;
    private int          totalprice;
}