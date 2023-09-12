Feature: sample1

  Scenario: sample secnario1
    Given open browser
    When launch site "http://www.google.co.in"
    Then page title should be "Google"
    When close site

  Scenario: sample secnario2
    Given open browser
    When launch site "http://www.google.co.in"
    And search "abdul kalam" and click enter key
    Then page title contains "abdul kalam"
    When quit site