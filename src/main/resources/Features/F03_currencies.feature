@Smoke
Feature: select euro currency in home page

  Scenario:F03_Currencies |user couldselect euro currency
    When user select euro option
    Then euro symbol is displayed in all product on home page
