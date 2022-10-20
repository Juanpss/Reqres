# Automation framework for getting single user information from [Reqres.in](https://reqres.in/)

## Software prerequisites

- Maven
- Allure

For installing allure:

- Mac: Install [HomeBrew](https://brew.sh/), open the terminal and run the following command `brew install allure`
- Windows: Install [Scoop](https://scoop.sh/), open powershell and run the following command `scoop install allure`

## Before getting started

Make sure to update the `pom.xml` file in order to load all the required plugins and dependencies

## To run the test follow these steps:

1. Open the `suite.xml` file
2. Set the desired `userId` on the value property inside the parameters tag
3. Open the terminal
4. Run the following command `mvn clean test`

After executing this command, a series of logs will be displayed on the terminal in order to track the different
actions that the test is doing

## To open the Allure report follow these steps:

1. Open the terminal
2. Run the following command `allure serve allure-results`

After running this command, the test report will be opened in the browser and inside the results
you can see the steps of the test and their different arguments

