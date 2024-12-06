import java.util.Scanner;
import java.util.Random;

public class RSA {

    public static int modExp(int base,int exp,int mod){
        base = base % mod;
        int result = 1;

        while(exp>0){
            if(exp%2==1){
                result = (result*base)%mod;
            }
            base=(base*base)%mod;
            exp=exp/2;
        }
        return result;
    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int d,e;

        System.out.println("Enter value of p:");
        int p = Integer.valueOf(scanner.nextLine());

        System.out.println("Enter value of q:");
        int q = Integer.valueOf(scanner.nextLine());

        int n = p * q;
        System.out.println("n: " + n);
        int phi = (p-1) * (q-1);
        System.out.println("phi: " + phi);

        do{
            e = random.nextInt(phi-1)+1;
        }while(gcd(e,phi) != 1);

        do{
            d = random.nextInt(phi-1)+1;
        }while((d * e) % phi != 1);

        System.out.println("Enter number to be encrypted: ");
        int m = Integer.valueOf(scanner.nextLine());

        int encrypted = modExp(m,e,n);
        System.out.println("Encrypted: " + encrypted);

        System.out.println("Enter number to be decrypted: ");
        int c = Integer.valueOf(scanner.nextLine());

        int decrypted = modExp(c,d,n);
        System.out.println("Decrypted: " + decrypted);
    }
}
