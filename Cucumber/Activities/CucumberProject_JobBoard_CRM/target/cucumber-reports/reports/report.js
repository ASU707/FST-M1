$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Activity1_1.feature");
formatter.feature({
  "line": 2,
  "name": "Job Board Application Test",
  "description": "",
  "id": "job-board-application-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Job_Board_Project"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Create a new User",
  "description": "",
  "id": "job-board-application-test;create-a-new-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@UC_01"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on Admin Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User adds a new User",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "New User gets added",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "createNewUser.userLogin()"
});
formatter.result({
  "duration": 12330797200,
  "status": "passed"
});
formatter.match({
  "location": "createNewUser.userCreation()"
});
formatter.result({
  "duration": 64455588300,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#createusersub\"}\n  (Session info: chrome\u003d84.0.4147.125)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:48\u0027\nSystem info: host: \u0027DESKTOP-CQMQLVN\u0027, ip: \u0027192.168.0.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 84.0.4147.125, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\SUSMIT~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:53884}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 811ca501a8193d2656eaed7103d2b9c9\n*** Element info: {Using\u003did, value\u003dcreateusersub}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:83)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:57)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:437)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepDefinitions.createNewUser.userCreation(createNewUser.java:68)\r\n\tat ✽.When User adds a new User(Activity1_1.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "createNewUser.verifyCreation()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "createNewUser.closeTheBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 12,
  "name": "Search and Apply for a Job",
  "description": "",
  "id": "job-board-application-test;search-and-apply-for-a-job",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@UC_02"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "User is on Job Page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User searches for a Full Time Job",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User Applies for the Job",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Close the Job Listing browser",
  "keyword": "And "
});
formatter.match({
  "location": "searchJobAndApply.jobPage()"
});
formatter.result({
  "duration": 7941541900,
  "status": "passed"
});
formatter.match({
  "location": "searchJobAndApply.jobSearch()"
});
formatter.result({
  "duration": 1976421800,
  "status": "passed"
});
formatter.match({
  "location": "searchJobAndApply.jobApply()"
});
formatter.result({
  "duration": 13813179500,
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using xpath\u003d//input[@type\u003d\u0027button\u0027 and @value\u003d\u0027Apply for job\u0027]\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:48\u0027\nSystem info: host: \u0027DESKTOP-CQMQLVN\u0027, ip: \u0027192.168.0.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepDefinitions.searchJobAndApply.jobApply(searchJobAndApply.java:74)\r\n\tat ✽.Then User Applies for the Job(Activity1_1.feature:15)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "searchJobAndApply.closeThe2ndBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 19,
  "name": "Post a Job without Example Table",
  "description": "",
  "id": "job-board-application-test;post-a-job-without-example-table",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@UC_03"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "User is on Post Job Page",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "User enters details for Job with \"BDDJobNew85@Cucumber.in\" and \"BDDJobNew85Cucumber\" and \"BDDJobNew85Cucumber Description\" and \"https://BDDJob85Cucumber/application/webpages/jobs\" and \"Private BDD Company Ltd\"",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "User Creates and Verifies the Job with \"BDDJob_AACucumber\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Close the Job Listing Verification browser",
  "keyword": "And "
});
formatter.match({
  "location": "jobPosting_WithoutExample.jobPostPage()"
});
formatter.result({
  "duration": 9725095800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BDDJobNew85@Cucumber.in",
      "offset": 34
    },
    {
      "val": "BDDJobNew85Cucumber",
      "offset": 64
    },
    {
      "val": "BDDJobNew85Cucumber Description",
      "offset": 90
    },
    {
      "val": "https://BDDJob85Cucumber/application/webpages/jobs",
      "offset": 128
    },
    {
      "val": "Private BDD Company Ltd",
      "offset": 185
    }
  ],
  "location": "jobPosting_WithoutExample.postJobPage(String,String,String,String,String)"
});
formatter.result({
  "duration": 3569589700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BDDJob_AACucumber",
      "offset": 40
    }
  ],
  "location": "jobPosting_WithoutExample.verifyPostedJob(String)"
});
formatter.result({
  "duration": 2697775000,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d84.0.4147.125)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:48\u0027\nSystem info: host: \u0027DESKTOP-CQMQLVN\u0027, ip: \u0027192.168.0.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 84.0.4147.125, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\SUSMIT~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:54131}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 92ab088f3892f7069ca84393c8d394ef\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:83)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:57)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:437)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.sendKeys(RemoteWebElement.java:106)\r\n\tat stepDefinitions.jobPosting_WithoutExample.verifyPostedJob(jobPosting_WithoutExample.java:77)\r\n\tat ✽.Then User Creates and Verifies the Job with \"BDDJob_AACucumber\"(Activity1_1.feature:22)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "jobPosting_WithoutExample.closeThe3rdBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Post a Job without Example Table",
  "description": "",
  "id": "job-board-application-test;post-a-job-without-example-table",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 25,
      "name": "@UC_04"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "With Example User is on Post Job Page",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "With Example User enters details for Job with \"\u003cemail\u003e\" and \"\u003cjobTitle\u003e\" and \"\u003cdescription\u003e\" and \"\u003capplicationURL\u003e\" and \"\u003ccompanyName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "With Example User Creates and Verifies the Job with \"\u003cjobTitle\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "With Example Close the Job Listing Verification browser",
  "keyword": "And "
});
formatter.examples({
  "line": 33,
  "name": "",
  "description": "",
  "id": "job-board-application-test;post-a-job-without-example-table;",
  "rows": [
    {
      "cells": [
        "email",
        "jobTitle",
        "description",
        "applicationURL",
        "companyName"
      ],
      "line": 34,
      "id": "job-board-application-test;post-a-job-without-example-table;;1"
    },
    {
      "cells": [
        "BDDJobExample83@Cucumber.in",
        "BDDJobExample83_Cucumber",
        "BDDJobExample83_Cucumber Description",
        "https://bddjobExample83/application/webpages/jobs",
        "Private BDD Company Ltd"
      ],
      "line": 35,
      "id": "job-board-application-test;post-a-job-without-example-table;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 35,
  "name": "Post a Job without Example Table",
  "description": "",
  "id": "job-board-application-test;post-a-job-without-example-table;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Job_Board_Project"
    },
    {
      "line": 25,
      "name": "@UC_04"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "With Example User is on Post Job Page",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "With Example User enters details for Job with \"BDDJobExample83@Cucumber.in\" and \"BDDJobExample83_Cucumber\" and \"BDDJobExample83_Cucumber Description\" and \"https://bddjobExample83/application/webpages/jobs\" and \"Private BDD Company Ltd\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "With Example User Creates and Verifies the Job with \"BDDJobExample83_Cucumber\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "With Example Close the Job Listing Verification browser",
  "keyword": "And "
});
formatter.match({
  "location": "jobPosting_WithExample.jobPostPage_Example()"
});
formatter.result({
  "duration": 9433128300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BDDJobExample83@Cucumber.in",
      "offset": 47
    },
    {
      "val": "BDDJobExample83_Cucumber",
      "offset": 81
    },
    {
      "val": "BDDJobExample83_Cucumber Description",
      "offset": 112
    },
    {
      "val": "https://bddjobExample83/application/webpages/jobs",
      "offset": 155
    },
    {
      "val": "Private BDD Company Ltd",
      "offset": 211
    }
  ],
  "location": "jobPosting_WithExample.postJobPage_Example(String,String,String,String,String)"
});
formatter.result({
  "duration": 3280990400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BDDJobExample83_Cucumber",
      "offset": 53
    }
  ],
  "location": "jobPosting_WithExample.verifyPostedJob_Example(String)"
});
formatter.result({
  "duration": 14195942000,
  "status": "passed"
});
formatter.match({
  "location": "jobPosting_WithExample.closeThe4thBrowser()"
});
formatter.result({
  "duration": 237488800,
  "status": "passed"
});
});