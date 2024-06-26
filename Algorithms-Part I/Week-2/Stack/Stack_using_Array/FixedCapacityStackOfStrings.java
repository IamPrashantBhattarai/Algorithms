public class FixedCapacityStackOfStrings {
    
    private String[] s;
    private int N = 0;

    //Constructor to initialize the stack with a given capacity
    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N] = item; 
        N = N++;
    }

    public String pop() {

        if (isEmpty()) {
            return null;
        }
        String item = s[--N];
        s[N] = null;
        return item;
    }

    public boolean isFull() {
        return N == s.length;
    }


    //Main method for testing

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);

        // Test the push method
        stack.push("Hello");
        stack.push("World");

        // Test the pop method
        System.out.println(stack.pop()); // Outputs: World
        System.out.println(stack.pop()); // Outputs: Hello

        
    }
}

