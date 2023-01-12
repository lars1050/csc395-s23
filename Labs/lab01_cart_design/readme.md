### Lab 01 - Good Design

Submit via Moodle 
Submit code and your answers to the questions (in a zipped file)

This example demonstrates bad design. There are many things wrong with respect to the design principles of coupling, cohesion, and encapsulation. The interface of the class is integral to the quality of the design.

Some key ideas for this software:
- There is a cart of items that are part of an order for a customer.
- Each item has a price and a quantity.
- Customers have a name, email address, and phone number.
- To "checkout", a total must be calculated for all items in the cart. There might be sales tax associated with the items.
- It is not a part of this, but one can imagine that items are in a database, and somehow one is selected and placed in the cart. You do not neet to model this part -- just provide a means to easily add an item to the cart.

**Question 1**

For each of the following code characteristics, identify a place in the code where it is a counter-example to good design. 

- loose coupling. What is an example in the code where classes are too tightly coupled?
- strong cohesion. What is an example in the code where a class is not cohesive?
- encapsulated. What is an example in the code where data is not encapsulated (meaning it is not managed within the class)?

**Question 2**

Style guides set standards for formatting and organizing code. In Java, member variables should use camelCase (starting with a lowercase letter) and be private or protected. There are several member variables that do not comply to this style. Change a few of them and note the ripple affect. What are some the ways throught code design that you can prevent these ripple effects from happening (meaning changes are isolated). You can give specific examples or talk more generally.

**Question 3**

Use a UML diagram to sketch out a restructuring of the classes. Include an image of the diagram. Comment on a few key design decisions. Be sure to comment on how the design is addressing the problems you identified above with at least one of cohesion, coupling, or encapsulation.

<hr>

### Implement Your Design

1. Implement the changes that you sketched in your UML diagram. Be sure to comment your code and keep it style compliant.

2. And now that your design is fixed, it should be relatively easy (or at least easier) to enhance functionality! Add functionality in which only some items incur a sales tax. The item should keep track of whether or not a sales tax should be charged.


