package org.api.testdata.builder;


import com.github.javafaker.Faker;
import org.api.testdata.datamodel.Request.User;

public class UserBuilder {

    private static final Faker F = new Faker();
    private User user = new User();

    private UserBuilder() {

    }

    public static UserBuilder anyUser() {
        return new UserBuilder()
                .withUserName(F.name().firstName())
                .withPassword("test");

    }

    public UserBuilder withUserName(String name) {
        this.user.setUsername(name);
        return this;

    }

    public UserBuilder withPassword(String password) {
        this.user.setPassword(password);
        return this;
    }


    public User build() {

        return new User(user.getUsername(), user.getPassword());

    }


}
