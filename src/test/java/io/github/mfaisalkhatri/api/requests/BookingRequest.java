package io.github.mfaisalkhatri.api.requests;

import static com.github.wasiqb.boyka.actions.api.ApiActions.withRequest;
import static com.github.wasiqb.boyka.builders.ApiRequest.createRequest;
import static java.text.MessageFormat.format;

import com.github.wasiqb.boyka.builders.ApiRequest;
import com.github.wasiqb.boyka.enums.RequestMethod;

public class BookingRequest {

    public static ApiRequest createBooking (Object requestBody) {

        return createRequest ()
            .method (RequestMethod.POST)
            .header ("Accept", "application/json")
            .path ("/booking")
            .bodyObject (requestBody)
            .create ();
    }

    public static ApiRequest getBooking (String id) {
        return createRequest ()
            .method (RequestMethod.GET)
            .header ("Accept", "application/json")
            .path ("/booking/${id}")
            .pathParam ("id", id)
            .create ();
    }

    public static ApiRequest updateBooking (String id, Object requestBody) {
        return createRequest ()
            .method (RequestMethod.PUT)
            .header ("Accept", "application/json")
            .header ("Cookie", format ("token={0}", generateToken ()))
            .path ("/booking/${id}")
            .bodyObject (requestBody)
            .pathParam ("id", id)
            .create ();
    }

    private static String generateToken () {
        TokenBuilder builder = new TokenBuilder ();
        var generateTokenRequest = createRequest ()
            .header ("Accept", "application/json")
            .method (RequestMethod.POST)
            .path ("/auth")
            .bodyObject (builder.tokenBuilder ())
            .create ();

        var response = withRequest (generateTokenRequest).execute ();
        return response.getResponseData ("token");
    }

    public static ApiRequest updatePartialBooking (String id, Object requestBody) {
        return createRequest ()
            .method (RequestMethod.PATCH)
            .header ("Accept", "application/json")
            .header ("Cookie", format ("token={0}", generateToken ()))
            .path ("/booking/${id}")
            .bodyObject (requestBody)
            .pathParam ("id", id)
            .create ();
    }

    public static ApiRequest deleteBooking (String id) {
        return createRequest ()
            .method (RequestMethod.DELETE)
            .header ("Content-Type", "application/json")
            .header ("Cookie", format ("token={0}", generateToken ()))
            .path ("/booking/${id}")
            .pathParam ("id", id)
            .create ();
    }
}
