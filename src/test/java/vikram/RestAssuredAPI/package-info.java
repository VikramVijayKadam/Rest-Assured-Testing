/**
Rest Assured
------------
1. It is an API designed for automating REST services/Rest API's
2. It is avalibale in form of jar files
3. It is implemented using JAVA langaugue (class & methods --> By which we can automate API)
4. We can send multiple request, get response and different type of validation.
5. Rest Assured will only support Rest services and it cannot support SOAP services
6. Official website is available i.e., https://rest-assured.io/

Setup Pre-requistes
-------------------
1. Java Installation
2. Eclipse IDE
3. TestNG
4. Mavan (build tool)
5. Thrid part jars based upon the test case like Apache POI etc.,

POM.xml required dependecy
--------------------------
Note:- Add all dependecy, by picking from MVN Repo(i.e., https://mvnrepository.com/)
1. Rest Assured (v 4.3.3)
2. TestNG (v 7.4.0)
3. JSON-Simple(JSON.Simple v 1.1.1)
4. Apache POI (poi v 5.0.0)
5. Apache POI (poi-ooxml-schemas v 4.1.2)

API Test-Case required column's
-------------------------------
1. TestCase ID
2. Description
3. End Point
4. HTTP Method Type
5. URI
6. Body
7. Success Responce
8. Status Code
9. Comments

In this package, we will be learning below:
------------------------------------------
1. How to send request
2. How to get request
3. How to verify the status code, Status line and repsonce time etc.,
4. How to verify Header
5. How to read the response body(i,e., JSON)
6. How to verify the Authnetication API

Steps to Create a Test
----------------------
1. Define the Base URI
2. Create the Request Object
3. Create the Responce Object(i.e., will hold the data)
4. We can extract the Response Body
5. For Response and Response Body, we can do Validations


Validations like:-
----------------
1. Status Code
2. Status Line
3. Headers (Content-type, Content-length etc.,)
4. Response time


Dummy API link:-
--------------
http://dummy.restapiexample.com/


 */
/**
 * @author Vikram Vijay Kadam
 *
 */
package vikram.RestAssuredAPI;