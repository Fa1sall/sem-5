import java.util.Scanner;

public class diffieHellman {

    private static long power(long a, long b, long p)
    {
        if (b == 1)
            return a;
        else
            return (((long)Math.pow(a, b)) % p);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long P, G, x, a, y, b, ka, kb;

        System.out.print("The value of P: ");
        P = Long.valueOf(scanner.nextLine());

        System.out.print("The value of G: ");
        G = Long.valueOf(scanner.nextLine());

        System.out.print("The private key a for X: ");
        a = Long.valueOf(scanner.nextLine());

        x = power(G, a, P);

        System.out.print("The private key b for Y: ");
        b = Long.valueOf(scanner.nextLine());

        y = power(G, b, P);

        ka = power(y, a, P);
        kb = power(x, b, P);

        System.out.println("Secret key for the X is: " + ka);
        System.out.println("Secret key for the Y is: " + kb);
    }
}