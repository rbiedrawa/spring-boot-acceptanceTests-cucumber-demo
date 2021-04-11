Feature: Hello Page
  As a product manager
  I want to welcome our customers when they visit our site
  So that they see a warm, friendly message

  @HelloService
  Scenario: Customer opens welcome page
    Given customer: John Doe
    When customer visits home page
    Then customer should see the welcome message
      | message     |
      | Hello John Doe! |

#  @Disabled
  @HelloService
  Scenario: Customer2 opens welcome page
    Given customer: Jane Doe
    When customer visits home page
    Then customer should see the welcome message
      | message     |
      | Hello Jane Doe! |