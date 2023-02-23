### Lab 6 Simulator using Model-View-Controller

#### Due Thursday, March 2 end-of-day

Google Slides highlighting Patterns in MVC <a href="https://docs.google.com/presentation/d/19z4uZcdnpBo3qjCyGMbbVnhhppTfOvCH2SdQcUFxNVE/edit?usp=sharing" target="_blank">THIS LINK</a>.

<hr>

Model-View-Controller (MVC) is a _compound_ design pattern, meaning that it puts together several patterns in a single application. There is a nice overview here: https://www.freecodecamp.org/news/the-model-view-controller-pattern-mvc-architecture-and-frameworks-explained/. And if you google it, you will find many, many articles and tutorials on MVC. This is the image from that site:

<img src="MVC.png"  width="400">

In the code provided for today's lesson, we will make use of the MVC components provided through the javax.swing package. This graphics package provides a dizzying array of functionality for creating GUI's and 2d graphics applications. Here are some of the many resources devoted to learning about graphics using swing:
- <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html" target="_blank"> Official documentation.</a>
- <a href="https://www.javatpoint.com/java-swing" target="_blank"> Javatpoint tutorial</a>
- <a href="https://www.cs.cmu.edu/~pattis/15-1XX/15-200/lectures/view/" target="_blank">A lesson as part of a course at Carnegie Mellon University.</a>
- <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html" target="_blank">Oracle tutorials about radio buttons, sliders, and menus</a> (at the bottom of the page, click on the "How to ..." link).

#### The Model

The _Model_ is a collection of moving circles created and controlled in `class CircleModel`. These circles can represent a variety of systems that we can simulate. For example, they could simulate the spread of a disease, molecules, flocking behavior of birds, robots moving in an environment, planets, etc. The `class CircleModel extends Thread` that runs an infinite loop. The circles are moved at each time step, whose frequency is set by the user (within a range). At each time step, each circle is moved some distance in some direction (determined by member variables set randomly at instantiation). The model has (almost) no awareness of the graphics being displayed. It can be in a state of "play" or "pause" using the Controller.

The primary data structure for the model is an `ArrayList<Circle>`. There are 20 circles in the list, but only "count" of them are visible in the window. This was done so that the circles could be added to the graphics environment one time at set-up. Eventually, we will decouple the ArrayList from this restriction due to the Viewer.

#### The View

The _View_ is a GUI with user options for controlling the model, as well as the display of the moving circles. The _View_ is created and managed in `class SimulationGUI`. For now, the user-controls and simulation display all exist in a single JFrame, but future versions will likely make those into separate entities/classes. 

The user has the following options:
- Setting the number of circles (between 2 and 20) that are in the simulation.
- Speed of the simulation (between 1 and 5, slow to fast). This controls how fast the circles move.
- The `Setup` Button sets the environment based on the circle count and speed.
- The `Play` Button starts the simulation.
- The `Stop` Button pauses the simulation.

You can review all the creation of these components in `class SimulationGUI`. At instantiation, the GUI receives the _Controller_ and the _Model_. It binds the "actionable" elements of the GUI to the controller (i.e. the buttons and text fields). It gets the circles from the _Model_ to add to the Simulation display.

#### The Controller 

The _Controller_ is the go-between for the Model and the View. It is created and managed by `class Controller`. It `implements ActionListener`, meaning it _listens_ for user-interactions with the GUI, and updates the Model based on those actions. The Controller is the only object instantiated in Main. It creates the Model and the View. The View binds its action components to the Conroller (e.g. `this.restart.addActionListener(control);`). The `actionPerformed` method is called (not visible to you!) whenever a user interacts with the GUI, and you define how that action is managed. Currently, all actions update the simulation. At some point, we will create actions that modify the GUI (e.g. present different user options or change the play area).

<hr>

### YOUR TASK

1. Modify the Model to keep each Circle in the display area. When the `step()` method of the Circle is called, its position is changed. Check that the new position is in range. If it is not, change the direction so that it reflects off of the boundary.

1. Modify the View and Controller to add some actionable component. Anything that modifies the Model will do! Be sure to _listen_ for the action, and update the Model as appropriate. Try something new! Look at the Tutorial (https://www.javatpoint.com/java-swing) and all the elements listed on the left sidebar. You will see things like JCheckbox, JRadioButton, and JSlider, all actionable components.  

1. Add `boolean overlaps(Circle other)` to the Circle class. 

1. Modify the Model to find overlapping circles and do something when they overlap. They could bounce off each other, change color, mix colors, consume the other and change size, etc. Your choice! You will probably want a nested loop that compares each element to every element to its "right" to see if it overlaps with it. 

1. Create a different _strategy_ or behavior for when the circles collide or overlap. _You know where this is going!_ It seems more appropriate that the strategy would be a feature of the model, as opposed to the Circle. Think about how to apply the Strategy Pattern to the model, in which different strategies will change the circle features or behavior in different ways when they overlap. Recall that you created a strategy interface and then a concrete class for each specific strategy. In the Model, you will have a member variable for this strategy. A strategy will modify one or both of the circles that are colliding in some way (by calling their setters -- feel free to make new functions in Circle as needed).

1. Add a GUI element that allows the user to select the strategy and adjust the Model accordingly.

<hr>

**Some challenges to think about:**

- If the circles pass through each other, they will overlap over several time steps. Does your collision effect need to happen just 1 time or is it something that continuously occurs as long as the circles are overlapping?

- When should the effects of the collision take effect? If there are multiple circles colliding at once, should the changes not happen until all collisions have been determined?

- If the population of circles is very large, the nested loop to check for collisions could be very time consuming. Are there ways to reduce the runtime?













