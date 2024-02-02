# Task
 Implement a REST API that calculates the frequency of occurrence of characters for a given string. The result should be sorted in descending order of the number of occurrences of the character in the given string.
# Requirements
+ JDK 18
+ Java 8+
+ Spring boot 2+
+ Maven 3

# Running the application
+ Clone the reposotory
```bash
git clone https://github.com/Prigozhaeva-Anastasia/calculatorOfOccurrenceFrequencyCharsInString.git
```
There are several ways to run this app:

+ Run the app using maven
```bash
cd calculatorOfOccurrenceFrequencyCharsInString
mvn spring-boot:run
```
+ Run the application by executing the `main` method in the `com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.CalculatorOfOccurrenceFrequencyCharsInStringApplication` class from your IDE

The app wil start running at http://localhost:8080

# Explore Rest APIs
The app defines following APIs

+ GET /api/calcFrequency/{str}

| Parameter       | Description             | Limitation|
| ------------- |:--------------|:------------------|
|`str` |A string of characters from which the frequency of occurrence of identical characters contained in it will be calculated. |<li>not empty <li>str.length <= 10000|

# Get the frequency of occurrence of characters in a string

### Request

`GET /api/calcFrequency/{str}`

Example: `/api/calcFrequency/aaaaabcccc`

### Response

    {"a":5,"c":4,"b":1}

# Rest API Error Responses

1-GET-HTTP Response Code: 400

### Request

`GET /api/calcFrequency/ `

### Response

    {
        "status": 400,
        "message": "calcOccurrenceFrequencyCharsInString.str: must not be blank"
    }

2-GET-HTTP Response Code: 400

### Request

`GET /api/calcFrequency/aaaaaaaa...`

### Response

    {
        "status": 400,
        "message": "calcOccurrenceFrequencyCharsInString.str: size must be between 0 and 10000"
    }

