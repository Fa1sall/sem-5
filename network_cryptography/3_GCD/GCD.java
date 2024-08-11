import java.util.Scanner;

public class GCD{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values: ");
        System.out.print("a: ");
        int a = scanner.nextInt();
        System.out.print("b: ");
        int b = scanner.nextInt();
        System.out.println("GCD: " + gcd(a,b));
    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        } else{
            return gcd(b,Math.abs(a-b));
        }

    }
}