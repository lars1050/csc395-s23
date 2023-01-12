### Lab 01 - Good Design

<h4> DUE: Tuesday, January 17 at 5 pm.
<br>Submit via Moodle
<br>Submit code and your answers to the questions (in a zipped file)
</h4>

This example demonstrates bad design. There are many things wrong with respect to the design principles of coupling, cohesion, and encapsulation. The interface of the class is integral to the quality of the design, and it is something you should think carefully about.

Some key points about this software:
- The collection of classes should facilitate shopping, so that a customer can have a "cart" as part of an order.
- Each item has a price and a quantity.
- Customers have a name, email address, and phone number.
- To "checkout", a total must be calculated for all items in the cart. There might be sales tax associated with the items.
- It is not a part of this, but one can imagine that items are in a database, and somehow one is selected and placed in the cart. You do not neet to model this part -- just provide a means to easily add an item to the cart.

<hr>

### Thinking About the Design

**Question 1**

For each of the following code characteristics, identify a place in the code where it is a counter-example to good design. 

- __Loose Coupling__: What is an example in the code where classes are too tightly coupled?
- __Strong Cohesion__: What is an example in the code where a class is not cohesive?
- __Encapsulation__: What is an example in the code where data is not encapsulated (meaning it is not managed within the class)?

**Question 2**

Style guides set standards for formatting and organizing code. In Java, member variables should use camelCase (starting with a lowercase letter) and be private or protected. There are several member variables that do not comply to this style. Change a few of them and
  - Describe some of the ripple effects. 
  - What are some of the ways through code design that you can prevent these ripple effects (i.e. isolate code changes). You can give specific examples or talk more generally.

**Question 3**

Use a UML diagram to sketch out a restructuring of the classes. Include an image of the diagram. Comment on a few key design decisions. Be sure to comment on how the design is addressing the problems you identified above with at least one of cohesion, coupling, or encapsulation.

It might be useful to list all of the information that needs to be stored, when that information needs to be created, and what classes need access to that information.

<hr>

### Implement Your Design

1. Implement the changes that you sketched in your UML diagram. Be sure to comment your code and keep it style compliant. Please include a Main.java to demonstrate use of your classes.

2. And now that your design is fixed, it should be relatively easy (or at least easier) to enhance functionality! Add functionality in which only some items incur a sales tax. The item should keep track of whether or not a sales tax should be charged.


