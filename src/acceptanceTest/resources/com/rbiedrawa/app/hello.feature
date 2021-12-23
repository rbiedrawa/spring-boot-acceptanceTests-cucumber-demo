@Transactional # comment @transactional to see that rollback feature will not work
Feature: Hello Page
  As a product manager
  I want to welcome our customers when they visit our site
  So that they see a warm, friendly message

  @HelloService
  Scenario: Customer opens welcome page
    Given customer: John Doe
    And database is empty
    When customer visits home page
    Then customer should see the welcome message
      | message         |
      | Hello John Doe! |

#  @Disabled  # uncomment to disable test
  @Slow #  to run only this test: ./gradlew acceptanceTest -Dcucumber.filter.tags="@Slow"
  @HelloService
  Scenario: Customer2 opens welcome page
    Given customer: Jane Doe
    And database is empty
    When customer visits home page
    Then customer should see the welcome message
      | message         |
      | Hello Jane Doe! |
