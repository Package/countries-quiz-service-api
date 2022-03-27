# Country Quiz API

A backend Java API serving Questions and Answers used to build a Country Quiz.

Can be used as a backend for the [Country Quiz Dev Challenge](https://devchallenges.io/challenges/Bu3G2irnaXmfwQ8sZkw8)

## Documentation

API Documentation is [available here](https://countries-quiz-service-api.herokuapp.com/swagger-ui/index.html).

## Development

To run the API locally, you can use [Docker](https://www.docker.com/)

Starting the API: `./api-start.sh`

API will then be running at: `http://localhost:5000`

Stopping the API: `./api-stop.sh`

## Seeding Data

Data on countries will be fetched from an [external API](https://restcountries.com/v3.1/all) on initial boot, and then
a set of questions/answers are programmatically generated.

### Question Examples

####  CAPITAL_CITY 
     Abu Dhabi is the capital of which country?
####  POPULATION 
     Which of these countries has a population of 62,999?
####  REGION 
     Which of these countries is in Southern Europe?
####  FLAG
     Which country does this flag belong to?
#### LANGUAGE 
     In which country is Arabic a primary spoken language?
#### DOMAIN_EXTENSION 
     Which country uses .ge as their Internet Domain?
