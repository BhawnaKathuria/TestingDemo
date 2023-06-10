Feature: Validating Place API's
@AddPlaceAPI
Scenario Outline: Verify Add place API is working successfully
Given Add place payload "<name>" "<language>" "<address>"
When User calls "AddPlace" API with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created maps to "<name>" using "getPlace"

Examples:
| name | language| address |
|Bhawna | en-EN | Mumbai|
#|Kamal | fr-FR | Gurgaon|

@DeletePlace
Scenario: Verify if Delete Place functionality is working

	Given DeletePlace Payload
	When User calls "deletePlaceAPI" API with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"