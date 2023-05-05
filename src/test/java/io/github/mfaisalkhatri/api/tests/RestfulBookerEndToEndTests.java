package io.github.mfaisalkhatri.api.tests;

import static com.github.wasiqb.boyka.actions.api.ApiActions.withRequest;
import static com.github.wasiqb.boyka.manager.ParallelSession.*;

import com.github.wasiqb.boyka.enums.PlatformType;
import io.github.mfaisalkhatri.api.requests.BookingData;
import io.github.mfaisalkhatri.api.requests.BookingDataBuilder;
import io.github.mfaisalkhatri.api.requests.BookingRequest;
import io.github.mfaisalkhatri.api.requests.PartialBookingData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestfulBookerEndToEndTests {

    private static final String BOOKING_ID = "bookingId";
    private BookingDataBuilder dataBuilder;
    private BookingData newBooking;

    @BeforeTest
    public void setup() {
        createSession(PlatformType.API, "test_restfulbooker");
        dataBuilder = new BookingDataBuilder();
        newBooking = dataBuilder.bookingDataBuilder();
    }

    @Test(description = "Test for creating new booking with POST request")
    public void testCreateBooking() {

        var response = withRequest(BookingRequest.createBooking(newBooking)).execute();

        response.verifyStatusCode()
                .isEqualTo(200);
        response.verifyTextField("bookingid")
                .isNotNull();
        response.verifyTextField("booking.firstname")
                .isEqualTo(newBooking.getFirstname());
        getSession().setSharedData(BOOKING_ID, response.getResponseData("bookingid"));
    }

    @Test(description = "Test for retrieving booking using GET request")
    public void testGetBooking() {
        var response = withRequest(BookingRequest.getBooking(getSession().getSharedData(BOOKING_ID))).execute();

        response.verifyStatusCode()
                .isEqualTo(200);
        response.verifyTextField("firstname")
                .isEqualTo(newBooking.getFirstname());
        response.verifyTextField("lastname")
                .isEqualTo(newBooking.getLastname());
    }

    @Test(description = "Test for Updating booking using PUT request")
    public void testUpdateBooking() {
        BookingData updateBookingData = dataBuilder.bookingDataBuilder();

        var response = withRequest(BookingRequest.updateBooking(getSession().getSharedData(BOOKING_ID), updateBookingData)).execute();
        response.verifyStatusCode()
                .isEqualTo(200);
        response.verifyTextField("firstname")
                .isEqualTo(updateBookingData.getFirstname());
        response.verifyTextField("lastname")
                .isEqualTo(updateBookingData.getLastname());
    }

    @Test(description = "Test for partial updating booking using PATCH request")
    public void testUpdatePartialBooking() {
        PartialBookingData partialBookingData = dataBuilder.partialBookingBuilder();

        var response = withRequest(BookingRequest.updatePartialBooking(getSession().getSharedData(BOOKING_ID), partialBookingData)).execute();
        response.verifyStatusCode()
                .isEqualTo(200);
        response.verifyTextField("firstname")
                .isEqualTo(partialBookingData.getFirstname());
        response.verifyIntField("totalprice")
                .isEqualTo(partialBookingData.getTotalprice());
    }

    @Test(description = "Test for Deleting a booking using DELETE request")
    public void testDeleteBooking() {

        var response = withRequest(BookingRequest.deleteBooking(getSession().getSharedData(BOOKING_ID))).execute();
        response.verifyStatusCode()
                .isEqualTo(201);
    }

    @Test(description = "Test for checking deleted booking using GET request")
    public void testDeletedBooking() {

        var response = withRequest(BookingRequest.getBooking(getSession().getSharedData(BOOKING_ID))).execute();
        response.verifyStatusCode()
                .isEqualTo(404);
    }

    @AfterTest
    public void tearDown() {
        clearSession();
    }

}
