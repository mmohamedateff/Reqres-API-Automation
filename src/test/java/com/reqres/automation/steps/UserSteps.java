package com.reqres.automation.steps;

import com.reqres.automation.apis.UserApis;
import com.reqres.automation.models.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;


public class UserSteps {
    public static User generateUser() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String job = faker.job().title();

        return new User(name,job);
    }

    public static String getUserId(User user) {
        Response response = UserApis.createUser(user);
        return response.body().path("id");
    }

}
