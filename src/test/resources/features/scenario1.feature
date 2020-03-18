Feature: Mercury Demo Site Automation Using Cucumber and pageFactory model

  Background: 
    Given Launch Browser Chrome in Local environment.
    Given Navigate to Home Page "http://newtours.demoaut.com/"

  Scenario: Mercury Demo Site - End-To-End Flow
    #Given Navigate to Home Page "http://newtours.demoaut.com/"
    When Validate Login screen
    And Login to Mercury Site using username as "mercury" and password as "mercury"
    Then Login "Pass"
    Given Select Trip as "Round Trip"
    Given Select number of passenger from list is "4"
    Given Departing from "Sydney" on date, month "November" day "31"
    Given Arriving In "London" return date, month "December" day "30"
    Given Ticket Preference "First class" and select airline from list "Unified Airlines"
    Then continue to select flight
