Feature: Convert
  Scenario: cm to m
    Given Mode is 'Length'
    Given From unit is 'Centimeter'
    Given To unit is 'Meter'
    When From value is 5200
    Then To value should be 52
  Scenario: celsius to kelvin
    Given Mode is 'Temperature'
    Given From unit is 'Celsius'
    Given To unit is 'Kelvin'
    When From value is 39
    Then To value should be 312.15
  Scenario: US Gallon to US Pint
    Given Mode is 'Volume'
    Given From unit is 'US Gallon'
    Given To unit is 'US Pint'
    When From value is 123
    Then To value should be 984