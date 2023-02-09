## JUnit Testing: An Introduction

As a programmer, it is essential that you test your code. It is your responsibility as a team member to make sure that what you contribute to a project is correct. For production quality code, it is insufficient for you to "try" a couple of values, print the results to the screen, and check that they are right. You have to be just as thoughtful about how you test your code as you do about writing your code. Luckily, there are tools that help you formalize this process.

JUnit is a formal testing framework for Java. The tests are written in Java, but enhanced with `@`attributes that control most aspects of the tests. At the heart of a test is an `assert` statement that checks a condition based on the passed arguements. The behavior varies, but in general in most languages, if an assert finds that something is false, the program is abandoned. Throughout this exercise, you will create tests using various assert statements.

The assignment today is to write a **Unit* test for the class Circle. A Unit test is focused on a single unit (typically a class) of a project. If you are testing all of the pieces together, you are running an _Integration_ test. By having formal tests, they can be run when the codebase changes to make sure everything is still functioning as expected. This is referred to as _regression_ testing. 

In your _Circle_ unit test, you will want to test all the methods of the class. _Circle_ has 4 methods including circumference(), area(), overlaps(Circle other), and angle(Circle other), plus constructors. You will first learn the various options for writing tests. Then, you will identify a series of tests, which you will implement in the JUnit framework.

<hr>

### Getting Ready

Pull the repo and copy the exercise folder into your working folder. This includes the needed jar file. There are directions at the bottom if you want to find it on the web or look for other options.

### Getting Familiar

The JUnit tests have been started for you. To run what is there, enter these commands in the terminal.

Crediting Dr. Steinmetz for tracking this down:

To compile the JUnit classes on the command line:

```
javac -cp .:./junit-platform-console-standalone-1.9.2.jar *.java
```

To run the tests in this class on the command line, use a command like

```
java -jar ./junit-platform-console-standalone-1.9.2.jar -cp . --scan-classpath .
```

or

```
java -jar ./junit-platform-console-standalone-1.9.2.jar -cp . --select-class CircleTests
```

<hr>

### THE BASIC ASSERT

Take a moment to scroll through the output from the tests. You primarily want to look at the "tree" of tests, which is the first thing printed to the terminal. Relate the output to the test. Notice the use of `@DisplayName` and where that appears. 

**Change one of the expected values of x or y so that the first test fails and compile-run again.**

**Now change the expected radius value so that also fails.**

There are a couple of things to notice. 1) The assert error message is the only information available that explains the failure, and 2) Once a test fails, execution returns from that method. Let us first attend to the first problem. Use `assertEquals` instead. The signature is `assertEquals(value,value,[optional message])`.

**Replace `assertTrue` with `assertEquals` creating 3 assert statements for x, y, and radius.**

There are a lot of useful assert statements: https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html. Here are the ones you will probably use the most:

```
assertEquals    // same values, as in equals()
assertArrayEquals
assertSame      // same object, as in ==
assertFalse
assertTrue
assertNull
assertNotNull
assertAll
```

**Create another collection of assert statements to test the other constructor.**

Add these assert statements to the method `testConstructors`. Use any value that you want for instantiation and testing of a new circle, although it is probably best to use different values for each.

<hr>

### BUNDLING TESTS WITH AssertAll

Any failed assert statement will break you out of the method and stop execution of any of the other tests. But often you want the tests to keep going regardless. You can bundle the tests with AssertAll. It has this general form:

```Java
assertAll("A bundle of asserts",
    () -> assertEquals("Jane", "Doe","jane as doe"),
    () -> assertEquals("Doe", "Jane","doe as jane"),
    () -> assertTrue(true,"true true")
);
```

The syntax `()->` is a lambda function. You will see this in a lot of test examples. Lambda functions have _lazy evaluation_ meaning they are essentially constructed and evaluated at runtime, unlike regular functions whose expressions are evaluated at compile time. _You do not need to understand lambda functions to make this work_.

And not only can you wrap all of the Constructor assert statements with `assertAll`, you can separate them into 2 bundles of assertAlls, like this:

```Java
assertAll("Bundles of asserts",
        ()-> {
            System.out.println("I can have whatever I want in this block of code.");
            assertAll("A subset of tests in its own block",
                () -> assertEquals("Jane", "Doe","jane as doe"),
                () -> assertEquals("Doe", "Jane","doe as jane"),
                () -> assertTrue(true,"true true")
            ); // closes the assertAll(subset)
            }, // closes first, outer-most lambda
        ()-> {
            assertAll("Another bundle of asserts",
                () -> assertEquals(1+1,3,"bad math"),
                () -> assertFalse(true,"true true")
            ); // closes assertAll(another)
        } // closes second, outer-most lambda
        ); // closes assertAll(bundles)
```

**Bundle the default constructor asserts and the non-default constructor asserts into different bundles.**

<hr>

### CREATING MULTIPLE TEST METHODS

As with any class, you can create as many test methods as you like. It is convention to have at least 1 test method for each class method. But if the class method is sufficiently complex, you probably want multiple test methods per class method.

**Create another method for the Circle.circumference method.**

```Java
@Test 
@DisplayName("Circumference Tests")
void testCircumference() {

}
```

When you test the circumference of a circle, you will want to create multiple circles with different values to ensure it works for both border and _nominal_ or typical values. For that you can use a `@ParameterizedTest`. The general form looks like this:

```Java
@ParameterizedTest(name = "Test with Parameter {0}")
@ValueSource(ints = {0,1,2,3})
void testWithValues(int param) {
    Circle circle = new Circle(0,0,param);
    assertEquals(2*Math.PI*param,circle.circumference());
}
```

Note that the `@Test` has been changed to `@ParameterizedTest`.

If you want to have more than 1 parameter, you can use `@CsvSource` instead of `@ValueSource`. You can even use a csv file! It has this general form:

```Java
@ParameterizedTest(name = "{0} relates to {1} and {2}")
@CsvSource({
            "0, 1, 2",
            "3, 4, 5"
    })
void testWithMoreValues(int param0, int param1, int param2) {
    System.out.println("Perhaps a message here or constructors");
    assertEquals(param1, instance.myfun(param2,param3),
        () -> param1 + " and " + param2 + " = " + param0
    );
}
```

**Incorporate a paramaterized test in _CircleTest_ and make sure you understand the syntax.**


> At any point, if you want to ignore a test, place the `@Disabled("Ignoring for now")` above the test method.

<hr>

### SUPPORT CODE AROUND TESTS

The last thing to mention is elements of tests that you want to create or manage before all, before each, after each, and/or after all. You can write those methods with the following tags:

```Java
@BeforeAll
static void setUpTests() {}
    
@AfterAll
static void tearDownTests() {}
    
@BeforeEach
void setUp() {}
    
@AfterEach
void tearDown() {}
```

<hr>

DELIVERABLES

**Create a test plan document** that identifies the test cases that you would like to make for each test. This will not be anything formal. For each method, identify what characteristic you want to test. For example, for `overlaps()` you will want to test when the circles are just touching and maybe when one circle is completely inside the other.

**Create at least 1 test method per Circle class method**. This includes:
- Constructors (you can put both into the 1 test method)
- `double circumference()` : returns the calculated circumference of the circle
- `double area()` : returns the calculated area of the circle
- `boolean overlaps(Circle other)` : returns true if this and other are touching or overlapping
- `int angle(Circle other)` : returns the angle between centers of this and other (in degrees 0 to 359)

Somewhere in your tests, use each of the following Java assert statements:
- `assertEquals`
- `assertNotNull`
- `assertTrue`
- `assertAll`

And consistently use:
- `@DisplayName`
- Error messages in the asserts.

Somewhere in your tests, use each of the following JUnit constructs:
- `@ParameterizedTests`
- `@ValueSource`
- `@CsvSource`
- `@BeforeAll`, `@AfterAll`, `@BeforeEach`, or `@AfterEach` (just one)

    
<hr>

Directions on where to find the needed jar file ...

JUnit runs using a jar file that one would download off the web (well, if you do this in Netbeans or IntelliJ or some other IDE, it comes installed). It is already included in the exercise folder. But if you did need to find it or are curious about other versions, follow thte directions below! It is a bit tricky to find so thanks to Dr. Steinmetz for tracking this down!

- https://junit.org/junit5/
- Latest Release Platform icon on the right
    https://search.maven.org/search?q=g:org.junit.platform%20AND%20v:1.9.2
- junit-platform-console-standalone (click the link, not the download icon)
    https://search.maven.org/search?q=a:junit-platform-console-standalone
- Click the download button and choose jar at the top


 
