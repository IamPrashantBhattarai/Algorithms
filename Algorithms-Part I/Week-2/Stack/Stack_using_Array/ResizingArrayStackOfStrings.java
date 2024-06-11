import java.security.DrbgParameters.Capability;

public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;

    //Constructor to initialize the stack with a given capacity
    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        if (N == s.length) resize(2 * s.length);
        s[N++] = item; 
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4) {
            resize(s.length/2);
        }
        return item;
    }

    private void resize(int capacity)
    {
        String[] copy = new String[capacity];
        for(int i = 0; i < N; i++){
            copy[i] = s[i];
        }
        s = copy;
    }


    //Main method for testing

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        stack.push("hellooooo");
        stack.push("wo");
        System.out.println(stack.pop()); // prints "world"
        System.out.println(stack.pop()); // prints "hello"
    }
    
}
