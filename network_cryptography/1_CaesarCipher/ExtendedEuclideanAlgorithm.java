import java.lang.*;
import java.util.Scanner;

public class ExtendedEuclideanAlgorithm {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        long a = scanner.nextInt();
        System.out.print("b: ");
        long b = scanner.nextInt();
        gcdExtended(a, b);
    }
    public static void gcdExtended(long a, long b)
    {
        long x = 0, y = 1, lastx = 1, lasty = 0, temp;
        while (b != 0)
        {
            long q = a / b;
            long r = a % b;

            a = b;
            b = r;

            temp = x;
            x = lastx - q * x;
            lastx = temp;

            temp = y;
            y = lasty - q * y;
            lasty = temp;
        }
        System.out.println("GCD "+a+" and its Roots x: "+ lastx +" y:"+ lasty);
    }
}

