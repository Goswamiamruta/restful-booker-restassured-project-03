package com.restful.booker.testsuite;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserPatchBookingTest extends TestBase {
    @Test
    public void verifyUpdatedSuccessfully() {

        HashMap<String, String> checkInOutDatesData = new HashMap<String, String>();
        checkInOutDatesData.put("checkin", "2018-01-01");
        checkInOutDatesData.put("checkout", "2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("James");
        bookingPojo.setLastname("Brown");
        bookingPojo.setBookingdates(checkInOutDatesData);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("cookie", "token=52e07dd6c32edb6")
//                .auth().preemptive().basic("admin","password123")
                .pathParam("id", 393)
                .when()
                .body(bookingPojo)
                .patch("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
