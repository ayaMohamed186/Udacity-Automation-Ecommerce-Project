@Smoke

Feature: F04_Search | Search for products in homePage
  Scenario Outline: user could search using product nam
  When user search on product "<name>"
  And press on search button
  Then search results contains "<name>"
Examples:
| name |
| book |
| laptop |
| nike |


  Scenario Outline: user could search on product using SKU
    When user search on product "<name>"
    And press on search button
    And press on product in search result
    Then search results contains "<name>" using sku
    Examples:
      | name |
      | SCI_FAITH |
      | APPLE_CAM|
      | SF_PRO_11 |