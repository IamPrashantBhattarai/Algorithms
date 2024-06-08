public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop() {
        if (isEmpty()) {
            return null; // or throw an exception depending on your requirement
        }
        String item = first.item;
        first = first.next;
        return item;
    }

    // Inner class Node definition is already provided above.
}
