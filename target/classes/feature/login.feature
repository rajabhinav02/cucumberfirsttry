Feature: Select Tea
Scenario Outline: Select tea from the list
Given user loads the application
When title of page is Welcome
When name of tea is <tea>
Then user clicks on See Collection
Then Menu page is displayed
Then Close the browser

Examples:

	|tea|
	|Loose Tea|
	|Herbal Tea|
   
   
   
   
   