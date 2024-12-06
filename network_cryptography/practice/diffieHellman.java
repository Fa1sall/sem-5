import java.util.Scanner;

public class diffieHellman {

    public static long power(long a,long b,long p){
        return (long)Math.pow(a,b)%p;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter P: ");
        long P = Long.valueOf(scanner.nextLine());
        System.out.println("Enter G: ");
        long G = Long.valueOf(scanner.nextLine());

        System.out.println("Enter private key a for x: ");
        long a = Long.valueOf(scanner.nextLine());
        long x = power(G,a,P);

        System.out.println("Enter private key b for y: ");
        long b = Long.valueOf(scanner.nextLine());
        long y = power(G,b,P);

        long ka = power(y,a,P);
        long kb = power(x,b,P);

        System.out.println("Key Exchanged Successfully!");
        System.out.println("Secret key of x: " + ka);
        System.out.println("Secret key of y: " + kb);
        scanner.close();
    }
}
