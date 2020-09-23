$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AddToCart.feature");
formatter.feature({
  "line": 3,
  "name": "Add items to the shopping cart",
  "description": "",
  "id": "add-items-to-the-shopping-cart",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@AddToCart"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Buy summer dress",
  "description": "",
  "id": "add-items-to-the-shopping-cart;buy-summer-dress",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "user is not logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user is on selected dress page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "add dress to cart",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "proceed to checkout",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user is prompted to signIn",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "After signing in user proceeded with payment details",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user completes the purchase with success",
  "keyword": "And "
});
formatter.match({
  "location": "ItemStepDef.userIsNotLoggedIn()"
});
formatter.result({
  "duration": 7411052214,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.userNavigateToSummerDressStorePage()"
});
formatter.result({
  "duration": 8530407,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.addTheDressToCart()"
});
formatter.result({
  "duration": 1218955548,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.proceedToCheckout()"
});
formatter.result({
  "duration": 5700513282,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.userIsPresentedWithSignInScreen()"
});
formatter.result({
  "duration": 2194632166,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.userSignedInAndPurchasedTheDress()"
});
formatter.result({
  "duration": 5610835434,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.userIsPresentedWithSuccessScreen()"
});
formatter.result({
  "duration": 43115569,
  "status": "passed"
});
formatter.after({
  "duration": 141511580,
  "status": "passed"
});
});