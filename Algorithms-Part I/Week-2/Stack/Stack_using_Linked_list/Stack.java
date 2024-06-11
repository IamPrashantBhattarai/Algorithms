public class Stack<Item> {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        Item item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Push items onto the stack of all the types so we ude the generic method to address all the data types.
        stack.push("Hello");
        stack.push("World");
        stack.push("!");
        stack.push("123");

        // Pop items off the stack and print them
        System.out.println(stack.pop()); // prints "!"
        System.out.println(stack.pop()); // prints "World"
        System.out.println(stack.pop()); // prints "Hello"

        // Uncommenting the following line will throw an exception as the stack is empty
        // System.out.println(stack.pop());
    }
    
}
