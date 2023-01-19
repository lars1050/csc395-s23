### Lab 02 The Strategy Pattern

In this lab, you will redesign and reimplement the collection of robots to follow the Strategy Pattern. The robot is part of a simulation in which the robot moves within a grid of a fixed size. Each type of robot has a mechanism for moving and a sensor for sensing obstacles ahead. There is the super class Robot (in the provided code, it is named RobotBad) and specialized subclasses with different combinations of locomotion and sensors. The type of locomotion is reflected in the method `move()`. The type of sensor is reflected in the method `sense()`. Subclasses override these methods when necessary. 

Currently, for locomotion a robot can be omni-direction or wheeled. Omni-directional (sometimes referred to as holonomic) means it can turn in place. The wheeled robots use differential drive, which means that it turns by turning the wheels at different rates which makes the robot move in an arc. 

Currently, for sensing a robot can have an infrared (IR) sensor, a camera, or a touch sensor. The IR and camera can detect obstacles in the distance, but not at the same distance (cameras can detect obstacles that are much farther away). A touch sensor indicates that it is in contact (or not) with an obstacle, so it cannot "see" anything at a distance.

<hr>

#### Using Bad Design

Familiarize yourself with the code, then make a new RobotBad subclass that is omni-directional and uses a touch sensor (`class OmniTouchBad`). Be sure to instantiate an OmniTouchBad robot and add to the collection in Main to ensure it is working. 

> Note: You might notice yourself copying and pasting code to create this new subclass. Copying-and-pasting code should always be a red flag indicating you might need a redesign.

Now imagine if you had 5 different sensors and 3 more forms of locomotion and you wanted to create more robots with different combinations of locomotion and sensing! That would be a lot of copying and pasting!

#### Designing Good Design

Draw a UML diagram for the Strategy Pattern. It is almost identical to the Duck UML example provided. Use an `interface` where appropriate, rather than `class`. On the UML diagram, an interface is indicated by placing `<<interface>>` above the class name. You should have a strategy (i.e. a collection of classes) for locomotion and a strategy for sensing.

There will still be a Robot base/super class. Since the mechanism for movement is fundamental to the robot, make 3 subclasses of Robot: Wheeled, Omni, and Fixed (e.g. industrial robots are fixed to a table and cannot move around the room). The sensing strategy for each robot can be part of initialization.

Submit your UML diagram along with your code.

#### Implementing Good Design

_Please leave the provided code as is and create new classes. The one exception is Main, which you can edit as discussed in the requirements below._

1. Create the collection of classes to implement the locomotion strategy. This should include a wheel, omni-directional, and fixed strategy.

1. Create the collection of classes to implement the sensing strategy. This should include an IR, camera, and touch strategy.

1. Create a new Robot class to make use of the strategies. 

Here is some code from _Head First Design Patterns_ that implements the Duck example. Your robot classes will be essentially the same in structure.

```Java
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

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

// A Subclass
public class Mallard extends Duck {
    
    public Mallard() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}
```

> Note that now rather than a duck calling `fly()`, it calls `performFly()`, but I prefer to use the method name `fly()` for both the Duck and the flyBehavior.

> Note that the behavior/strategy member variables are being set directly in the Mallard constructor. These member variables really should be private in the Duck class, which would force the subclasses to use setters and getters.


1. Create the Robot subclass Wheeled and initialize with the wheeled strategy for locomotion. Additionally, create a constructor with the sensing strategy as a parameter (i.e. `public Wheeled(Sensing strategy)`). Be sure to create setters and getters for the strategies.

1. Instantiate a wheeled robot that uses IR. Test it in Main to make sure it is all working!

1. Create 2 more Robot subclasses: Omni and Fixed. _Okay, you might want to copy and paste your Wheeled class to create these. So maybe the design needs some more work, but it is trending in the right direction._

1. Instantate an Omni and Fixed robot in Main and make sure it is all working.

1. Imagine that while operating, your wheeled robot broke. It is now a Fixed robot. Create a Wheeled robot in Main (choose any sensor) and have it move. Then "break" it so that it is fixed, and try to move again.

1. Create `class OmniTouch`, as you did above, but this time extending the Robot class and making use of the strategies. 

#### Thinking About Change

Answer the following questions in a text file.

1. Imagine that the way that you calculated motion for the wheeled robot was incorrect and now you need to fix it. Identify ALL the places in the original RobotBad design that you will have to change to fix wheeled motion. Identify all the places in the Strategy Pattern design that you will have to change to fix it.

1. Describe how using the Strategy pattern has improved your ability to enhance (or extend) a robot. Use the creation of the OmniTouchBad and OmniTouch class as an example in answering this question. 



