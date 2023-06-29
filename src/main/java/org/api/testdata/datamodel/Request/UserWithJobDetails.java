package org.api.testdata.datamodel.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserWithJobDetails {

    private String name;
    private String job;

    public UserWithJobDetails() {
    }

    public UserWithJobDetails(String name, String job) {

        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
