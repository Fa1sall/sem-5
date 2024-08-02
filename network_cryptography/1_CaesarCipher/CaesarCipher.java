import java.util.Scanner;

public class CaesarCipher{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Caesar Cipher Menu:---");
        System.out.println("1 => Encrypt Data");
        System.out.println("2 => Decrypt Data");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
            System.out.println("Enter text to Encrpt: ");
            System.out.println("Enter shiftKey: ");
            int shiftKey = scanner.nextInt();
            System.out.println(EncryptText("XYZ", shiftKey));
        }
    }

    public static String EncryptText(String text,int shift){
        StringBuilder encryptedText = new StringBuilder();
        char encryptChar= ' ';
        for(char i=0;i<text.length();i++){
            int charPosition = (int) text.charAt(i); 
            if(!(text.charAt(i)==' ')){
                if(charPosition+shift>26){
                    int finalPosition = (charPosition+shift)-26;
                    encryptChar = (char) finalPosition;
                    encryptedText.append(encryptChar);
                } else {
                    encryptChar = (char)(text.charAt(i) + shift);
                    encryptedText.append(encryptChar);
                }
            }else{
                encryptedText.append(' ');
            }
        }
        return encryptedText.toString();
    }

    public static String DecryptText(String text,int shift){
        return "";
    }
}