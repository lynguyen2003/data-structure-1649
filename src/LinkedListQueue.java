import java.util.*;

public class LinkedListQueue {
    private Node frontNode, rearNode;
    private int queueSize; // queue size  

    //linked list node  
    private class Node {
        String data;
        Node next;
    }

    //default constructor - initially front & rear are null; size=0; queue is empty  
    public LinkedListQueue() {
        frontNode = null;
        rearNode = null;
        queueSize = 0;
    }

    //check if the queue is empty  
    public boolean isEmpty() {
        return (queueSize == 0);
    }

    //Remove the item from the front of the queue.  
    public String dequeue() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("Queue is Empty");
        String data = frontNode.data;
        frontNode = frontNode.next;
        if (isEmpty()) {
            rearNode = null;
        }
        queueSize--;
        return data;
    }

    public String first() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("Queue is Empty");
        return frontNode.data;
    }

    public int size() {
        return queueSize;
    }

    //Add data at the rear of the queue.  
    public void enqueue(String data) {
        if (data.length() > 250) {
            throw new IllegalArgumentException("Message should not exceed 250 characters");
        }
        Node oldRear = rearNode;
        rearNode = new Node();
        rearNode.data = data;
        rearNode.next = null;
        if (isEmpty()) {
            frontNode = rearNode;
        } else {
            oldRear.next = rearNode;
        }
        queueSize++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListQueue queue = new LinkedListQueue();

        while (true) {
            System.out.println("1. Add messages to queue");
            System.out.println("2. Show all messages in queue");
            System.out.println("3. Removed messages from front");
            System.out.println("4. Removed messages from front end");
            System.out.println("5. Check queue is Empty");
            System.out.println("6. Size of the queue");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter message:");
                    String message = sc.next();
                    queue.enqueue(message);
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is Empty");
                    } else {
                        System.out.println("All messages in queue:");
                        Node currentNode = queue.frontNode;
                        while (currentNode != null) {
                            System.out.println(currentNode.data);
                            currentNode = currentNode.next;
                        }
                    }
                    break;

                case 3:
                    try {
                        String removedMessage = queue.dequeue();
                        System.out.println("Removed message from front: " + removedMessage);
                        System.out.println("Queue update:");
                        Node currentNode = queue.frontNode;
                        while (currentNode != null) {
                            System.out.println(currentNode.data);
                            currentNode = currentNode.next;
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        String removedMessage = queue.dequeue();
                        System.out.println("Removed message from front end: " + removedMessage);
                        Node currentNode = queue.frontNode;
                        while (currentNode != null) {
                            System.out.println(currentNode.data);
                            currentNode = currentNode.next;
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Queue is Empty: " + queue.isEmpty());
                    break;

                case 6:
                    System.out.println("Size of the queue: " + queue.size());
                    break;

                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}