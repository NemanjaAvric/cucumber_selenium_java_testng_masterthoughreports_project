Feature:Products


  Scenario: Verify all products and product detail page
    Given I am on the Home Page
    When I go to the Products Page and verify that list of products is visible
    And I click on the View Product button of the first product and go to the Product Detail Page
    Then I verify that the details of the Product Detail Page are visible

  Scenario Outline:Search product
    Given I am on the Home Page
    When I go to the Products Page and verify that list of products is visible
    And I search the name of the product: '<product>'
    Then I verify that the results of the search is visible

    Examples:
      | product |
      | Tshirt  |
      | Dress   |
      | Top     |
      | Shirt   |
      | Dress   |
      | Jeans   |
      | Saree   |
      | Lace    |


  Scenario:Add products to the cart
    Given I am on the Home Page
    When I go to the Products Page and verify that list of products is visible
    And I add two of the products from the list to the cart
    Then I verify that the products are added to the cart and remove products from the cart and verify that the cart is empty




