import javax.naming.OperationNotSupportedException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        MyStack<Integer> stack = new MyStack<>(3);
        System.out.println(stack.push(10) + " added");
        System.out.println(stack.push(20) + " added");
        System.out.println(stack.push(30) + " added");
        System.out.println(stack);
        System.out.println("deleted element is: " + stack.pop());
        System.out.println("stack is empty: " + stack.isEmpty());
        System.out.println("top is: " + stack.peek());
        System.out.println("stack size is: " +stack.size());
        System.out.println("is stack full: " +stack.isFull());
        System.out.println(stack.push(40) + " added");
        System.out.println(stack.push(50) + " added");




//        MyStack<Character> stack = new MyStack<>();
//        String word = "star";
//        for(var ch : word.toCharArray()){
//            stack.push(ch);
//        }
//
//        while (!stack.isEmpty()){
//            System.out.print(stack.pop());
//        }


    }

    static int min(int[] arr, int i, int n){
        return (n == 1)? arr[i] : Math.min(arr[i], min(arr, i + 1, n - 1));
    }

    static int prompt(String msg, Scanner scanner){
        System.out.println(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    static int[] bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }
    static int[] bubbleSortOptimized(int[] arr){
        int n = arr.length;
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for(int i = 0; i < n - 1; i++){
                if(arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
        }
        return arr;
    }
    static void stringReverseRecursive(String str){
        if(str != null){
            if(str.length() == 1){
                System.out.println(str);
            } else {
                //recursively print each character in the string from the end
                System.out.print(str.charAt(str.length() - 1));
                stringReverseRecursive(str.substring(0, str.length() - 1));
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    public Integer sumEvenNumbers(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++)
            if ((i % 2) == 0)
                sum = sum + i;

        return sum;
    }



    static int binarySearch(int[] array, int target){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int midpoint = (low + high)/2;
            if(array[midpoint] == target){
                return midpoint;
            }
            if (array[midpoint] < target) {
                low = midpoint + 1;
            } else
                high = midpoint - 1;
        }
        return -1;
    }
}