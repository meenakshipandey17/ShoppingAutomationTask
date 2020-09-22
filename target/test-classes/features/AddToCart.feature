@AddToCart

Feature: Add items to the shopping cart

  Scenario: Buy summer dress
    Given user is not logged in
    And user is on selected dress page
    Then add selected dress to cart
    And proceed to checkout and purchase the item



