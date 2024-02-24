Feature:Contact us form

  Scenario: Completely fill out contact us form and send it
    Given I am on the Home Page
    When I navigate to the Contact us page, fill out the contact form and send it
    Then I verify that the form has been sent