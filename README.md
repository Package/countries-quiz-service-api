# Country Quiz API

A backend Java API serving Questions and Answers used to build a Country Quiz.

Can be used as a backend for the [Country Quiz Dev Challenge](https://devchallenges.io/challenges/Bu3G2irnaXmfwQ8sZkw8)

## Documentation

API Documentation is [available here](https://countries-quiz-service-api.herokuapp.com/swagger-ui/index.html).

## Deployment

The API is deployed on a free Heroku Dyno [accessible here](https://countries-quiz-service-api.herokuapp.com/) which sleeps if unused for 30 minutes. 

This means you may need to wait ~10 seconds while the server boots up if it hasn't been accessed in awhil.e


## Local Setup

To run the API locally, you can use [Docker](https://www.docker.com/) if you don't have Java or Postgres installed.

Starting the API: `docker-compose up`

API will then be running at: `http://localhost:5000`

Stopping the API: `docker-compose down`

---
To re-build the containers: `docker-compose up --build`

To run in detached mode (no console output): `docker-compose up -d`

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
