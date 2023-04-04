# CSC395 Population Simulation Project

Overview of the project can be found here: https://docs.google.com/document/d/1eKMajmXUndkVjtjd9d3z7GqqyxWtp6jCxN01cqiXaKU/edit?usp=sharing

This is the starter code. It will be copied into separate repositories for the separate models being built.

<hr>

Assignment for EVERYONE
  _so that you can get familiar with the framework_.

DUE THURSDAY BEFORE CLASS

1. Modify the MovementAgent class so that the user can choose the option of having agents teleport out one side of the arena and arrive back at the other (you need only do this in 1 dimension -- either left/right or top/bottom).

1. Add a checkbox to the View class for the user to select (or not select) to _teleport_.

1. Add the callback function/action to the Controller class to communicate to the MovementAgent whether or not the agent should be teleporting. The item listener manages the events of a checkbox.

1. Create a new concrete Viewable class (copy Square) and modify it to draw a different shape (see https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html for options).

1. Add the shape option to the ViewableFactory.

1. Modify the View by adding another checkbox to choose this new Viewable option for the MovementModel. (Alternatively, you can change Square to this other shape.)
