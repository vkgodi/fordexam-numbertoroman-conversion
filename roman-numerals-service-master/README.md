# roman-numerals-service

A java web service to convert integers to roman numeral strings and also it converts from numeral string to integers

Does not support numbers greater than 10 million (10000000). Requests for conversion of numbers greater than 10 million will result in a 400 bad request with an informative error message.

And Second endpoint will convert from Roman to Numeral up to 3000

## Usage 

This service endpoint is `/romannumeral` and can be used as follows:

* Request: `GET http://localhost:8080/romannumeral?query=12` 
* Response: `{ numeral: 12, romanNumeral: "XII" }`

* Request: `GET http://localhost:8080/romannumera?query=1.5`
* Response: `400 BAD_REQUEST`

second service endpoint is `/romantonumeral` and can be used as follows:

The below endpoint will convert Roman Numeral to Integers. 

* Request: `GET http://localhost:8080/romantonumeral?query=XII` 
* Response: `{ romanNumeral: "XII",numeral: 12 }`

* Request: `GET http://localhost:8080/romantonumeral?query=`
* Response: `400 BAD_REQUEST`

* `/actuator`
* `/actuator/health`
* `/actuator/info`
* `/actuator/metrics`Also available are the following `spring boot actuator` endpoints:

* `/actuator/httptrace`

## Build and Test Instructions

* Build and test with `./gradlew build`
* Run service with `./gradlew run`

## Dependencies

Gradle and Java:
```
------------------------------------------------------------
Gradle 5.3
------------------------------------------------------------

Build time:   2019-03-20 11:03:29 UTC
Revision:     f5c64796748a98efdbf6f99f44b6afe08492c2a0

...
JVM:          11.0.2 (Oracle Corporation 11.0.2+9-LTS)
```

Other dependencies (refer to build.gradle):
* Spring boot web
* Sping boot actuator 
* JUnitParams

## Project Layout

* The main java service files are located in `src/main/java/romannumerals`
    * Here I've defined a simple class to convert numbers to roman numerals
    * This is also where I've chosen to put the roman numeral controller for simplicity
	* roman numeral controller contains second endpoint is use to convert the Roman Numeral to Integers.
* Test files are located in `src/test/java/romannumerals`
    * Integration tests -- useful for testing the actual service endpoint including query param binding and bad requests.
    * Unit tests -- to test roman numeral conversion logic and edge cases.
* Application config is located in `/src/main/resources/application.yml`

## Testing
* Run tests with `./gradlew test` or with `./gradlew build`
* The tests are configured to show their status in console output.

## Spec
[Roman Numeral Spec](http://mathworld.wolfram.com/RomanNumerals.html)

[Roman Numeral Spec 2](https://www.mytecbits.com/tools/mathematics/roman-numerals-converter)

Uses the Vinculum addition.

Currently does not support numbers greater than 10M (10000000)

A number can be converted to a roman numeral with the following algorithm:
* If number is 0 return
* Repeat:
    * Lookup highest key that is less than number in roman numeral map
    * Append the corresponding value to roman numeral string
    * number = number - key
A roman numeral can be converted to a number up to 3000
* if string is empty it will be return bad request to caller.	
