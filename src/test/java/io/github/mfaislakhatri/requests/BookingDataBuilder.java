package io.github.mfaislakhatri.requests;

import net.datafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class BookingDataBuilder {
    public BookingData bookingDataBuilder () {
        final var faker = Faker.instance ();
        final var formatter = new SimpleDateFormat("YYYY-MM-dd");
        return BookingData.builder ()
                .firstname (faker.name ()
                        .firstName ())
                .lastname (faker.name ()
                        .lastName ())
                .totalprice (faker.number ()
                        .numberBetween (1, 2000))
                .depositpaid (true)
                .bookingdates (BookingDates.builder ()
                        .checkin (formatter.format (faker.date ()
                                .past (20, TimeUnit.DAYS)))
                        .checkout (formatter.format (faker.date ()
                                .future (5, TimeUnit.DAYS)))
                        .build ())
                .additionalneeds ("Breakfast")
                .build ();
    }

    public PartialBookingData partialBookingBuilder () {
        final var faker = Faker.instance ();
        return PartialBookingData.builder ()
                .firstname (faker.name ()
                        .firstName ())
                .totalprice (faker.number ()
                        .numberBetween (100, 5000))
                .build ();
    }
}