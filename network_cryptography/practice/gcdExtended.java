import java.util.Scanner;

public class gcdExtended {

    public static void gcdExtended(long a,long b){
        long x=0,y=1,lastx=1,lasty=1,temp,q,r,modInverse=0;
        long min = Math.min(a,b);

        while(b!=0){
            q = a/b;
            r = a%b;

            a=b;
            b=r;

            temp=x;
            x=lastx-q*x;
            lastx=temp;

            temp=y;
            y=lasty-q*y;
            lasty=temp;
        }

        if(lastx<0){
            modInverse = min + lastx;
        }else{
            modInverse = lastx;
        }
        System.out.println("GCD: " + a + " and roots: " + lastx + " , " + lasty);
        System.out.println("Mod Inverse: " + modInverse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        long a = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter b: ");
        long b = Integer.valueOf(scanner.nextLine());
        gcdExtended(a, b);
        scanner.close();
    }
}
