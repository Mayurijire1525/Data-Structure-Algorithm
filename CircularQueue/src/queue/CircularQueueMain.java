package queue;

import java.util.Scanner;

class CircularQueue {  
    private int[] arr;
    private int rear, front;

    public CircularQueue(int size) {
        arr = new int[size];
        rear = -1;
        front = -1;
    }
    public boolean isFull() {
        return (front==-1 &&rear==arr.length-1 )||
        		(front ==rear && front!=-1);
    }

    public boolean isEmpty() {
        return (front ==rear && front ==-1);
    }

    public void push(int val) {
        if (isFull())
            throw new RuntimeException("Queue is full");
        rear=(rear+1)%arr.length;
        arr[rear] = val;
    }

    public void pop() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        front=(front+1)%arr.length;
        if(front == rear) {
        	rear=-1;
        	front=-1;
        }
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
       int index=(front+1)%arr.length;
        return arr[index];
    }
}

public class CircularQueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue s = new  CircularQueue(6);
        int choice, val;
        while (true) {
            System.out.println("\n0.Exit\n1.Push\n2.Pop\n3.Peek\nEnter choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // push
                    try {
                        System.out.println("Enter value to push");
                        val = sc.nextInt();
                        s.push(val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: // pop
                    try {
                        val = s.peek();
                        s.pop();
                        System.out.println("Popped " + val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        val = s.peek();
                        System.out.println("Peek " + val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                 
            }
        }
    }
}
