## COMMAND Design Pattern

> Work in groups of 2 or 3 (NO MORE THAN THAT). And you must work with someone or you will not get credit for this.

Please complete this exercise over the next 2 class periods and submit via github on one of your group member's repo (under exercises).

The command design pattern creates a generic interface to invoke the methods of various classes/objects by binding the generic interface to the specific commands/methods of the object.

We will explore this topic through the creation of a remote control, similar to that presented in _Head First Design Patterns_.

All of the classes are contained within a single file. You know from your project experience that it should NOT be organized in this way. This is for your convenience and for ease of navigation and modification as you learn this pattern.

Each of the main#.cc files advances the design of the remote control. As you work on each file, modify the makefile in the *2 places* that indicate the input file (e.g. change _main.o_ to _main2.o_).

Each pass through the design is meant to highlight strengths and weaknesses of that design. Some are not complying with the requirements of a generalized interface. We will discuss each pass after everyone has completed the exercise.

### main.cc

This is the first pass at design. The different functionality of the buttons is implemented using conditional statements. There are a collection of 9 buttons (5 circles, 2 up and 2 down triangles). There are 2 devices to control: a stereo and a tv. Currently, PowerOff is not implemented for either the stereo of the tv.

COMPILE. RUN.

1. IMPLEMENT PowerOff and bind the appropriate remote buttons to powering off the tv and stereo (comments in code state which buttons to bind).

COMPILE. RUN.

### main2.cc

This is the second pass at design. Implement the different functionality using *Commands* and a "dictionary" that binds a button to a command. Commands are bound to a specific device and specific functionality. Notice how the interface has been standardized across the devices.

COMPILE. RUN.

1. IMPLEMENT the class CommandOff and use it to implement the button functionality to power off the tv and stereo.

2. Modify the makefile (in 2 places) to compile make2.cc

COMPILE. RUN.

### main3.cc

This is the third pass at design. Use a parent class for the devices. This doesn't do much for us YET. The command interface is a little bit simpler.

COMPILE. RUN.

1. IMPLEMENT the class CommandOff and use it to implement the button functionality to power off the tv and stereo.

2. Modify the makefile (in 2 places) to compile main3.cc

COMPILE. RUN.

### main4 and Finally, the COMMAND pattern

1. Copy main3.cc to main4.cc

2. Replace all the virtual methods of the class Command with a single virtual method void Execute().

3. For each of the subclasses of Command (CommandOn, CommandOff, CommandAdvance), replace the specific method names (e.g. On()) with Execute().

4. Define Remote::ButtonPressed as follows:

```
void ButtonPressed(Buttons b) {
  button_dictionary_[b]->Execute();
}
```

5. Modify the makefile (in 2 places) to compile your main4.cc

COMPILE. RUN.

6. Now that that is working, add the functionality for volume control for the stereo.

COMPILE. RUN.
