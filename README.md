# InsiderTestTask

You need to have chromedriver for chrome and geckodriver for firefox somewhere in system (added to PATH).
Links:
https://github.com/mozilla/geckodriver/releases and
https://chromedriver.chromium.org/downloads
Test checked on both browsers but only for windows.

Run tests.
For firefox:
mvn clean test -Dbrowser=firefox

or skip "browser" and it will be run by default in chrome.

Allure report:
mvn allure:serve