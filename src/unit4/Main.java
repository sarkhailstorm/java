package unit4;

public class Main {
    public static void main(String[] args) {
         // Creating Threads
        MyThread t = new MyThread();  // Create thread object
        t.start();                    // Start the thread
        // start() begins execution in a new thread.



        // Extending Thread Class
        PrintNumbers t1 = new PrintNumbers();
        t1.start();  // Executes in a separate thread
        // You can run multiple threads by creating multiple objects and calling start() on each.



        // Stopping Thread
        ControlledStop t2 = new ControlledStop();
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        t2.stopThread();  // Graceful stop
        // This is the safe and proper way to stop a thread.



        // Blocking Thread
        SleepDemo t3 = new SleepDemo();
        t3.start();
        // The thread pauses for 1 second between prints using sleep().





        // Thread Life Cycle
        // New state: Thread object is created
        LifeCycleThread t6 = new LifeCycleThread();

        System.out.println("Thread State after creation: " + t6.getState()); // NEW

        // Runnable state: Thread is ready to run after start() is called
        t6.start();

        System.out.println("Thread State after start(): " + t6.getState()); // RUNNABLE

        try {
            // Wait for the thread to die
            t6.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        // After completion (Dead state)
        System.out.println("Thread State after completion: " + t6.getState()); // TERMINATED




        // Using Thread Methods
        ThreadMethodsExample t4 = new ThreadMethodsExample();
        t1.start(); // Start the thread

        try {
            t4.join(); // Main thread waits for t1 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("Main thread finished after child thread.");




        // Thread Exception
        ThreadExceptionExample t5 = new ThreadExceptionExample();
        t5.start();    // Start the thread
        t5.interrupt(); // Interrupt the thread immediately
        // t1.interrupt() interrupts the thread during sleep.
        // This causes an InterruptedException, which we catch and handle inside the run() method.




        // Thread Priority
        PriorityExample thread1 = new PriorityExample();
        PriorityExample thread2 = new PriorityExample();
        PriorityExample thread3 = new PriorityExample();

        thread1.setPriority(Thread.MIN_PRIORITY);  // 1
        thread2.setPriority(Thread.NORM_PRIORITY); // 5
        thread3.setPriority(Thread.MAX_PRIORITY);  // 10

        thread1.start();
        thread2.start();
        thread3.start();
        // High priority threads are more likely to execute first, but not guaranteed!




        // Implementing Runnable Interface
        // Step 2: Create Thread object and start it
        MyTask1 task1 = new MyTask1();          // Create a Runnable task
        Thread thread4 = new Thread(task1);         // Pass task to Thread

        MyTask2 task2 = new MyTask2();
        Thread thread5 = new Thread(task2);

        thread4.start();                           // Start the thread
        thread5.start();                           // Start the thread
    }
}


// Creating Threads
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");   // run() contains the task.
    }
}



// Extending Thread Class
class PrintNumbers extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }
    }
}



// Stopping Thread
class ControlledStop extends Thread {
    boolean running = true;

    public void run() {
        int i = 1;
        while (running) {
            System.out.println("Running: " + i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        System.out.println("Thread stopped.");
    }

    public void stopThread() {
        running = false;
    }
}




// Blocking Thread
class SleepDemo extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Executing: " + i);
            try {
                Thread.sleep(1000);  // Pauses for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}




// Thread Life Cycle Example
class LifeCycleThread extends Thread {

    public void run() {
        System.out.println("Thread is Running..."); // Running state

        try {
            // Make the thread sleep for 2 seconds (Waiting/Sleeping state)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted!");
        }

        System.out.println("Thread Finished!"); // After waking up
    }
}





// Using Thread Methods
class ThreadMethodsExample extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Running: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        }
    }
}






// Thread Exception
class ThreadExceptionExample extends Thread {
    public void run() {
        try {
            Thread.sleep(2000); // Thread sleeps for 2 seconds
            System.out.println("Thread completed successfully.");
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while sleeping!");
        }
    }
}




// Thread Priority
class PriorityExample extends Thread {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}




// Synchronization
class Counter {
    private int count = 0;

    // synchronized method
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class SyncExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount()); // Expected output: 2000

        // Without synchronization, the final count might be wrong because both threads interfere with each other.
    }
}




// Implementing Runnable Interface
// Step 1: Create a class that implements Runnable
class MyTask1 implements Runnable {
    public void run() {
        System.out.println("Thread1 is running by implementing Runnable!");
    }
}
class MyTask2 implements Runnable {
    public void run() {
        System.out.println("Thread2 is running by implementing Runnable!");
    }
}