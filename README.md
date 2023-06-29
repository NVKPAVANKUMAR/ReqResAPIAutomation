# API Test Automation

This repository contains API Automated tests for test website

# Installation

#### Dependencies : Maven, Rest Assured, TestNG

# Usage

User can run the tests either from Command Line or using InelliJ

To Run tests using Maven --
run from Project Root Directory
mvn clean test

# Test Observations

1. Login Error message "Missing password" not ideal, inline with Security Standards.
   Should be changed to "invalid Credentials" inline with OWASP Guidance

2. Login Successful, even though user provides empty password
   eg: {
   "email": "peter@klaven",
   "password": ""
   }

3. Even though User created successfully using "POST /api/users", Get User not returning corresponding user details.

# Potential Improvements For Future

a. Configure Tests to run in Groups
b. Configure Tests to run in paralell