# Truextend Problem 2
This is the proposed solution for Exercise 2

## Pre-Requirements
In order to execute the solution you need to install:
- Maven Download and install instructions: https://maven.apache.org/install.html
- Java 1.8 Download and install instructions: https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

## About the Application
To solve this problem, the application implements The Haversine formula, to calculate the distance between 2 Coordinates, in which the coordinate of the student and the class is compared. More information about this formula: https://en.wikipedia.org/wiki/Haversine_formula

Once the distance is obtained, it is evaluated if the obtained value is within the maximum possible distance to consider that the student is or is not in the class.

## Program Execution
After install the prerequired tools, the project could be run to test it with the following command:

`` mvn test ``

After this, the necessary dependencies will be downloaded immediately and finally the tests will be run, in which the sample inputs and outputs provided in the document will be tested. Additionally, a third test with erroneous data was included to verify the case in which there are no students in classes.