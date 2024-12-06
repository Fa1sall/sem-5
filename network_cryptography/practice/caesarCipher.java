import java.util.Scanner;

public class caesarCipher{

    public static String encrypt(String text,int shiftKey){
        StringBuilder sb = new StringBuilder();
        char letterCase = 'a';
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(Character.isLetter(ch)){
                letterCase = Character.isLowerCase(ch) ? 'a' : 'A';
                int pos = ch - letterCase;
                int encryptedPos = (pos+shiftKey)%26;
                char encryptedChar = (char) (encryptedPos + letterCase);
                sb.append(encryptedChar);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String decrypt(String text,int shiftKey){
        return encrypt(text,(26-shiftKey)%26);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter text to be encrypted");
        String text = scanner.nextLine();
        System.out.println("Enter shift key: ");
        int shiftKey = Integer.valueOf(scanner.nextLine());

        String encryptedText = encrypt(text, shiftKey);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decrypt(encryptedText, shiftKey));
        scanner.close();
    }
}