import java.util.Arrays;
import java.util.Scanner;

public class ArrayProject {

    static int[] ray = new int[10];//The program should create an integer array with 10 elements

    public static double getAvg() {//Methods used for sum, average, max, and min
        double sum = 0;
        for (int num : ray) {
            sum += num;
        }
        return sum / ray.length;

    }

    public static int getSum() {
        int sum = 0;
        for (int num : ray) {
            sum += num;
        }
        return sum;
    }

    public static int getMin() {
        int min = Integer.MAX_VALUE;
        for (int num : ray) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int getMax() {
        int max = Integer.MIN_VALUE;
        for (int num : ray) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void findValue(int[] ar, int x) {//Value searcher
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (x == ar[i]) {
                System.out.println(x + " can be found on index: " + i);
                count++;
            }

        }
        if (count < 1) {
            System.out.println("Sorry, could not find your desired value");//Message displayed indicating value was not found
        }
    }

    public static int[] swap(int x, int y) {
        int temp = ray[x];
        ray[x] = ray[y];
        ray[y] = temp;
        return ray;

    }

    public static int[] replace(int z, int f) {
        ray[z] = f;
        return ray;

    }

    public static void toString(int[] ar) {
        System.out.print("[ ");
        for (int num : ar) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        System.out.println("Sum = " + ArrayProject.getSum());
        System.out.println("Average = " + ArrayProject.getAvg());
        System.out.println("Min = " + ArrayProject.getMin());
        System.out.println("Max = " + ArrayProject.getMax());

    }

    public static void main(String[] args) {
        for(int i = 0; i < ray.length; i++){
            ray[i] = (int) (Math.random() * 99 + 1);//initialize it with random values between 1 and 100
        }

        Scanner scan = new Scanner(System.in);
        Arrays.sort(ray);
        System.out.println("Array Before: ");//display elements before in ascending order
        toString(ray);

        System.out.print("\nWhat value would you like to search for: ");//Program prompt to enter a search value
        int x = scan.nextInt();
        findValue(ray, x);

        System.out.print("\nWhat index would you like to replace: ");//Prompt to enter an index and new value to replace
        int y = scan.nextInt();
        while (y <= 0 || y >= 10) {
            System.out.print("Invalid Value, Try again: ");
            y = scan.nextInt();
        }
        System.out.print("What value would you want inserted: ");
        int z = scan.nextInt();
        while(z>100 || z<1){
            System.out.print("Invalid Value: Try Again: ");
            z = scan.nextInt();
        }
        replace(y, z);
        toString(ray);//Modified array display

        System.out.print("\nEnter two indices which will have their values swapped: ");//Prompt to enter two indices in the array
        int b = scan.nextInt();

        while (b <= 0 || b >= 10) {
            System.out.println("Invalid Value, Try again: ");
            b = scan.nextInt();
        }
        int c = scan.nextInt();
        while (c <= 0 || c >= 10) {
            System.out.print("Invalid Value, Try again: ");
            c = scan.nextInt();
        }
        swap(b, c);
        toString(ray);//Modified array display

        Arrays.sort(ray);
        System.out.println("\nArray after: ");//display elements before in descending order
        toString(ray);
        scan.close();

    }
}
