@smoketest
Feature: sample3

  Scenario: sample secnario4
    Given open browser
    When launch site "http://www.google.co.in"
    Then search a word and click enter key and check page title
      | word        |
      | steve jobs  |
      | magnitia    |
      | gold rate   |
      | temperature |
    When quit site