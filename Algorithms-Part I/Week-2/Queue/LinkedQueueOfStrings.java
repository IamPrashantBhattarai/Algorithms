public class LinkedQueueOfStrings {

    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }

        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
        
        // Enqueue items
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        
        // Dequeue and print items
        System.out.println(queue.dequeue()); // prints "A"
        System.out.println(queue.dequeue()); // prints "B"
        
        // Enqueue more items
        queue.enqueue("D");
        queue.enqueue("E");
        
        // Dequeue and print items
        System.out.println(queue.dequeue()); // prints "C"
        System.out.println(queue.dequeue()); // prints "D"
        System.out.println(queue.dequeue()); // prints "E"
        
        // Uncommenting the following line will throw an exception as the queue is empty
        // System.out.println(queue.dequeue());
    }
  
    
}