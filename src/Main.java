import java.util.Scanner;

class Parentheses {
    private String string;
    private char currentItem;
    private char nextItem;
    private boolean result;

    void setStr(String string) {
        this.string = string;
        checkLength();
    }

    private void checkLength() {
        if (string.charAt(string.length() - 1) == '{' || string.charAt(string.length() - 1) == '(' || string.charAt(string.length() - 1) == '[') {
            result = false;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '[' || string.charAt(i) == '(' || string.charAt(i) == '{') {
                a++;
            }
            if (string.charAt(i) == ']' || string.charAt(i) == ')' || string.charAt(i) == '}') {
                b++;
            }
        }
        if (a == b) {
            processing();
        }
        messageResult();
    }

    private void findItem() {
        result = (currentItem == '{' && nextItem == '}') || (currentItem == '(' && nextItem == ')') || (currentItem == '[' && nextItem == ']');
    }

    private int changePosition(int i) {
        if (string.length() != 2)
            i++;
        if (result || i > 2)
            i = 0;
        return i;
    }

    private void messageResult() {
        System.out.println(result);
    }

    private void processing() {
        int i = 0;
        while (string.length() != 2) {
            currentItem = string.charAt(i);
            nextItem = string.charAt(i + 1);
            findItem();
            if (result) {
                string = string.substring(0, i) + string.substring(i + 2);
            }
            i = changePosition(i);
        }
        currentItem = string.charAt(0);
        nextItem = string.charAt(1);
        findItem();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parentheses parentheses = new Parentheses();
        System.out.print("Enter the string: ");
        String string = in.nextLine();
        parentheses.setStr(string);
    }
}