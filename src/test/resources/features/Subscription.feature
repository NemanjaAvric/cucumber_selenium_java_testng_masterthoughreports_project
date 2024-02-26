Feature:Subscription

  Scenario Outline: Verify Subscription in Home Page
    Given I am on the Home Page
    When I scroll down the page and subscribe using email: '<email>'
    Then I verify that I have been successfully subscribed

    Examples:
      | email                    |
      | joyek92095@huizk.com     |
      | zizek91115@gmail.com     |
      | tigeyey834@lendfash.com  |
      | pexes84838@ebuthor.com   |
      | 6naxofim42@hotmail.com   |
      | 3295yaheki@yahoo.com     |
      | fiharag806@gexige.com    |
      | kineh96699@gexige.com    |
      | makisekurisu96@gmail.com |


  Scenario Outline: Verify Subscription in Cart Page
    Given I am on the Home Page
    When I click on the Cart icon and go to the Cart Page
    And I subscribe using email: '<email>'
    Then I verify that I have been successfully subscribed on the Cart Page

    Examples:
      | email                    |
      | joyek92095@huizk.com     |
      | zizek91115@gmail.com     |
      | tigeyey834@lendfash.com  |
      | pexes84838@ebuthor.com   |
      | 6naxofim42@hotmail.com   |
      | 3295yaheki@yahoo.com     |
      | fiharag806@gexige.com    |
      | kineh96699@gexige.com    |
      | makisekurisu96@gmail.com |