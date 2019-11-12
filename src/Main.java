import java.util.Scanner;

class Parentheses {
    private String string;
    private char currentItem;
    private char nextItem;
    private boolean result;

    void setStr(String string) {
        this.string = string;
    }

    boolean checkLength() {
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

    private int changePosition(int i) {
        if (result || i > 2)
            i = 0;
        return i;
    }

    private void processing() {
        int i = 0;
        while (string.length() != 0) {
            currentItem = string.charAt(i);
            nextItem = string.charAt(i + 1);
            result = (currentItem == '{' && nextItem == '}') || (currentItem == '(' && nextItem == ')') || (currentItem == '[' && nextItem == ']');
            if (result || string.length() == 2) {
                string = string.substring(0, i) + string.substring(i + 2);
            }
            i = changePosition(i);
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