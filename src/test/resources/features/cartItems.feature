Feature: Cart Functionality

  Background:
    Given Open Base URL

   @addItemsCart
  Scenario: Add Items to cart
    When User Logs in
    And User adds Item1 to cart
    And User adds Item2 to cart
    Then User Logs Out