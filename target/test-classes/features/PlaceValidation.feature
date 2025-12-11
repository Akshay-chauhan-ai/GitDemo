Feature: Validating Place APIs

  @AddPlace @Regression
  Scenario Outline:
: Verify if place is successfully added using AddPlaceAPI

    Given Add Place payload with "<name>" "<language>" "<address>"
    When user calls "AddplaceAPI" with "Post" HTTP request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"
    And verify Place_Id created maps to "<name>" using "GetplaceAPI"

    Examples:
      | name | language | address            |
      | Aman | English  | world cross center |
# | Akshay | spanish  | uttrakhand         |

  @DeletePlace @Regression
  Scenario:
: Verify if delete place functionality is working

    Given deleteplace payload
    When user calls "deleteplaceAPI" with "POST" HTTP request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"

    



    
    