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
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "add selected dress to cart",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "proceed to checkout and purchase the item",
  "keyword": "And "
});
formatter.match({
  "location": "ItemStepDef.userIsNotLoggedIn()"
});
formatter.result({
  "duration": 8870448307,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.userNavigateToSummerDressStorePage()"
});
formatter.result({
  "duration": 19951129,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.addTheDressToCart()"
});
formatter.result({
  "duration": 2343762480,
  "status": "passed"
});
formatter.match({
  "location": "ItemStepDef.proceedToCheckout()"
});
formatter.result({
  "duration": 12935666646,
  "status": "passed"
});
formatter.after({
  "duration": 140832213,
  "status": "passed"
});
});