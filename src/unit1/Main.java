package unit1;

public class Main {
    public static void main(String[] args) {
        // Class and object
        Car myCar = new Car(); // Create a myCar object
        myCar.drive(); // Access the drive method of myCar object


        // Encapsulation
        Boy newBoy = new Boy(); // Create a newBoy object
        newBoy.setAge(18); // Set the age of the student (age is a private member, but we can set the with the help of setAge() method)
        int age = newBoy.getAge(); // The getAge() method returns the age of the student and stores it in age variable.
        System.out.println("The student is " + age + " years old.");


        // Inheritance
        Dog newDog = new Dog(); // Create a newDog object
        newDog.eat();   // newDog inherits the eat() method from the Animal class
        newDog.bark();  // newDog's own bark() method


        // Polymorphism
        Animals animal = new Animals();
        Cat cat = new Cat();
        // Here the sound() method behaves differently depending on the object
        animal.sound(); // This will implement the sound() method of animal class
        cat.sound();    // This will implement the sound() method of cat class


        // Abstraction
            // You cannot create an object of an abstract class
            // Shape s = new Shape();  Not allowed

            // Create an object of the subclass
            Circle c = new Circle();
            c.draw();     // Output: Drawing a circle.
            c.display();  // Output: This is a shape.


        // An application with two classes
        Student student = new Student("Alice", 20);  // Creating an object of Student
        student.displayInfo();   // Calling method to display student information

    }
}

// Class and Object
class Car {
    // Declare a variable or an attribute and initialize it
    String color = "blue";

    // Define a method or function
    void drive() {
        System.out.println("Car is driving and the color of the car is " + color);
    }
}


// Encapsulation
class Boy {
    // Variables declared with the private keyword can't be accessed from outside the class
    private int age;

    // To access the private variables or methods from outside the class, we define public get and set methods
    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }
}


// Inheritance
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}


// Polymorphism
class Animals {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}


// Abstraction
abstract class Shape {
    // Abstract method (without a body)
    abstract void draw();

    // Regular method
    void display() {
        System.out.println("This is a shape.");
    }
}

// Subclass (inherits from Shape)
class Circle extends Shape {
    // Must implement the abstract method
    void draw() {
        System.out.println("Drawing a circle.");
    }
}


// An application with two classes
class Student {
    // Attributes
    String name;
    int age;

    // Constructor
    public Student(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }

    // Method to display student details
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}


// Java Program Structure
//import java.util.Scanner;
//
//public class MyProgram {
//    public static void main(String[] args) {
//        System.out.println("Hello, Java!");
//    }
//}


// Simple if Statement
class GradeChecker {
    public static void checkGrade(int marks) {
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 80) {
            System.out.println("Grade B");
        } else if (marks >= 70) {
            System.out.println("Grade C");
        } else {
            System.out.println("Needs Improvement");
        }
    }
}

// Switch Statement
class DayPrinter {
    public static void printDay(int day) {
        switch (day) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default: System.out.println("Invalid day");
        }
    }
}

// Nesting of if...else Statements
class EntryChecker {
    public static void checkEntry(int age, boolean hasID) {
        if (age >= 18) {
            if (hasID) {
                System.out.println("You are allowed to enter.");
            } else {
                System.out.println("Please show your ID.");
            }
        } else {
            System.out.println("You are too young to enter.");
        }
    }
}

// ? Operator or Ternary Operator
class TernaryOperator {
    public static void checkAge(int age) {
        String result = (age >= 18) ? "Adult" : "Minor";
        System.out.println(result);
    }
}

// While Loop
class WhileExample {
    // The loop runs as long as count <= 5. The counter count is incremented each time.
    public static void whileLoop() {
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;  // Increment the counter
        }
    }
}

// Do...While Loop
class DoWhileExample {
    // The block executes first, and then the condition is checked. It will run as long as count <= 5.
    public static void doLoop() {
        int count = 1;
        do {
            System.out.println("Count: " + count);
            count++;
        } while (count <= 5);
    }
}


// For Loop
class ForExample {
    // The loop starts by initializing count = 1, checks if count <= 5, and then increments count after each iteration.
    public static void forLoop() {
        for (int count = 1; count <= 5; count++) {
            System.out.println("Count: " + count);
        }
    }
}
