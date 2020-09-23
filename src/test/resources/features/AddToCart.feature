@AddToCart

Feature: Add items to the shopping cart

  Scenario: Buy summer dress
    Given user is not logged in
    When user is on selected dress page
    Then add dress to cart
    And proceed to checkout
    And user is prompted to signIn
    And After signing in user proceeded with payment details
    And user completes the purchase with success



