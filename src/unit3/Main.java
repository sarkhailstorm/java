package unit3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Implementing an interface
        Dog d = new Dog();
        d.makeSound();  // Output: Dog barks!



        // Extending an interface
        Cat myCat = new Cat();
        myCat.eat();   // Output: Cat is eating.
        myCat.play();  // Output: Cat is playing.



        // Accessing interface variables
        Test obj = new Test();
        obj.displayMax();  // Output: Max value is: 100

        // Access directly using interface name
        System.out.println("Accessing directly: " + Constants.MAX_VALUE);




        // Using System Packages
        Scanner input = new Scanner(System.in);  // from java.util package
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello, " + name);




        // Accessing packages
        // File: Main.java
        // import mypackage.Message;
        Message msg = new Message();
        msg.show();

        // Compile and Run:
        // javac -d . mypackage/Message.java
        // javac Main.java
        // java Main


        // Using packages
        // Using full class path without import. Useful when you only use the class once and want to avoid an import statement.
        // mypackage.Message msg = new mypackage.Message();
        // msg.show();




        // File: UseCalc.java
        // import mypackage.Calculator;
        Calculator calc = new Calculator();
        System.out.println("Sum: " + calc.add(5, 3));




        // Hiding Class. Trying to use it outside the package:
        // File: Test.java
        // import mypackage.Internal;  // Error: class is not public
        // Internal obj = new Internal();  // Will cause compile-time error
        // obj.display();


    }
}



// Defining an interface
interface Animal {
    void makeSound(); // Abstract method (implicitly public and abstract)

    // The method has no body → subclasses must provide implementation.
    // Interfaces act as contracts that classes must follow.
}

// Implementing class
class Dog implements Animal {
    public void makeSound() {  // Must use public (same visibility as in interface)
        System.out.println("Dog barks!");
    }
    // Dog implements Animal and provides a body for makeSound().
    // Without the method implementation, Java would give an error.
}



// Parent Interface
interface Animals {
    void eat();
}

// Child Interface extending Animal
interface Pet extends Animals {
    void play();
}

// Implementing both methods in a class
class Cat implements Pet {
    public void eat() {
        System.out.println("Cat is eating.");
    }

    public void play() {
        System.out.println("Cat is playing.");
    }
}
// Pet extends Animal, so any class implementing Pet must implement both eat() and play().



// Accessing interface variables
interface Constants {
    int MAX_VALUE = 100;  // Public, Static, Final by default
}

// Implementing class
class Test implements Constants {
    void displayMax() {
        System.out.println("Max value is: " + MAX_VALUE);
    }
}
// MAX_VALUE cannot be modified because it’s final.




// Creating packages
// File: mypackage/Message.java
// package mypackage;
// This file must be saved in a folder named mypackage.
class Message {
    public void show() {
        System.out.println("Hello from user-defined package!");
    }
}





// File: mypackage/Calculator.java
// package mypackage;
// You can keep all math-related classes inside the mypackage folder.
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}




// Hiding class
// File: mypackage/Internal.java
// package mypackage;

class Internal {
    void display() {
        System.out.println("This class is package-private.");
    }
}



