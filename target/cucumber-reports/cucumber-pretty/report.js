$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SignIn.feature");
formatter.feature({
  "line": 3,
  "name": "Test cases for login functionality",
  "description": "",
  "id": "test-cases-for-login-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "SignIn with valid credentials",
  "description": "",
  "id": "test-cases-for-login-functionality;signin-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I am on signin page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Sign in",
  "keyword": "Then "
});
formatter.match({
  "location": "SignInStepDef.user_is_on_signIn()"
});
formatter.result({
  "duration": 6391716783,
  "status": "passed"
});
formatter.match({
  "location": "SignInStepDef.signIn()"
});
formatter.result({
  "duration": 2006325298,
  "status": "passed"
});
formatter.after({
  "duration": 106325554,
  "status": "passed"
});
});