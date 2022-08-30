Feature: test api services using rest assured

  Scenario: verify endpoint should give the reponse
    Given user fetch the record with get url "https://reqres.in/"
    When user hit the endpoint "api/users" to get response for "page" number "2"
    Then verify the response
