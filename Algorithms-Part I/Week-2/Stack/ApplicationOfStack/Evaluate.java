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
        scanner.close();

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("(")) {
                //Do nothing for the left parenthesis
            }
            else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            }
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                vals.push(v);
            } else{
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
}
