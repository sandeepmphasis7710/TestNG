Feature: Login to HRM Application

  Background:
    Given Open Base URL

  @ValidCredentials
  Scenario: Login with valid credentials
  When User Logs in
  Then User Logs Out

