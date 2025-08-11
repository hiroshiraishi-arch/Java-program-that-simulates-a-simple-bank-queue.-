/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customer;

/**
 *
 * @author Owner
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
    private String name;
    private int number;

    public Customer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + " - " + name;
    }
}

public class BankQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Customer> queue = new LinkedList<>();
        int customerCounter = 1;
        int choice;

        do {
            System.out.println("\n--- Bank Queue Menu ---");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    queue.add(new Customer(name, customerCounter++));
                    System.out.println("Customer added to the queue.");
                    displayQueue(queue);
                    break;

                case 2:
                    if (!queue.isEmpty()) {
                        Customer served = queue.poll();
                        System.out.println("Serving customer: " + served);
                    } else {
                        System.out.println("No customers in queue.");
                    }
                    displayQueue(queue);
                    break;

                case 3:
                    displayQueue(queue);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayQueue(Queue<Customer> queue) {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Current queue:");
            for (Customer c : queue) {
                System.out.println(c);
            }
        }
    }
}