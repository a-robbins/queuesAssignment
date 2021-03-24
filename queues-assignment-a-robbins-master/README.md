



# Queue Assignment

For this assignment you will be responsible for implementing a Queue abstract data type in two different ways, one via a linked list and the other with a dynamically resizing arrays. The linked list implementation will be found in `GenericListQueue.java` and the dynamically growing array implementation will be found in `GenericArrayQueue.java`. Both of these implementations will expose the same interface and each should provide the same behavior as the other. This means that any call to the `GenericArrayQueue` type should result in the exact result as a call to the `GenericListQueue` type when they both contain the same data. 

Your goal for this assignment is to implement the interface functions found in both `GenericArrayQueue.java` and `GenericListQueue.java`. Some things to keep in mind is that both of these types should be able to store and access any amount of data and should not have any hardcoded size values. For the array implementation you will need to implement the array resizing rules that we discussed in the lecture videos. Note that simply resizing the array every time data is added or removed from the queue is _not_ a correct solution.

## Building & Running

You will be able to build your programs in Intellij by either right-clicking on the class you want to build and selecting the `recompile` option, or via the keyboard shortcut `[ctrl/cmd] + b`. Once built you can run the program in Intellij by right-clicking on the file again and selecting `run with arguments` or with the keyboard shortcut `[ctrl/cmd] + e`. A popup will appear that asks for any arguments you wish to provide to the program,

![image-20201125113648156](.media/image-20201125113648156.png)

You can just leave the text box empty and select the OK option. A new window should appear at the bottom of the screen with which you can interface with the running program

![image-20201125113851263](.media/image-20201125113851263.png)



The programs can also be built directly from the command line using the following commands

```
./javac-ds Generic[List/Array]Queue.java
./java-ds Generic[List/Array]Queue
```

One thing to be aware of is if your Queues make use of another class found in another file, then that external file must be built before you can build your final program. For example, in my implementation the `GenericListQueue` class makes use of another class called `GenericList` which exists in a separate file

![image-20201125114249081](.media/image-20201125114249081.png)

If I try to build `GenericListQueue` without first building `GenericList` I will receive the following error in Intellij

![image-20201125114534737](.media/image-20201125114534737.png)

To resolve this you just need to first build the `GenericList` class file.

### Test Clients

Both the List and Array implementation files contain a `main` method that can be used as an initial test client. If you run either of the programs directly from the command line or inside of Intellij these are the methods that will be executed and that you will be directly interacting with. 

These clients read data from `stdin` and execute commands based on the input they receive. Please review the function to determine what they expect to receive from `stdin` and the resulting action. Most commands invoke one of the class API methods directly and either print a message out or take some action based on the input you provide. These sorts of clients provide a quick and direct method of testing your code as you implement the functions.

### Test Input and Output

I have also provided sample input files and the expected output for those files. The sample input consists of a series of commands that the test clients accept and perform operations on. They are the exact commands that you would manually type into the program however we can automate this by using input redirection to echo the contents of the file to your program without having to manually type it and then use output redirection to capture your program's output to ensure that it matches what is expected. To test your program with those files you can run the following commands from the command line

```java
./javac-ds Generic[List/Array]Queue.java
./java-ds Generic[List/Array] < input/input_sm.txt > output.txt
diff --strip-trailing-cr output/output_sm.txt output.txt
```

The above commands will first compile your java code then execute the code and redirect the contents of the example input file, `input_sm.txt`, to the program. The output of your program will then be redirected to a file called `output.txt`. The last command then compares the contents of the output I have provided you, `output_sm.txt`, with the output your program generated which was saved in `output.txt`. If the contents of the files match nothing should be printed to the screen. If the output differs then you need to determine why it differs and modify your program to match the provided output. Take care that you do not accidently overwrite the sample output file when you execute your program! 

## Misc

Note that when you build your array based code you will likely receive a warning like the following

```shell
GenericArrayQueue.java:99: warning: [unchecked] unchecked cast
        dataArray = (Item[]) new Object[1];
                             ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class GenericArrayQueue
GenericArrayQueue.java:200: warning: [unchecked] unchecked cast
        Item[] copy = (Item[]) new Object[newCap];
```

It is safe to ignore this warning as this is an issue with Java's lack of built in generic arrays. However this is the only warning you may safely ignore! If other warnings are being shown you must find a way to resolve them.

## Expectations & Rules

* You are expected to correctly implement all required methods inside of both`GenericListQueue.java` and `GenericArrayQueue.java`. 
* Your method implementations should meet the API specifications noted by the comments above each method. This includes the values that should be returned 
* Your implementations should handle potential edge cases that could arise without crashing
* You cannot change the prototype of any existing `public` method in the class
* You cannot add any new `public` methods to the class
* You can add new `private` methods and instance variables which act as helper functions
* Your method implementations should return in the correct manner, such that if it is a `void` method,  nothing should be returned, if it is a `boolean` method then a Boolean should always be returned, etc
* If a sample output file is provided, then your output format must match the provided output _exactly_, including spaces, casing, etc. 
* You should include some number of test cases in other `.java` files that show the correctness of your program in both normal and edge case scenarios. Think about strange situations your code could end up in and show that your implementation is able to handle it correctly. Such as what happens if you call an api method which should return a value but your data structure is currently empty. 
* Your array based implementation should both grow and shrink according to the array resizing rules described in the course videos

## Creating Test Cases

All test files should be located inside of the tests folder. If you create a new test with the Intellij 'new class' wizard it may automatically place the following line at the top of the file

`package tests;`

Delete or comment out that line, if you do not you get multiple errors when trying to use either the algs4 library functions or the classes you needed to implement for this assignment. 

To create a new test case, create a new file called `Test<some test name>.java`. Note that the file name __must__ start with the word `Test`. Once you have created the test you can create an instance of your data structure and perform the necessary operations to show the success of the test. See the included Test files for examples, in general each test should follow these guidelines 

* The test file name must have the prefix `Test`
* If the test fails, a message should be printed saying that the test failed
* If the test fails, `System.exit(1);` should be called, you can ignore Intellij warning squiggles after that line has been written 
* If the test succeeds then a message should be printed out indicating that it was successful

Examine the included tests and use them as a template for your tests.

To build and run all tests you can use the included shell script called `run_tests.sh` This will find all test files in the `tests` folder, build them, and run them. This can be invoked from a terminal that is open to the assignment directory with:

```
./run_tests.sh
```

## Rubric

Your code will be graded based on the following rubric

| Category          |                                                              |                                                              |                                                              |                                                              |
| ----------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Readability       | 6 Points                                                     | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   | Code is clean, understandable, well-organized                | Minor issues such as inconsistent indentation, variable naming, general organization | At least one major issue that makes it difficult to read     | Several major issues that make it difficult to read.         |
| Unit Tests        | 6 Points                                                     | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   | At least 6 additional unit tests(beyond the provide ones) are submitted with the assignment | At least 4 additional unit tests(beyond the provide ones) are submitted with the assignment | At least 2 additional unit tests(beyond the provided ones) are submitted with the assignment | No unit tests were provided                                  |
| Elegance          |                                                              | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   |                                                              | Code duplication is minimized by implementing the appropriate number of functions and loop statements. | Poor design choices were used in at least one place, for example duplicate code that could have been extracted into a function or put inside of a loop was not | Code contained multiple instances of poor design, such as not modularizing duplicate code or lack of data structure use to maintain and organize data |
| Correctness       | 30 Points                                                    | 25 Points                                                    | 15 Points                                                    | 0 Points                                                     |
|                   | All specifications are met and the program always functions as expected regardless of the input provided to it | Program meets most requirements but behaves abnormally when certain edge cases are provided | The program produces incorrect output with most input sets   | Program does not compile or does not function correctly even when provided with the sample input |
| Specifications    |                                                              | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   |                                                              | Program meets all specifications provided in the assignment description file | Minor specifications have been violated (incorrectly named files, program input) | Many specifications were not met                             |
| Memory Management |                                                              | 5 Points                                                     | 3 Points                                                     | 0 Points                                                     |
|                   |                                                              | Program allocates the correct amount of data without extraneous allocations | Program has a small number of extraneous allocations that are not required | Program has many extraneous allocations                      |
