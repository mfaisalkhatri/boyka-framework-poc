package io.github.mfaislakhatri.requests;

import com.github.wasiqb.boyka.builders.ApiRequest;
import com.github.wasiqb.boyka.enums.RequestMethod;

import static com.github.wasiqb.boyka.actions.api.ApiActions.withRequest;
import static com.github.wasiqb.boyka.builders.ApiRequest.createRequest;
import static java.text.MessageFormat.format;


public class BookingRequest {

    private static final String API_CONFIG_KEY = "test_restfulbooker";

    public static ApiRequest createBooking(Object requestBody) {

        return createRequest().configKey(API_CONFIG_KEY)
                .method(RequestMethod.POST)
                .header("Accept", "application/json")
                .path("/booking")
                .bodyObject(requestBody)
                .create();
    }

    public static ApiRequest getBooking(String id) {
        return createRequest().configKey(API_CONFIG_KEY)
                .method(RequestMethod.GET)
                .header("Accept", "application/json")
                .path("/booking/${id}")
                .pathParam("id", id)
                .create();
    }

    public static ApiRequest updateBooking(String id, Object requestBody) {
        return createRequest().configKey(API_CONFIG_KEY)
                .method(RequestMethod.PUT)
                .header("Accept", "application/json")
                .header("Cookie", format("token={0}", generateToken()))
                .path("/booking/${id}")
                .bodyObject(requestBody)
                .pathParam("id", id)
                .create();
    }


    private static String generateToken() {
        TokenBuilder builder = new TokenBuilder();
        var generateTokenRequest = createRequest().configKey(API_CONFIG_KEY)
                .header("Accept", "application/json")
                .method(RequestMethod.POST)
                .path("/auth")
                .bodyObject(builder.tokenBuilder())
                .create();

        var response = withRequest(generateTokenRequest).execute();
        return response.getResponseData("token");
    }

    public static ApiRequest updatePartialBooking(String id, Object requestBody) {
        return createRequest().configKey(API_CONFIG_KEY)
                .method(RequestMethod.PATCH)
                .header("Accept", "application/json")
                .header("Cookie", format("token={0}", generateToken()))
                .path("/booking/${id}")
                .bodyObject(requestBody)
                .pathParam("id", id)
                .create();
    }

    public static ApiRequest deleteBooking(String id) {
        return createRequest().configKey(API_CONFIG_KEY)
                .method(RequestMethod.DELETE)
                .header("Content-Type", "application/json")
                .header("Cookie", format("token={0}", generateToken()))
                .path("/booking/${id}")
                .pathParam("id", id)
                .create();
    }
}
