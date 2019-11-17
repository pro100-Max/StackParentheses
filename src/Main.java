import java.util.Scanner;

class Parentheses {
    private String string;
    private boolean result;

    void setStr(String string) {
        this.string = string;
    }

    boolean checkLength() {
        if ((string.charAt(0) == '[' || string.charAt(0) == '(' || string.charAt(0) == '{') ||
                (string.charAt(string.length() - 1) == '[' || string.charAt(string.length() - 1) == '(' || string.charAt(string.length() - 1) == '{')) {
            return result;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '[' || string.charAt(i) == '(' || string.charAt(i) == '{') {
                a++;
            } else {
                b++;
            }
        }
        if (a == b) {
            processing();
        }
        return result;
    }

    private void processing() {
        int i = 0;
        while (string.length() != 0) {
            char currentItem = string.charAt(i);
            char nextItem = string.charAt(i + 1);
            result = (currentItem == '{' && nextItem == '}') || (currentItem == '(' && nextItem == ')') || (currentItem == '[' && nextItem == ']');
            if (result || string.length() == 2) {
                string = string.substring(0, i) + string.substring(i + 2);
                i = 0;
            } else {
                i++;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parentheses parentheses = new Parentheses();
        System.out.print("Enter the string: ");
        String string = in.nextLine();
        parentheses.setStr(string);
        System.out.println(parentheses.checkLength());
    }
}