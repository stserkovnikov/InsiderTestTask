# InsiderTestTask
Run tests.
For firefox:
mvn clean test -Dbrowser=firefox

or skip "browser" and it will be run by default in chrome.

Chromedriver or firefox (geckodriver) driver will be downloaded automatically.

Create Allure report:
mvn allure:serve

For failed tests screenshot will be attached in tearDown.