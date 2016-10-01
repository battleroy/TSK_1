Feature: Outlined Convert
  Scenario Outline: Convert
    Given Convert mode is '<mode>'
    Given Source unit is '<from>'
    Given Target unit is '<to>'
    When Convert from value is <fromValue>
    Then I expect result to be <result>
    Examples: -
      | mode   | from       | to          | fromValue | result       |
      | Length | Kilometer  | Mile        | 123       | 76.428371703 |
      | Area   | Hectare    | Square Yard | 10        | 119599.00463 |
      | Time   | Second     | Week        | 123       | 0.000203373  |
      | Weight | Metric Ton | Ounce       | 1         | 35273.990723 |