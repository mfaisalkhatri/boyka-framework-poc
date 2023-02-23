package io.github.mfaislakhatri.tests;

import io.github.mfaislakhatri.requests.BookingData;
import io.github.mfaislakhatri.requests.BookingDataBuilder;
import io.github.mfaislakhatri.requests.BookingRequest;
import io.github.mfaislakhatri.requests.PartialBookingData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.github.wasiqb.boyka.actions.api.ApiActions.withRequest;

public class RestfulBookerEndToEndTests {

    private String bookingId;
    private BookingDataBuilder dataBuilder;
    private BookingData newBooking;


    @BeforeTest
    public void setup() {
        dataBuilder = new BookingDataBuilder();
        newBooking = dataBuilder.bookingDataBuilder();
    }

    @Test(description = "Test for creating new booking with POST request")
    public void testCreateBooking() {

        var response = withRequest(BookingRequest.createBooking(newBooking)).execute();

        response.verifyStatusCode().isEqualTo(200);
        response.verifyTextField("bookingid")
                .isNotNull();
        response.verifyTextField("booking.firstname").isEqualTo(newBooking.getFirstname());
        bookingId = response.getResponseData("bookingid");
    }


    @Test(description = "Test for retrieving booking using GET request")
    public void testGetBooking() {
        var response = withRequest(BookingRequest.getBooking(bookingId)).execute();

        response.verifyStatusCode().isEqualTo(200);
        response.verifyTextField("firstname")
                .isEqualTo(newBooking.getFirstname());
        response.verifyTextField("lastname")
                .isEqualTo(newBooking.getLastname());
    }

    @Test(description = "Test for Updating booking using PUT request")
    public void testUpdateBooking() {
        BookingData updateBookingData = dataBuilder.bookingDataBuilder();

        var response = withRequest(BookingRequest.updateBooking(bookingId, updateBookingData)).execute();
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

        var response = withRequest(BookingRequest.updatePartialBooking(bookingId, partialBookingData)).execute();
        response.verifyStatusCode()
                .isEqualTo(200);
        response.verifyTextField("firstname")
                .isEqualTo(partialBookingData.getFirstname());
        response.verifyIntField("totalprice")
                .isEqualTo(partialBookingData.getTotalprice());
    }

    @Test(description = "Test for Deleting a booking using DELETE request")
    public void testDeleteBooking() {

        var response = withRequest(BookingRequest.deleteBooking(bookingId)).execute();
        response.verifyStatusCode()
                .isEqualTo(201);
    }

    @Test(description = "Test for checking deleted booking using GET request")
    public void testDeletedBooking() {

        var response = withRequest(BookingRequest.getBooking(bookingId)).execute();
        response.verifyStatusCode()
                .isEqualTo(404);
    }


}
