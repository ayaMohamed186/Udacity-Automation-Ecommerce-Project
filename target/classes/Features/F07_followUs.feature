@Smoke

Feature: F07_followUs | users could open followUs links
  Scenario: user opens facebook link
  Given user opens facebook link
  Then verify that correct facebook link is opened in new tab

  Scenario: user opens twitter link
  Given user opens twitter link
  Then verify that correct twiiter link is opened in new tab

  Scenario: user opens rss link
  Given user opens rss link
  Then verify that correct rss link is opened in new tab

  Scenario: user opens youtube link
  Given user opens youtube link
  Then verify that correct youtube link is opened in new tab