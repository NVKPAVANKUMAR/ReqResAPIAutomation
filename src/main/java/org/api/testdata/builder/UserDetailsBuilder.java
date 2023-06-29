package org.api.testdata.builder;

import com.github.javafaker.Faker;
import org.api.testdata.datamodel.Request.UserWithJobDetails;

public class UserDetailsBuilder {
    private static final Faker F = new Faker();
    private UserWithJobDetails userDetails = new UserWithJobDetails();

    private UserDetailsBuilder() {

    }

    public static UserDetailsBuilder anyUserDetails() {
        return new UserDetailsBuilder()
                .withUserName(F.name().firstName())
                .withJob("leader");

    }

    public UserDetailsBuilder withUserName(String name) {
        this.userDetails.setName(name);
        return this;

    }

    public UserDetailsBuilder withJob(String job) {
        this.userDetails.setJob(job);
        return this;
    }


    public UserWithJobDetails build() {

        return new UserWithJobDetails(userDetails.getName(), userDetails.getJob());

    }

}
