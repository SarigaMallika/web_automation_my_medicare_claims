Feature: User must click on the Award Point and navigated to the Reddemed award points page

  Scenario: Validate navigation to utility page
    Given Launch the URL
    When Navigate to Welcome screen
    Then Click on 'Utilities'

  Scenario: Validate Tile "Award Points"in the Utilities dashboard
    When Click on Award points tile
    Then Validate Award points page

  Scenario: Validate the Redeem points  in the Award points dashboard.
    When Click on the Redeem Points button
    Then Validate the redeem award points page

  Scenario: Validate the navigation to the redeemed page
    When Navigate to the redeem page
    Then Validate the redeem page