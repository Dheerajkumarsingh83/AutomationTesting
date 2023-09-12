Feature: sample2

  Scenario Outline: sample secnario3
    Given open browser
    When launch site "http://www.google.co.in"
    And search "<word>" and click enter key
    Then page title contains "<word>"
    When quit site

    Examples: 
      | word        |
      | steve jobs  |
      | magnitia    |
      | gold rate   |
      | temperature |
