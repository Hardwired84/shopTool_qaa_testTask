Feature: ShopTool Events testing

  Background:
    Given I open ShopTool Main page

  Scenario Outline: Discounts checking
    Given I click on "Электроинструмент" menu item and wait for "<page_identifier>" page loaded
    Then I check "<page_identifier>" page is "opened"
    When I click on "Перфораторы" link on 'Электроинструмент' wait for "<sub_page_identifier>" page loaded
    Then I check "<sub_page_identifier>" page is "opened"
    When I select and click on random "1" item with discount on "Перфораторы" page
    Then I check items card is "opened"
    Then I check items price with discount is "displayed" on items card
    Then I check items old price is "displayed" on items card
    When I return on previous page
    Then I check "<sub_page_identifier>" page is "opened"
    And I click on "Вперед" button
    Then I check "<sub_page_identifier>" page is "opened"
    When I select and click on random "1" item with discount on "Перфораторы" page
    Then I check items card is "opened"
    Then I check items price with discount is "displayed" on items card
    Then I check items old price is "displayed" on items card
    Examples:
      | page_identifier   | sub_page_identifier |
      | Электроинструмент | Перфораторы         |

  Scenario Outline: Cart checking
    Given I click on "Электроинструмент" menu item and wait for "<page_identifier>" page loaded
    Then I check "<page_identifier>" page is "opened"
    When I click on "Дрели" link on 'Электроинструмент' wait for "<sub_page_identifier>" page loaded
    Then I check "<sub_page_identifier>" page is "opened"
    When I click on "Дрель ударная ВИТЯЗЬ ВИДЭУ-1300" on "Дрели" page
    Then I check items card is "opened"
    When I add an item to cart
    And I wait for modal dialog is loaded
    Then I check the modal dialog is "displayed"
    When I click on "<button_footer>" footer button
    Then I check the modal dialog is "not displayed"
    Then I check "<sub_page_identifier>" page is "opened"
    When I click on "Вперед" button
    Then I check "<sub_page_identifier>" page is "opened"
    When I click on "Дрель ударная 750 Вт Sturm ID21750" on "Дрели" page
    Then I check items card is "opened"
    When I add an item to cart
    And I wait for modal dialog is loaded
    Then I check the modal dialog is "displayed"
    When I click on "<button_footer>" footer button
    Then I check the modal dialog is "not displayed"
    Then I check "<sub_page_identifier>" page is "opened"
    When I click on header button "Корзина" on "<sub_page_identifier>"
    Then I check the count of items in the cart equal "2" on "<sub_page_identifier>"
    Examples:
      | page_identifier   | sub_page_identifier | button_footer      |
      | Электроинструмент | Дрели               | Продолжить покупки |

  Scenario Outline: Procraft checking
    Given I click on "Электроинструмент" menu item and wait for "<page_identifier>" page loaded
    Then I check "<page_identifier>" page is "opened"
    When I click on "Перфораторы" link on 'Электроинструмент' wait for "<sub_page_identifier>" page loaded
    Then I check "<sub_page_identifier>" page is "opened"
    When I search for "Procraft" item on "<sub_page_identifier>"
    Then I check "<sub_page_identifier_1>" page is "opened"
    Then I check that for each searched item on "<sub_page_identifier_1>" the Procraft label is "displayed"
    When I click on random "1" item on "<sub_page_identifier_1>" page
    Then I check items card is "opened"
    When I return on previous page
    Then I check "<sub_page_identifier_1>" page is "opened"
    And I click on "2" button
    Then I check "<sub_page_identifier_1>" page is "opened"
    Then I check that for each searched item on "<sub_page_identifier_1>" the Procraft label is "displayed"
    When I click on random "1" item on "<sub_page_identifier_1>" page
    Then I check items card is "opened"
    When I return on previous page
    Then I check "<sub_page_identifier_1>" page is "opened"
    And I click on "3" button
    Then I check "<sub_page_identifier_1>" page is "opened"
    Then I check that for each searched item on "<sub_page_identifier_1>" the Procraft label is "displayed"
    When I click on random "1" item on "<sub_page_identifier_1>" page
    Then I check items card is "opened"
    Examples:
      | page_identifier   | sub_page_identifier | sub_page_identifier_1 |
      | Электроинструмент | Перфораторы         | Результаты поиска     |

  Scenario Outline: Price checking
    Given I click on "Электроинструмент" menu item and wait for "<page_identifier>" page loaded
    Then I check "<page_identifier>" page is "opened"
    When I click on "Дрели" link on 'Электроинструмент' wait for "<sub_page_identifier>" page loaded
    Then I check "<sub_page_identifier>" page is "opened"
    When I select and click on random "1" item with discount on "<sub_page_identifier>" page
    Then I check items card is "opened"
    Then I check items price with discount is "displayed" on items card
    Then I check items old price is "displayed" on items card
    Then I check the discounted price is less then old price
    Examples:
      | page_identifier   | sub_page_identifier |
      | Электроинструмент | Дрели               |