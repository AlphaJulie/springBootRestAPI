#  Issue Tracker application

## Overview

The Issue tracker application is a simplified version of Atlassian Jira, or Trello board, which allows users to create
and manage the progress of issues. 

RESTful API for the issue tracker system, which will provide CRUD functionality to API consumers.
Consumers should be able to complete all of the following:

1. Create a new issue.
2. Retrieve an existing issue.
3. Update an existing issue.
3. Delete an issue.



## SpringBoot

[Spring Boot](https://projects.spring.io/spring-boot/) is an Opinionated Java Framework for developing production-ready
Spring applications. Spring Boot favours convention over configuration and is designed to get you up and running as
quickly as possible.


[Gradle](https://gradle.org/) is the build tool for this project, and requires Java JDK to be installed. It is not
necessary to install gradle.


This project makes use of [The Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html). The
following command will run a full build of the project.

    ./gradlew build


### Running the application

This project makes use of the
[Gradle Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-gradle-plugin.html)
plugin. To start the application locally just run the following command


    ./gradew bootRun


## H2 Console

The H2 DB console can be accessed in your browser. Navigate to [/v1/h2](http://localhost:8080/v1/h2) to access the console,
and ensure the `JDBC URL` matches the one defined in the `application.yml` file: jdbc:h2:file:~/simple-ticket-db


