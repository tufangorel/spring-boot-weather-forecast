## spring-boot-weather-forecast-client-api

Purpose : Use openweathermap in spring boot API <br/>

### Local run steps <br/>
1- Start Spring Boot REST API by running main method containing class WeatherForecastClientAPI.java in your IDE. <br/>
NOT : Execute maven command from where the pom.xml is located in the project directory to create Spring Boot executable jar. <br/>
<pre> 
spring-boot-weather-forecast-client-api $ mvn clean install -U -X <br/>
</pre>

swagger_ui can be accessed via http port 8082 from localhost : <br/>
http://localhost:8082/weather-forecast/swagger-ui/index.html#/ <br/><br/>
![https_swagger_ui](doc/http_localhost_8082_swagger_ui.PNG) <br/><br/>


### Tech Stack
<pre>
Java 17
H2 Database Engine
spring boot
spring boot starter data jpa
spring boot starter web
spring boot starter test
springdoc openapi ui
springfox swagger ui
logback
maven
mockito-core
mockito-junit-jupiter
mockito-inline
</pre>


## API OPERATIONS
### Save a new customer to database

Method : HTTP.POST <br/>
URL : https://localhost:8443/customer-info/customer/saveprogrammatic <br/>
HTTP Request Body : <br/>
<pre>
{
    "name": "name1",
    "age": 1,
    "shippingAddress": {
        "address": {
            "streetName": "software",
            "city": "ankara",
            "country": "TR"
        }
    }
}
</pre>

Curl Request : <br/>
<pre>
curl --location --request POST 'https://localhost:8443/customer-info/customer/saveprogrammatic' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "name1",
    "age": 1,
    "shippingAddress": {
        "address": {
            "streetName": "software",
            "city": "ankara",
            "country": "TR"
        }
    }
}'
</pre><br/>

Response :

HTTP response code 200 <br/>
<pre>
{
    "id": 1,
    "name": "name1",
    "age": 1,
    "shippingAddress": {
        "id": 1,
        "address": {
            "id": 1,
            "streetName": "software",
            "city": "ankara",
            "country": "TR"
        }
    }
}
</pre>

HTTP Response Headers : </br>
<pre>
request-id: 68182bbf-996d-4732-a6ff-2c49a90012d1
correlation-id: 68182bbf-996d-4732-a6ff-2c49a90012d1
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
</pre>

### List all customers saved to database

Method : HTTP.GET <br/>
URL : https://localhost:8443/customer-info/customer/list <br/>
Request Body : <br/>
<pre>
{}
</pre>
Curl Request : <br/>
<pre>
curl --location --request GET 'https://localhost:8443/customer-info/customer/list' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=5E6B21C9533643F4A7EE462DCBB3B312' \
--data-raw '{}'
</pre>
<br/>

Response :

HTTP response code 200 <br/>
<pre>
[
    {
        "id": 1,
        "name": "name1",
        "age": 1,
        "shippingAddress": {
            "id": 1,
            "address": {
                "id": 1,
                "streetName": "software",
                "city": "ankara",
                "country": "TR"
            }
        }
    }
]
</pre>
<br/>
HTTP Response Headers : </br>
<pre>
request-id: 411b4b33-6af5-4f78-b185-4171e779222d
correlation-id: 411b4b33-6af5-4f78-b185-4171e779222d
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
</pre>