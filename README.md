# Test-TestDrivenDesign
Test Assignment 6

Assignment: https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/06%20TDD%20assignment.pdf

Slides and information: 
- https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Slides/06%20TDD.pdf

Demos:
- https://github.com/datsoftlyngby/soft2019spring-test/tree/master/Projects/MonopolyDemo

----
# Setup

The program was created using Intellij and Java SDK 11, so you might need to do the following in order to make the program work:

- Mark the "java"-folder found under "src" -> "main" as the "source"-folder
-   Right-click on the "java"-folder, select the "Mark Directory as.." and finally select the (blue) "Source Root"
- Similar with the (test) "java"-folder, found under "src"-> "test"
-   Right-click on the (test)"java"-folder, select the "Mark Directory as.." and finally select the (green) "Test Source Root"
- Select Output-folder
  - Create a new folder within the project named "out"
  - Go to File -> Project Structure... -> Project Settings -> Project -> Project Compiler output and select your out-folder
  - Hit Apply
----

# Assignment

Mario has a small pizza bar on Lyngby Hovedgade that sells take away
pizzas. He would like some help tracking the orders and would like a small IT
system to handle the orders.

After a short meeting with Mario, we know this much:

*“I would always like to see a list of the orders and when they are going to be
picked up.* 

*I have over 30 different pizzas, and most customers call and order an hour in advance.
Some also come directly into the store. Online booking would be nice.*

*Right now, my nephew, Alfonso, receives the orders. He will take care of operating the computer. I
just need to be able to see the list of orders and somehow know which pizza is to be made as the
next one. Maybe one could sort them by time. I do not know. As long as it is easy for me, it is fine.
When I have made a pizza, I shout to my nephew when the pizza is ready. He removes it from the
list when it is picked up and paid.*

*I would like to be able to store all the orders. That way I will be able to see the turnover, and later
make statistics on which pizzas are the most popular.* 

- Practice getting into the TDD mindset by example using both Mockist and Classic style
- Practice pair programming
- Practice working with techniques to make code testable and maintainable
- Handle dependencies in configuration file (Inversion Of Control) in order to make the
program modular and extensible by means of Dependency Injection.

Requirements:
- User dialogue – decide yourself –leave it untested for now.
- User stories
  - Enter order
  - Get all orders
  - Remove order 

-------

## User Stories

User Stories Definition: http://www.agilemodeling.com/artifacts/userStory.htm

- *I would always like to see a list of the orders and when they are going to be
picked up.*
  - The user wants to be able to se a list of orders 
  - The user wants to be able to see when orders are going to be picked up
  
- *...most customers call and order an hour in advance. Some also come directly into the store. Online booking would be nice.*
  - User wants a system that can handle both in-store and online orders
  - User wants customers to be able to orders food online
  
- *Right now, my nephew, Alfonso, receives the orders. He will take care of operating the computer. I just need to be able to see the list of orders and somehow know which pizza is to be made as the next one. Maybe one could sort them by time.*
  - User wants to see the next order, sorted by the time the order was placed, showing from oldest to newest
  
- *When I have made a pizza, I shout to my nephew when the pizza is ready. He removes it from the list when it is picked up and paid.*
  - User wants to be able to inform the "frontdesk" that the order is done and ready to be picked up
  - User wants to be able to remove finished orders from the list of orders
  
- *I would like to be able to store all the orders. That way I will be able to see the turnover, and later
make statistics on which pizzas are the most popular*  
  - User wants the system to record and show each days business 
  - User wants to be able to see statistics, such as which pizza's are the most popular
  
  -------
## The TDD mindset by using both Mockist and Classic style

- Mostly done with Classic style, since we are still trying to get our heads around how to write TDD with Mockito.
- Only very little development was done with Mockito
- Great success developing TDD using the classic style

------

## Practice pair programming

- Developed using 1 machine with a schoolmate next to me. We took turns developing and instructing each other
-----

## Practice working with techniques to make code testable and maintainable

- Heavy use of interfaces
- Tried to make all methods non-void, forcing the to return something.
- Also tried to make methods and functions use Paramaters as much as possible
- Some minor flaws with the timeStamps, due to the Thread.sleep() and the speed of the testing hardware, will have to be ironed out some how.

-----

## Handle dependencies in configuration file (Inversion Of Control) in order to make the program modular and extensible by means of Dependency Injection.

- Any changes to the original objects will inevitably force one to adapt the existing test.
- POM-file includes list of Maven dependencies.
- Very small project so hard to actually make the code more testable, but having constructors with dependencies specified, makes it easy to inject depedencies when mocking objects. In bigger java projects you could use factories or other design patterns, to make behaviour
 - Inversion of control via the package manager, so if an object requires a third party dependency, either a fake object, or a mocked object with behaviour can be used
 - A lot of time and code was spent to setup @Before in all 3 of the major test-classes, but in particular the one concering `orderManagerTest`. Combined with Methods/Functions that are used to setup data, since a lot of the test had to use the same starting data, it made sense to divide the setup functions and setup, to make the code look more clean, and take less space. 

-----
