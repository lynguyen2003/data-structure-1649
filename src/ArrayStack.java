import java.util.*;

public class ArrayStack<E> {

    public static final int CAPACITY = 1000; // default array capacity
    private int topIndex; // index of the top element in stack
    private E[] data; // generic array used for storage

    public ArrayStack() {
        this(CAPACITY);
    } // constructs stack with default capacity

    public ArrayStack(int capacity) { // constructs stack with given capacity
        topIndex = -1;
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    public int size() {
        return (topIndex + 1);
    }

    public boolean empty() {
        return (topIndex == -1);
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++topIndex] = e; // increment topIndex before storing new item
    }

    public E peek() throws EmptyStackException {
        if (empty()) throw new EmptyStackException();
        return data[topIndex];
    }

    public E pop() throws EmptyStackException {
        if (empty()) throw new EmptyStackException();
        E answer = data[topIndex];
        data[topIndex] = null; // dereference to help garbage collection
        topIndex--;
        return answer;
    }

    public static void main(String args[]) {
        ArrayStack<String> messages = new ArrayStack<>();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add message to Stack");
            System.out.println("2. Show all messages in Stack");
            System.out.println("3. Remove messages from Stack");
            System.out.println("4. Check if Stack is Empty");
            System.out.println("5. Get size of the Stack");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter message to add: ");
                    String message = sc.nextLine();
                    messages.push(message);
                    System.out.println("Message added to Stack.");
                    break;

                case 2:
                    if (messages.empty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Messages in Stack:");
                        ArrayStack<String> tempStack = new ArrayStack<>();
                        while (!messages.empty()) {
                            String msg = messages.pop();
                            System.out.println(msg);
                            tempStack.push(msg);
                        }
                        while (!tempStack.empty()) {
                            messages.push(tempStack.pop());
                        }
                    }
                    break;

                case 3:
                    if (messages.empty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        String removedMsg = messages.pop();
                        System.out.println("Message removed from Stack: " + removedMsg);
                    }
                    break;

                case 4:
                    if (messages.empty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;

                case 5:
                    System.out.println("Size of the Stack: " + messages.size());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println(); // print an empty line for readability
        }
    }
}