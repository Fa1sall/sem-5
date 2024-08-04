import java.util.Scanner;

public class CaesarCipher{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Caesar Cipher Menu:---");
        System.out.println("1 -> Encrypt Data");
        System.out.println("2 -> Decrypt Data");
        System.out.print("Enter choice: ");
        int choice = Integer.valueOf(scanner.nextLine());

        switch(choice){
            case 1:
                System.out.print("Enter text to Encrpt/Decrypt: ");
                String input = scanner.nextLine();
                System.out.print("Enter shiftKey: ");
                int shiftKey = scanner.nextInt();
                System.out.println(EncryptText(input, shiftKey));
                break;

            case 2:
                System.out.print("Enter text to Encrpt/Decrypt: ");
                input = scanner.nextLine();
                System.out.print("Enter shiftKey: ");
                shiftKey = scanner.nextInt();
                System.out.println(DecryptText(input, shiftKey));
                break;

            default:
                System.out.println("Invalid Choice");
                break;
        }
    }

    public static String EncryptText(String text,int shift){
        StringBuilder encryptedText = new StringBuilder();
        char letterCase = ' ';
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)!=' '){
                if(text.charAt(i)>='a' && text.charAt(i)<='z'){
                    letterCase = 'a';
                } else {
                    letterCase = 'A';
                }
                int pos = text.charAt(i) - letterCase;
                int encryptedPos = (pos + shift) % 26;
                char encryptedChar = (char) (letterCase + encryptedPos);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(' ');
            }
        }

        return ("Result: " + encryptedText.toString());
    }

    public static String DecryptText(String text,int shift){
        return EncryptText(text,26-(shift%26));
    }
}