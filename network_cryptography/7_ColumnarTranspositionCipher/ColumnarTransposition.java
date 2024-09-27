import java.util.*;

public class ColumnarTransposition{
    static Map<Character, Integer> keyMap = new HashMap<>();

    static void setPermutationOrder(String key) {
        for (int i = 0; i < key.length(); i++) {
            keyMap.put(key.charAt(i), i);
        }
    }

    // Encryption
    static String encryptMessage(String msg,String key) {
        int row, col;
        StringBuilder cipher = new StringBuilder();

        col = key.length();

        row = (int) Math.ceil((double) msg.length() / col);

        char[][] matrix = new char[row][col];

        for (int i = 0, k = 0; i < row; i++) {
            for (int j = 0; j < col; ) {
                if (k < msg.length()) {
                    char ch = msg.charAt(k);
                    if (Character.isLetter(ch) || ch == ' ') {
                        matrix[i][j] = ch;
                        j++;
                    }
                    k++;
                } else {
                    matrix[i][j] = '_';
                    j++;
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : keyMap.entrySet()) {
            int columnIndex = entry.getValue();

            for (int i = 0; i < row; i++) {
                if (Character.isLetter(matrix[i][columnIndex]) || matrix[i][columnIndex] == ' ' || matrix[i][columnIndex] == '_') {
                    cipher.append(matrix[i][columnIndex]);
                }
            }
        }

        return cipher.toString();
    }

    // Decryption
    static String decryptMessage(String cipher,String key) {
        int col = key.length();

        int row = (int) Math.ceil((double) cipher.length() / col);
        char[][] cipherMat = new char[row][col];

        int k = 0;
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                cipherMat[i][j] = cipher.charAt(k);
                k++;
            }
        }

        int index = 0;
        for (Map.Entry<Character, Integer> entry : keyMap.entrySet()) {
            entry.setValue(index++);
        }

        char[][] decCipher = new char[row][col];
        for (int l = 0; l < key.length(); l++) {
            int columnIndex = keyMap.get(key.charAt(l));
            for (int i = 0; i < row; i++) {
                decCipher[i][l] = cipherMat[i][columnIndex];
            }
        }

        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (decCipher[i][j] != '_') {
                    msg.append(decCipher[i][j]);
                }
            }
        }
        return msg.toString();
    }

    public static void main(String[] args) {
        /* Message */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Message (Plain Text): ");
        String msg = scanner.nextLine();

        System.out.println("Enter key: ");
        String key = scanner.nextLine();

        setPermutationOrder(key);

        // Calling encryption function
        String cipher = encryptMessage(msg,key);
        System.out.println("Encrypted Message: " + cipher);

        // Calling Decryption function
        System.out.println("Decrypted Message: " + decryptMessage(cipher,key));
    }
}
