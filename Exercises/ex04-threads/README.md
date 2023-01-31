### Exercise Working with Threads

#### One Call Threads

1. Create 1 class in a file called TaskOnceA.java. Include the method below. 

```Java
public void run() {

    System.out.println("Starting the execution of TaskA");
    for (long i = 0; i < 100000; i++) {
        if (i % 1000 == 0) {
            System.out.print("A ");
        }
    }
    System.out.println("\nEnding the execution of TaskA");
}
```


2. Copy the `TaskOnceA.java` file into `TaskOnceB.java`. In this class, 

- change the print statements to print TaskB, instead of TaskA.
- print 'B' in the for loop
- loop up to 1000000 (1 more 0 than TaskOnceA)


2. Create a Main and run the code.

```
TaskOnceA taskA = new TaskOnceA();
TaskOnceB taskB = new TaskOnceB();

taskA.run();
taskB.run();
```

3. Change the class to `public class TaskOnceA extends Thread`.

    Run the code (but there will be no difference in behavior).

    Change the call from run() to start().

```Java
taskA.start();
taskB.start();
```

 > What do you see now? **Take a moment to absorb what you are seeing and to understand it.**

 4. Change the calls to this:

 ```Java
taskA.start();
try {
    taskA.join();
} catch (Exception e) {

}
taskB.start();
```

> And now what do you see? **Take a moment to absorb what you are seeing and to understand it.**

5. Create another task object and start it as well.

6. Play around with the code a bit to understand how it is working. Change the timing (the sleep interval). Take out the .join and see what happens.

<hr>
<hr>

#### Infinite Threads with Runnable

> You can comment all of the above out to have a clean output on the shell.

1. Incorporate the `DisplayTask.java` file.

Notice that the class extends JComponent, which prevents the extension of Thread. Instead, it `implements Runnable`.

2. Add this to the main method and run it.

```Java
DisplayTask displayTaskA = new DisplayTask(400,400,"Display A",1000);
DisplayTask displayTaskB = new DisplayTask(400,400,"Display B",2000);

Thread displayA = new Thread(displayTaskA);
Thread displayB = new Thread(displayTaskB);
```

> Notice how the thread is created. A task object is instantiated, as before when extending Thread, but then a new Thread is made and the _Runnable_ object is passed to the thread. 

    Take a moment to look at the displays and think about what is going on.

3. Create a way to interact with one of the displays. In the main method after everything is started, add this ...

```Java
Scanner scanner = new Scanner(System.in);
while (true) {
    userInput = scanner.nextLine();
    displayTaskA.displayText(userInput);
}
```

    Type in the shell and see the results in the display window. Sometimes the first one doesn't work (not sure why).

4. It is not great to catch a generic Exception. One should generally catch the specific exception that is thrown. Google which exception is thrown by Thread.sleep and change the catch to catch that one.

    Run the code and make sure it works.

<hr>
<hr>

#### Classic Producer Consumer Synchronization

> You can comment out all of the above to concentrate just on this part of the exercise.

1. Incorporate the file `Messenger.java`.

> Take a minute to look at the class. Look at the read and write. This is a shared mailbox that one task can write to and another can read from.

2. In a new file, create a new class TaskReader that extends Thread. Like this:

```Java
public class TaskReader extends Thread {
    Messenger mailbox;

    long counter = 0;

    public TaskReader(Messenger box) {
        mailbox = box;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            } 
            System.out.print("In Task Reader "+counter+" ");
            String[] msg = new String[20];
            mailbox.read(msg); 
            for (int i=0; i<msg.length; i++) {
                System.out.print(msg[i]+" ");
            }
            System.out.println();
            counter++;
        }
    }
}
```

3. In a new file, create the new class TaskWriter like this:

```Java
public class TaskWriter extends Thread {

    long counter = 0;

    Messenger mailbox;

    public TaskWriter(Messenger box) {
        mailbox = box;
    }

    public void run() {
        while (true) {
             
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            
            System.out.print("In Task Writer "+counter+" ");
            mailbox.write();
            ++counter;
        }
    }
}
```

4. In main, instantiate a Messenger, and a Reader and Writer task. Call `.start()` on each.

> Look closely at the read messages. What is wrong with that? **Try to understand what is happening and why.**

<hr>

You need a mutex (mutual exclusion)!

In the Messenger file:

1. `import java.util.concurrent.locks.*;`
1. `private ReentrantLock mutex = new ReentrantLock();`
1. In the read method, add a `try-finally` block around the method body. 
1. The first liine of the try should be `mutex.lock()`, followed by the entire body of the method. 
1. In the finally, add the 1 line `mutex.unlock();`.
1. Repeat for the write.

> Run the code and see the difference! Look at the ordering of the output and **try to get a sense of what is happening and why.**

Submit via Moodle when you are done.



