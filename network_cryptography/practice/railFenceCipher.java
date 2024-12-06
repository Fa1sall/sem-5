import java.util.Scanner;


public class railFenceCipher {

    public static String encrypt(String text,int key){
        StringBuilder result = new StringBuilder();
        int len = text.length();

        for(int i=0;i<key;i++){
            int step1 = 2 * (key-i-1);
            int step2 = 2 * i;
            int pos = i;
            boolean toggle = true;

            while(pos<len){
                result.append(text.charAt(pos));
                if(step1==0 || step2==0){
                    pos += step1+step2;
                }else{
                    if(toggle){
                        pos+=step1;
                    }else{
                        pos+=step2;
                    }
                    toggle=!toggle;
                }
            }
        }
        return result.toString();
    }

    public static String decrypt(String text,int key){
        char[] result = new char[text.length()];
        int index=0, len = text.length();

        for(int i=0;i<key;i++){
            int step1 = 2 * (key-i-1);
            int step2 = 2 * i;
            int pos = i;
            boolean toggle = true;

            while(pos<len){
                result[pos] = text.charAt(index++);
                if(step1==0 || step2==0){
                    pos += step1 + step2;
                }else{
                    if(toggle){
                        pos += step1;
                    }else{
                        pos += step2;
                    }
                    toggle = !toggle;
                }
            }
        }
        return new String(result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to be encrypted: ");
        String text = scanner.nextLine();

        System.out.println("Enter key value (number of rails): ");
        int key = Integer.valueOf(scanner.nextLine());

        String encryptedText = encrypt(text, key);
        String decryptedText = decrypt(encryptedText, key);

        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
        scanner.close();
    }
}
