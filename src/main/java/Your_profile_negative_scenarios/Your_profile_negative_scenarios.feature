Feature: Validation on Your profile page negative test cases

  #User should be able to click on the your profile and edit profile details
  Scenario: Verify clicking on profile will navigates to Your profile screen
    Given Launch the URL
    When Click on your profile

  Scenario: Validate that Send Code button is disabled when they do not check the phone number
    When Verify Send Code button is disabled

  Scenario: Verify the scenario when blank 'security code and Re-enter password' fields
    When Enter 'security code and Re-enter password' as blank
    Then Verify the validation message

  Scenario: Verify the scenario when entering invalid Security code  and Re-enter password
    When Enter invalid 'security code and Re-enter password'
    Then Verify the validation message for invalid data

  Scenario: Verify the scenario when blank 'security code or Re-enter password' fields
    When Enter 'security code or Re-enter password' as blank
    Then Verify the validation blank message

  Scenario: Verify the scenario when unable to  Edit the primary and deactivate email
    When Not able to edit primary and deactivate email

  Scenario: Verify the scenario when blank Your profile Page fields
    When Enter firstname and lastname fields as blank
    Then Verify the validation message for blank fields

  Scenario: Verify the scenario when entering invalid First name, Last name  or  Preferred name
    When Enters invalid firstname,lastname and preferred name
    Then Verify the validation for invalid first name, last name or preferred name

  Scenario: Verify the scenario unable to  Edit the User ID
    When verify 'User ID' is disabled for edit

  Scenario: Verify the scenario when Email ID fields are blank
    When Leave email id field as blank

  Scenario: Verify the scenario when entering invalid Email ID  or  already exist Email ID
    When Enter invalid email id
    Then Verify the validation for invalid email id

  Scenario: Verify the scenario when unable to  Edit the primary and deactivate phone number
    When primary and deactivate phone number is disabled for edit
    
  Scenario: Verify the scenario when entering invalid Phone number  or  Phone number fields are blank
    When Enter invalid Phone number  or  Phone number fields
    Then Verify the validation message for Phone number  or  Phone number fields

  Scenario: Verify the scenario when unable to  Edit the primary and deactivate address
    When primary and deactivate address are disbled for edit

  Scenario: Verify the scenario when leaving the fields blank in the Add new address Page
    When Leaves fields blank

  Scenario: Verify the scenario when entering invalid Zip code in Add new address page
    When Enters invalid zip code

  Scenario: Verify the scenario when leaving the fields blank in the Add plan Page
    When Enter add plan page feilds blank

  Scenario: Verify the scenario when entering invalid First name of policy holder or Last name of policy holder  in Add plan page
    When Enters invalid firstname and lastname fields in add plan page

  Scenario: Verify the scenario when leaving the fields blank in the Change password page
    When Enter blank fields in Change password page

  Scenario: Verify the scenario when entering wrong Old password in Change password page
    When Enter wrong passwords

  Scenario: Verify the scenario when invalid New password in Change password page
    When Enter invalid new password

  Scenario: Verify the scenario when entering same data in Old password and New password fields in Change password page
    When Enter same data in Old password and New password fields

  Scenario: Verify the scenario when entering different data in New password and Confirm new password fields
    When Enter different data in New password and Confirm new password fields

  Scenario: Verify the scenario when a dialogue box appears dur to the failure of profile picture
    When Not able to upload profile picture
