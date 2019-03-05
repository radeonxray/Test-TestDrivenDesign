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

- Mark the "src"-folder as the "source"-folder
- Right-click on the "src"-folder, select the "Mark Directory as.." and finally select the (blue) "Source Root"
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
  
  
