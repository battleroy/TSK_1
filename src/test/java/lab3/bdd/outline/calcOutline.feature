Feature: Outlined
  Scenario Outline: Calc
    When I enter <arg1>, <sign> and <arg2>
    Then I expect <result>
    Examples: -
    | arg1 | sign | arg2 | result |
    | 3    |   +  | 4    | 7      |
    | 5    |   -  | 3    | 2      |
    | 2    |   ×  | 4    | 8      |
    | 8    |   ÷  | 4    | 2      |