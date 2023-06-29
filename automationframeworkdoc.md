```
E2E Test Automation Framework Documentation
This document provides an overview of our End-to-End (E2E) Test Automation Framework developed using Playwright for UI Automation, Supertest for API triggering and test data creation, and TypeScript as the scripting language.

Overview
The framework follows a clear and easy-to-maintain structure, aimed at providing a robust foundation for developing, executing, and maintaining automated tests.

Folder Structure
Our project follows a certain folder structure to keep the codebase organized. Here is what each folder signifies:

src/pagefactory/pages: This directory contains page object models for each page of the application. Each page is represented as a class with the functions representing the actions that can be performed on the page.

src/pagefactory/locators: This directory houses locator files. Each file contains identifiers for HTML elements for a specific page in the application.

src/pagefactory/constants: This directory stores constant values which are used across the application.

src/testdata: This directory is where test data files are stored. The test data can be of various forms such as JSON, CSV, etc., and is used as input for test cases.

src/tests: This is the main directory where all the test files are kept. It is further divided into subdirectories like smoke for smoke tests and regression for regression tests.

src/api: This directory is related to all the API testing functionalities. It consists of configuration files, test data for API, and API tests.

Tests
Test files are located under src/tests directory and it includes two types of test:

Smoke tests: Basic tests under the src/tests/smoke directory, ensuring the most critical parts of the system are functioning as expected.

Regression tests: More thorough and detailed tests under the src/tests/regression directory, used for discovering new software bugs in existing areas of a system after changes have been made.

API
The API related configurations and tests are maintained under src/api.

src/api/config: This directory contains configuration files for the APIs including URLs, paths, and other necessary details.

src/api/data: This directory stores the test data required for the API tests.

src/api/test: This directory contains all the API test scripts written using Supertest library.

Getting Started
(Describe how to set up and run tests using your framework. It should include details about necessary prerequisites, how to install them, and how to run the tests.)

Reporting
(Explain how the test reports are generated, where they can be found, and how to interpret them.)

Best Practices
(Discuss any best practices that testers should follow while writing and maintaining tests.)

Please adapt this template to suit the needs and specifics of your project. Include as much detail as necessary to allow new team members to understand the framework and start contributing to tests quickly.
