
public class Main {
    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        stack.push("Hell");
        stack.push("World");
        System.out.println(stack.pop()); // Outputs: World
        System.out.println(stack.pop()); // Outputs: Hello
    }
}
 
