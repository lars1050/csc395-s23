### Lab 02 The Strategy Pattern

In this lab, you will redesign and reimplement the collection of robots to follow the Strategy Pattern. The robot is part of a simulation in which the robot moves within a grid of a fixed size. Each type of robot has a mechanism for moving and a sensor for sensing obstacles ahead. There is the super class Robot and specialized subclasses with different combinations of locomotion and sensors. The type of locomotion is reflected in the method `move()`. The type of sensor is reflected in the method `sense()`. Subclasses override these methods when necessary. 

Currently, for locomotion a robot can be omni-direction or wheeled. Omni-directional (sometimes referred to as holonomic) means it can turn in place. The wheeled robots use differential drive, which means that it turns by turning the wheels at different rates which makes the robot move in an arc. 

Currently, for sensing a robot can have an infrared (IR) sensor, a camera, or a touch sensor. The IR and camera can detect obstacles in the distance, but not the same distance. A touch sensor indicates that it is in contact (or not) with an obstacle.

<hr>

#### Using Bad Design

Familiarize yourself with the code, then make a new Robot subclass that is omni-directional and uses a touch sensor (`class OmniTouch`). Be sure to instantiate an OmniTouch robot and add to the collection in Main to ensure it is working. 

> Note: You might notice yourself copying and pasting code to create this new subclass. Copying-and-pasting code should always be a red flag indicating you might need a redesign.

Now imagine if you had 5 different sensors and 3 more forms of locomotion and you wanted to create more robots with different combinations of locomotion and sensing! That would be a lot of copying and pasting!

#### Designing Good Design

Draw a UML diagram for the Strategy Pattern. It is almost identical to the Duck UML example provided. Use an `interface` where appropriate, rather than `class`. On the UML diagram, an interface is indicated by placing `<<interface>>` above the class name. You should have a strategy (i.e. a collection of classes) for locomotion and a strategy for sensing.

There will still be a Robot class. Since the mechanism for movement is fundamental to the robot, make 3 subclasses of Robot: Wheeled, Omni, and Fixed (e.g. industrial robots are fixed to a table and cannot move around the room). The sensing strategy for each robot can be part of initialization.

Submit your UML diagram along with your code.

#### Implementing Good Design

1. Create the collection of classes to implement locomotion strategy. This should include a wheel, omni-directional, and fixed strategy.

1. Create the collection of classes to implement sensing strategy. This should include IR, camera, and touch.

1. Modify the Robot class to make use of the strategies. Here is some code that implements the Duck example:

```Java
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }
}

// One example of a behavior
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I use my wings to fly!");
    }
}
```
> Note that now rather than a duck calling `fly()`, it calls `performFly()`, but you could choose to have a `fly()` method in both the Duck and the flyBehavior.


1. Create the subclass Wheeled and initialize with the wheeled strategy for locomotion. Additionally, create a constructor with the sensing strategy as a parameter (i.e. `public Wheeled(Sensing strategy)`).

1. Instantiate a wheeled robot that uses IR. Test it in Main to make sure it is all working!

1. Create 2 more subclasses: Omni and Fixed. _Okay, you might want to copy and paste your Wheeled class to create these. But I think the design is good even though you are copying and pasting._

1. Instantate an Omni and Fixed robot in Main and make sure it is all working.

1. Imagine that while operating, your wheeled robot broke. It is now a Fixed robot. Create a Wheeled robot in Main (choose any sensor) and have it move. Then "break" it so that it is fixed, and try to move again.

#### Thinking About Change

Answer the following questions in a text file.

1. Imagine that the way that you calculated motion for the wheeled robot was incorrect and now you need to fix it. Identify ALL the places in the original design that you will have to change to fix wheeled motion. Identify all the places in the Strategy Pattern design that you will have to change to fix it.

One Design Principle that this is demonstrating is "Favor composition over inheritance". You did use 



