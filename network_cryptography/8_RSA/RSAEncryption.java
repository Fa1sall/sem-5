import java.util.Scanner;
import java.util.Random;

public class RSAEncryption {

    public static long gcd(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static boolean isPrime(long a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }

    public static long encrypt(char ch, long n, long e) {
        long temp = ch;
        for (int i = 1; i < e; i++) {
            temp = (temp * ch) % n;
        }
        return temp;
    }

    public static char decrypt(long ch, long n, long d) {
        long temp = ch;
        for (int i = 1; i < d; i++) {
            ch = (char) ((temp * ch) % n);
        }
        return (char) ch;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        long p, q, n, phi, e, d;
        long[] cipher = new long[50];
        char[] text = new char[50];

        System.out.print("Enter the text to be encrypted: ");
        String inputText = sc.nextLine();
        int len = inputText.length();
        inputText.getChars(0, len, text, 0);

        System.out.print("\nEnter the P value: ");
        p = sc.nextLong();

        System.out.print("Enter the q value: ");
        q = sc.nextLong();

        n = p * q;
        phi = (p - 1) * (q - 1);

        do {
            e = rand.nextInt((int) phi);
        } while (gcd(phi, e) != 1);

        do {
            d = rand.nextInt((int) phi);
        } while ((d * e) % phi != 1);

        System.out.println("Two prime numbers (p and q) are: " + p + " and " + q);
        System.out.println("n(p * q) = " + p + " * " + q + " = " + n);
        System.out.println("(p - 1) * (q - 1) = " + phi);
        System.out.println("Public key (n, e): (" + n + ", " + e + ")");
        System.out.println("Private key (n, d): (" + n + ", " + d + ")");

        for (int i = 0; i < len; i++) {
            cipher[i] = encrypt(text[i], n, e);
        }

        System.out.print("Encrypted message: ");
        for (int i = 0; i < len; i++) {
            System.out.print(cipher[i] + " ");
        }

        for (int i = 0; i < len; i++) {
            text[i] = decrypt(cipher[i], n, d);
        }

        System.out.println("\nDecrypted message: ");
        for (int i = 0; i < len; i++) {
            System.out.print(text[i]);
        }

    }
}
