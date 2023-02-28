### Jar and Package Exercise

This exercise will walk you through the making and using of jar files and packages. Jar files are a means to distribute compiled Java code by sharing a single file. Packages are a way to bundle your application that avoids name clashes. In these exercises, we will be creating directories/folders and managing files at different locations.

To get started, grab this code that implements a Tic-Tac-Toe game. It's a little buggy and it does not deal with the end of the game, but it will work for our purposes.

<hr>

#### JAR

There is a simple tutorial offered by Oracle. It is old, but it works! Let us do that together ...

You can start here: https://docs.oracle.com/javase/tutorial/deployment/jar/basicsindex.html

Here are some basic commands that you will be using ...

| Task | Format | Example |
|------ |------ |---------|
| Create JAR file | jar cf jar-file input-file(s) | <code>jar cf tictactoe.jar *.class</code> |
| View contents of JAR file | jar tf jar-file | <code>jar tf tictactoe.jar </code> |
| Extract contents of JAR file | jar xf jar-file | <code>jar xf tictactoe.jar</code> |
| Extract specific files from JAR file | jar xf jar-file archived-file(s) | <code>jar xf tictactoe.jar Game.class</code> |
| Run the application in the JAR file | java -jar jar-file | <code>java -jar tictactoe.jar</code> |
| Create jar with manifest file | jar cfm MyJar.jar Manifest.txt MyPackage/*.class | <code>jar cfm tictactoe.jar Manifest.txt *.class</code> |
| Create entry point (main) for app | jar cfe app.jar MyApp MyApp.class | <code>jar cfe tictactoe.jar Game Game.class</code>

</br>
<hr>

Below are some flags/options you can use in the commands. **Every option I have seen thus far is paired with the `f` option.**

| Flag | Description |
|------|-------------|
| v | Verbose, meaning print a lot of information to stdout |
| c | Create a jar |
| f | File as the destination | 
| t | Table of contents of the jar |
| x | eXtract the jar |
| u | Update existing jar |
| m | Manifest file available |
| e | Executable (main) for the application |

### Creating and Using Jars

1. Create a jar file for the Tic-Tac-Toe game that can be distributed and run. Note that there are files in the `images` directory that are used in the application. You will need to also include this folder when you make your jar. (https://docs.oracle.com/javase/tutorial/deployment/jar/build.html).

1. View the contents of the jar. Use the verbose option so that you can see everything. (https://docs.oracle.com/javase/tutorial/deployment/jar/view.html).

1. Run the jar file. You will find that it will not work given the directions on the previous page. You have to set the _entry point_ for the application. (https://docs.oracle.com/javase/tutorial/deployment/jar/run.html).

1. Create a manifest to set the entry point of the application. (https://docs.oracle.com/javase/tutorial/deployment/jar/run.html).

1. Run the jar file and play the game. (Let someone win!)

You can also experiment with extracting the files so that you can run them with `java Game`.

<hr>

#### Packages

To get started, we will be creating a directory structure that you might encounter in a professional environment. We want to keep the source, class, and test files in separate folders. We also want to put everything in a package to avoid name clashes.

1. Create a new directory structure like this (these are all folders) ...

```
java-packages
    - src
        - augsburg
            - game
    - bin
```

1. Move the `*.java` files from the game into the `game` folder. 

1. At the top of each `.java` file, add `package augsburg.game;`.

1. In the `game-packages` directory, compile the files and use the `bin` directory as the desitination for all `*.class` files.

<code>javac -d ./bin ./src/augsburg/game/*.java</code>

1. Execute the code.

<code>java -cp ./bin augsburg.game/Game</code>

> The options `cp` stand for class path. This directs the Java environment to look inside that folder for needed files. Note how the executable is referenced `augsburg.game/Game`. This is not due to the directory structure, but the name of the package in the file. We have _scoped_ everything to be in that package. 

You will notice that when you click a box, the images no longer appear. That is because we have broken the relative path of the application. The images are drawn from the `images` folder, which would be assumed to be in the current directory of where the application is running. However, now the application is running from inside the `bin` folder. 

1. Move the `images` folder to inside the `java-packages` folder (at the same level as `src` and `bin`).

1. Again, compile and execute the application. Because you are adding the class path `/bin`, the path is relative to that directory.

<hr>

See if you can figure out how to put your game package in a jar file and execute it with `java -jar`.

https://docs.oracle.com/javase/tutorial/deployment/jar/sealman.html






