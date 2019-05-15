# Back-End for Shopping Website( E-Com)


<p>Welcome to Anshul Sharma's program for a Java Backend for an E-Commerce Website displaying CRUD operations.</p>
<ul>
	<li>Display, Add, Delete, Update Products</li>
	<li>Order, Display Orders</li>
</ul>

<p>Please note that while these examples work, features not called out above are not intended to be taken and used in production business applications.</p>  

<p>Certain concerns are not addressed at all in my sample.</p>

<p>Therefore there are certain instances where we might forgo a more complicated implementation (e.g. robust error handling).</p>

## Table of Contents

* [Technology Used](#Technology)
* [First Use Instructions](#first-use-instructions)
* [Testing the code](#Testing-the-code)
* [Project Structure](#project-structure)


## Technology

In order to successfully implement and test I have used:

1. Java
2. Postman- For Testing
3. SpringBoot
4. MySQL - For Database
5. JPA - for database Communication

## First Use Instructions

1. Clone the GitHub repo to your computer
2. Import the project in Eclipse or any other IDE of your choice
3. Create Sql Database Using Ecom.sql File
4. Run as SpringBoot Project

Note: If you do not want to use maven, just import the project and add the jars to your project externally.

## Testing the code

You can Test the code using Postman using TomCat server, Input can be given as JSON Entities

1. Post Request: http://localhost:8080/addItem, Input: Json Object with Fields: itemName,itemPrice,itemQuantity
2. Get Request: http://localhost:8080/showItems
3. Get Request: http://localhost:8080/showItemsById/{id}
4. Delete Request:http://localhost:8080/deleteItemById/{id}
5. Post Request: http://localhost:8080/updateItem, Input: Json Object with Fields: itemId,itemName,itemPrice,itemQuantity
6. Post Request: http://localhost:8080/addOrder, Input: Json Object with Fields:emailId,itemId,orderQuantity
7. Get Request: http://localhost:8080/showOrders
7. Get Request: http://localhost:8080/showOrdersById/{id}

Note: replace {id} with a numeric value in the database


## Project Structure
 **Standard Java coding structure is used for the app**

* Java code is located under src/main/java/com/practice 
* Mysql Data File is also available in the Ecom Folder, import it in a database 
