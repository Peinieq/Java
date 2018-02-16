Narrative:
In order to 
As a user
I want to 
					 
Scenario: First Form test

When user setUp Web Api
And user goes to start page
And user enters message
And user clicks show message button
Then message should be Witaj Karol

Scenario: Ajax test

When user setUp Web Api
And user goes to Ajax page
And user enters AjaxName message
And user enters AjaxComment message
And user clicks Ajax Submit Button
Then Ajax feedback should be Form submited Successfully!

Scenario: Radio Button upper Male test

When user setUp Web Api
And user goes to Radio Button page
And user clicks upper Male Radio Button
And user clicks upper Radio Button submit Button
Then radio button message should be Male

Scenario: Radio Button lower Male 0-5 test

When user setUp Web Api
And user goes to Radio Button page
And user clicks lower Male Radio Button
And user clicks lower 0-5 Radio Button
And user clicks lower submit Radio Button
Then lower radio button message should be ok

Scenario: Checkbox page test

When user setUp Web Api
And user goes to CheckBox page
And user checks all 4 lower checkboxes
Then message on CheckBox button should be Uncheck All