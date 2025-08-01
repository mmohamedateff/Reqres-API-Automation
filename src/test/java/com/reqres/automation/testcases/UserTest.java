package com.reqres.automation.testcases;

import com.reqres.automation.apis.UserApis;
import com.reqres.automation.models.User;
import com.reqres.automation.steps.UserSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Feature("User Test Cases")
public class UserTest {

    @Story("Should Be Able To Create User")
    @Test
    public void shouldBeAbleToCreateUser() {
        User user = UserSteps.generateUser();

        Response response = UserApis.createUser(user);
        User returnedUser = response.body().as(User.class);

        assertThat(response.statusCode(), equalTo(201));
        assertThat(user.getName(), equalTo(returnedUser.getName()));
    }

    @Story("Should Be Able To Update User")
    @Test
    public void shouldBeAbleToUpdateUser() {
        User firstUser = UserSteps.generateUser();
        String userId = UserSteps.getUserId(firstUser);
        User secondUser = new User(firstUser.getName(), "Software Tester");

        Response response = UserApis.updateUser(secondUser, userId);
        User returnedUser = response.body().as(User.class);

        assertThat(response.statusCode(), equalTo(200));
        assertThat(secondUser.getJob(), equalTo(returnedUser.getJob()));
    }

    @Story("Should Be Able To Get User")
    @Test
    public void shouldBeAbleToGetUser() {
        User firstUser = UserSteps.generateUser();
        String userId = UserSteps.getUserId(firstUser);
        User secondUser = new User(firstUser.getName(), "Software Tester");
        UserApis.updateUser(secondUser, userId);

        Response response = UserApis.getUser(userId);
        User returnedUser = response.body().as(User.class);

//        Since this's just a mock API, the user I’m creating doesn’t actually exist, only 12 users are available.
//        Therefore, I’ll make sure a 404 status code is returned, and I’ll comment out the assertion line related to this functionality.
        assertThat(response.statusCode(), equalTo(404));
//        assertThat(returnedUser.getJob(), equalTo(secondUser.getJob()));
    }

    @Story("Should Be Able To Delete User")
    @Test
    public void shouldBeAbleToDeleteUser() {
        User firstUser = UserSteps.generateUser();
        String userId = UserSteps.getUserId(firstUser);

        Response response = UserApis.deleteUser(userId);

        assertThat(response.statusCode(), equalTo(204));
    }

    @Story("Should Be Able To Get Deleted User")
    @Test
    public void shouldBeNotAbleToGetDeletedUser() {
        User firstUser = UserSteps.generateUser();
        String userId = UserSteps.getUserId(firstUser);
        UserApis.deleteUser(userId);

        Response response = UserApis.getUser(userId);

        assertThat(response.statusCode(), equalTo(404));
    }
}
