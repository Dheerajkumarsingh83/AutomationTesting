Feature: sample1

  Background: 
    Given open browser
    When launch site "http://www.google.co.in"

  @smoketest
  Scenario: sample secnario1
    Then page title should be "Google"
    When close site

  Scenario: sample secnario2
    And search "abdul kalam" and click enter key
    Then page title contains "abdul kalam"
    When quit site
