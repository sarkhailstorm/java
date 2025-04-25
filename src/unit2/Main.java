package unit2;

import java.util.ArrayList;
import java.util.Vector;

// Main class to create and use objects
public class Main {
    public static void main(String[] args) {
        // Creating Objects
        Car car1 = new Car("Toyota", 2020);
        Car car2 = new Car("Honda", 2022);

        // Accessing Class Members
        car1.displayInfo();      // Display car1 info
        car1.startEngine();      // Start car1

        System.out.println();    // Just a blank line

        car2.displayInfo();      // Display car2 info
        car2.startEngine();      // Start car2



        // Method Overloading
        Calculator calc = new Calculator();
        System.out.println("Sum of 5 + 3: " + calc.add(5, 3));
        System.out.println("Sum of 1 + 2 + 3: " + calc.add(1, 2, 3));
        System.out.println("Sum of 2.5 + 3.5: " + calc.add(2.5, 3.5));



        // Static Members
        Student.printSchool(); // Calling static method without object

        Student s1 = new Student();
        s1.studentName = "Alice";
        s1.printName();



        // Nesting of Methods
        Calculate cal = new Calculate();
        int result = cal.complexOperation(3, 4);
        System.out.println("Result: " + result); // Output: 19 (3+4 + 3*4 = 7 + 12 = 19)



        // Method Overriding
        Cat myCat = new Cat();
        myCat.sound();  // Calls the overridden method in Cat



        // Finalize Method
        Resource res1 = new Resource("Resource-1");
        Resource res2 = new Resource("Resource-2");

        res1 = null; // Make res1 eligible for GC
        res2 = null; // Make res2 eligible for GC

        System.gc(); // Request Java to run garbage collector



        // Abstract Class and Method
        // Animals a = new Animals();    // Error! Cannot instantiate an abstract class

        Dog myDog = new Dog();
        myDog.sound(); // Output: Dog barks
        myDog.eat();   // Output: This animal eats food.




        // Multiple Inheritance
        Bird b = new Bird();
        b.fly();    // Output: Bird is flying
        b.swim();   // Output: Bird is swimming



        // 1D Array
        // Declare and initialize an array of integers
        int[] numbers = {1, 2, 3, 4, 5};

        // Accessing elements using index
        System.out.println(numbers[0]); // Output: 1
        System.out.println(numbers[4]); // Output: 5

        // 2D Array
        // Declare and initialize a 2D array (3 rows, 3 columns)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Accessing elements using two indices
        System.out.println(matrix[0][0]); // Output: 1
        System.out.println(matrix[1][2]); // Output: 6




        // Vectors
        // Create a vector with initial capacity of 5
        Vector<Integer> vector = new Vector<>(5);

        // Add elements to the vector
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);

        // Accessing elements from vector
        System.out.println("First element: " + vector.get(1)); // Output: 2
        System.out.println("Size of vector: " + vector.size()); // Output: 3




        // String
        String greeting = "Hello, World!";
        System.out.println(greeting);               // Output: Hello, World!

        // String concatenation
        String name = "Alice";
        String message = "Hello, " + name;
        System.out.println(message);                // Output: Hello, Alice

        // String length
        System.out.println("Length: " + greeting.length()); // Output: 13

        // String comparison
        String str1 = "apple";
        String str2 = "apple";
        System.out.println(str1.equals(str2));      // Output: true




        // Wrapper Class
        // Integer example: Wrapping a primitive int using the Integer wrapper class
        int a = 10;                   // primitive int
        Integer aObj = a;            // autoboxing: converting int to Integer object
        System.out.println("Integer value: " + aObj);  // prints the Integer object value

        // Double example: Wrapping a primitive double using the Double wrapper class
        double d = 5.5;              // primitive double
        Double dObj = d;             // autoboxing: converting double to Double object
        System.out.println("Double value: " + dObj);   // prints the Double object value

        // Autoboxing means automatically converting a primitive type to its corresponding wrapper class.

        // Another Example
        // Primitive int cannot be stored directly in ArrayList
        // ArrayList<int> list = new ArrayList<>();   // Not allowed

        // Use Integer wrapper instead
        ArrayList<Integer> list = new ArrayList<>();

        int num = 10;
        list.add(num);  // Java automatically converts int → Integer (Autoboxing)

        System.out.println("List: " + list);  // Output: List: [10]

    }
}

// Class Definition
class Car {
    // Variables (Fields)
    String brand;
    int year;

    // Constructor (initializes brand and year)
    Car(String b, int y) {
        brand = b;
        year = y;
    }

    // Method to display info
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }

    // Another method
    void startEngine() {
        System.out.println(brand + " engine started!");
    }
}


// Method Overloading
class Calculator {
    // Overloaded method with two int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method with three int parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method with double parameters
    double add(double a, double b) {
        return a + b;
    }
}



// Static Members
class Student {
    // Static variable
    static String schoolName = "Greenwood High";

    // Instance variable
    String studentName;

    // Static method
    static void printSchool() {
        System.out.println("School: " + schoolName);
    }

    // Instance method
    void printName() {
        System.out.println("Student: " + studentName);
    }
}



// Nesting of Methods
class Calculate {

    // Method 1: Adds two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method 2: Multiplies two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method 3: Uses add() and multiply() inside it (Nesting)
    public int complexOperation(int x, int y) {
        int sum = add(x, y);         // Calling add() inside complexOperation()
        int product = multiply(x, y); // Calling multiply() inside complexOperation()
        return sum + product;
    }
}



// Method Overriding
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}



// Final Variables
class MyCar {
    final int wheels = 4;  // Constant value

    void display() {
        System.out.println("A car has " + wheels + " wheels.");
        // wheels = 6;      // Error: Cannot change final variable
    }
}



// Final Methods
class Vehicle {
    final void engineSound() {
        System.out.println("Vroom Vroom!");
    }
}

class Bike extends Vehicle {
    // void engineSound() { }   // Error: Cannot override final method
}



// Finalize Method
class Resource {
    private String name;

    public Resource(String name) {
        this.name = name;
        System.out.println(name + " created.");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " is being garbage collected.");
    }
}



// Abstract Class
abstract class Animals {
    // Abstract method (without body)
    abstract void sound();

    // Concrete method (with body)
    void eat() {
        System.out.println("This animal eats food...");
    }
}

class Dog extends Animals {
    // Providing implementation for abstract method
    void sound() {
        System.out.println("Dog barks...");
    }
}



// Multiple Inheritance
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

// A class can implement both
class Bird implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Bird is flying");
    }
    public void swim() {
        System.out.println("Bird is swimming");
    }
}
