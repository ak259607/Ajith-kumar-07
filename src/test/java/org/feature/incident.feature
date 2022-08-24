Feature: ServiceNow Incidents API
  
Background:
 Given Setup the Base URI for Incident API
 And Setup the Authentication wit valid Credentials  
  
  
Scenario: Test Get all Incidents API 
    When Place the get request 
    Then Validate the status code as 200
    
Scenario Outline: Create new Incidents API
    Given Pass the Data to the body from <Filename> file  
    When Place the post request 
    Then Validate the status code as <StatusCode>

 Examples:
|Filename|StatusCode|
|'data1.json'|201|
|'data2.json'|201|