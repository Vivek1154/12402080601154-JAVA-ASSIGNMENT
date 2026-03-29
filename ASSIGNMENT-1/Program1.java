import java.util.Arrays;

class ArrayStringOperations {
    private int[] numbers;
    private String text;

    // Constructor
    public ArrayStringOperations(int[] numbers, String text) {
        this.numbers = numbers;
        this.text = text;
    }

    // Reverse Array
    public void reverseArray() {
        int n = numbers.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[n - 1 - i];
            numbers[n - 1 - i] = temp;
        }
        System.out.println("Reversed Array: " + Arrays.toString(numbers));
    }

    // Sort Array
    public void sortArray() {
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }

    // Search in Array
    public void searchArray(int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                System.out.println("Element " + key + " found at index " + i);
                return;
            }
        }
        System.out.println("Element " + key + " not found.");
    }

    // Average of Array
    public void averageArray() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double avg = (double) sum / numbers.length;
        System.out.println("Average of Array: " + avg);
    }

    // Maximum in Array
    public void maxArray() {
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum Element: " + max);
    }

    // Reverse String
    public void reverseString() {
        String reversed = new StringBuilder(text).reverse().toString();
        System.out.println("Reversed String: " + reversed);
    }

    // Sort String (alphabetically)
    public void sortString() {
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println("Sorted String: " + sorted);
    }

    // Search character in String
    public void searchString(char ch) {
        int index = text.indexOf(ch);
        if (index != -1) {
            System.out.println("Character '" + ch + "' found at index " + index);
        } else {
            System.out.println("Character '" + ch + "' not found.");
        }
    }
}

// Main class
public class Program1 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};
        String str = "programming";

        ArrayStringOperations obj = new ArrayStringOperations(arr, str);

        // Array operations
        obj.reverseArray();
        obj.sortArray();
        obj.searchArray(9);
        obj.averageArray();
        obj.maxArray();

        // String operations
        obj.reverseString();
        obj.sortString();
        obj.searchString('g');
    }
}

