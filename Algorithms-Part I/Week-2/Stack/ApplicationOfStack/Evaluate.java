//This is the java code to calculate the expression in Postfix manner
import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a expression:");
        String expression = scanner.nextLine();
        scanner.close();

        //Regular expressions to split the input into tockens
        String[] tokens = expression.split("(?<=[-+*/()])|(?=[-+*/()])");

        for (String s : tokens) {
            s = s.trim(); // remove any extra whitespace
            if (s.isEmpty()) continue;
            if (s.equals("(")) {
                // Do nothing for left parenthesis
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
}
