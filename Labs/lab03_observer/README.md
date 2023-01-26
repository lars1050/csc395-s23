### Lab 03 The Observer Pattern

In this lab, you will design and implement the Observer Pattern. In the Observer Pattern there is a subject that pushes information out to an observer. Observers register (and unregister) themselves with the subject. This forces a "push" of information out to them whenever there is an update.

The pieces that you need to put this together are generally included in the code, but they are not organized into this pattern. 

You can work with 1 other person to develop this code. It would be a good opportunity for you to practice team development using a repo. Even if you work alone, it is a good idea to maintain a repo as a form of back-up. To submit, please zip the folder and submit via Moodle.

<hr>

Feel free to make this your own. You may change the subjects (e.g. maybe you want to output different stocks or get data from your fitBit). You can print or display information in whatever way you want. The requirement is that you have 2 subjects and 3 observers.

#### SUBJECTS

**STOCKS**. One thing that observers can watch is the stock market. The information available includes the Dow Jones and S&P 500 indices, and the 3M and Microsoft stock price. In the real-world, this information would be tied to the web. In this code, it is randomly generated every so often.

**WEATHER**. Another thing that observers can watch is Minneapolis weather. The information available includes the temparature, chance of precipiation (in %), and air quality index. Again, this is being randomly generated to simulate updates.

#### OBSERVERS

**NEWS FEED**. The news feed (displayed using a pop-up graphics window) displays updates to both the stocks and the weather. You may choose to display all of the information or just some of the information.

**STOCK WATCHER**. The stock watcher (displayed in the shell) should display the Dow Jones and S&P indices. It can also display the stock price.

**DATABASE**. The database (saved in a file) will save the price of 1 stock and both indices. This should have a timestamp for each entry.

<hr>

### UNDERSTANDING THE STRUCTURE

Draw a UML diagram for the Observer Pattern for the weather and stock subjects, and the news feed, stock watcher, and database observers. It is almost identical to the Weather UML example provided in the slides. Use an `interface` where appropriate, rather than `class`. On the UML diagram, an interface is indicated by placing `<<interface>>` above the class name. You should have 2 subject classes and 3 observer classes.

### DELIVERABLES

In the slides there are samples of code from Head First Design Patterns.

1. Pull the repo. Use these files for inspiration. Please do not include them in your final lab.

1. Create a working folder. You will need the 2 Observer and 1 Subject interface.

1. Implement the subject classes for weather and stock prices. 

1. Implement the observer classes for the news feed, stock watcher, and database.

1. Put all the pieces together in a Main. Create a loop that continually updates (it does not stop). You can find an elegant way to stop the program, or just kill it.





