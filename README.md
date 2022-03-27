# Country Quiz API:

A backend Java API serving Questions and Answers used to build a Country Quiz.

https://devchallenges.io/challenges/Bu3G2irnaXmfwQ8sZkw8

## Fetching Data

Initial data on countries will be fetched from an [external API](https://restcountries.com/v3.1/all).

* Name
* Capital City
* Population
* Subregion
* Flag

## Question Builder

Programmatically generate the quiz questions from country data. 

Question contains 3 incorrect answers and one correct. 

## Tables

### Country
* ID
* Name
* Capital
* Population
* Subregion
* Flag Src

### Question
* ID
* Text
* Answer[]
* MediaSrc?

### Answer
* ID
* Text
* IsCorrect
* Question
