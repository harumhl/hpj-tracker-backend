# hpj-tracker-backend

#### If there are too many connections to the Heroku's PostgreSQL db (20 allowed)
heroku pg:killall --app hpj-tracker

#### cURL with credentials
curl -i --user <username>:<password> http://localhost:8080

#### Swagger
http://localhost:8080/swagger-ui.html

### To deploy to Heroku
https://dashboard.heroku.com/apps/hpj-tracker/deploy/github
