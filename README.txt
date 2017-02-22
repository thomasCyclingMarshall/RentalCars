README:

This is setup as a Maven project, therefore the dependencies for Spring and JSON parsing are in the pom.xml file.
  I have developed this in IntelliJ Idea.

RentalCars2.java is the 'main' file. Run that and the answers to the first 4 parts are printed to the console.

Application.java is the most simple Spring server, based on Spring's tutorial documentation.
  Browse to localhost:8080/part1a 1b 1c 1d to get the answers printed to a browser page.

In Tests.java are some JUnit tests that check the JSON is being parsed, and the methods in RentalCars.java give
  the expected results.

I have used the Jackson JSON parser.