import java.awt.Point;
import java.util.Scanner;

public class PlayfairCipher {
    private static char[][] charTable;
    private static Point[] positions;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key for the Playfair cipher:");
        String key = sc.nextLine();
        System.out.println("Enter the text to be encrypted:");
        String text = sc.nextLine();

        createTable(key);
        String encryptedText = encode(prepareText(text));
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = decode(encryptedText);
        System.out.println("Decrypted text: " + decryptedText);
    }

    private static void createTable(String key) {
        charTable = new char[5][5];
        positions = new Point[26];
        String s = prepareText(key + "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        int len = s.length();
        for (int i = 0, k = 0; i < len; i++) {
            char c = s.charAt(i);
            if (positions[c - 'A'] == null) {
                charTable[k / 5][k % 5] = c;
                positions[c - 'A'] = new Point(k % 5, k / 5);
                k++;
            }
        }
    }

    private static String prepareText(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i += 2) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'X');
            }
        }
        if (sb.length() % 2 != 0) {
            sb.append('X');
        }
        return sb.toString();
    }

    private static String encode(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i += 2) {
            char a = sb.charAt(i);
            char b = sb.charAt(i + 1);
            int row1 = positions[a - 'A'].y;
            int row2 = positions[b - 'A'].y;
            int col1 = positions[a - 'A'].x;
            int col2 = positions[b - 'A'].x;
            if (row1 == row2) {
                sb.setCharAt(i, charTable[row1][(col1 + 1) % 5]);
                sb.setCharAt(i + 1, charTable[row2][(col2 + 1) % 5]);
            } else if (col1 == col2) {
                sb.setCharAt(i, charTable[(row1 + 1) % 5][col1]);
                sb.setCharAt(i + 1, charTable[(row2 + 1) % 5][col2]);
            } else {
                sb.setCharAt(i, charTable[row1][col2]);
                sb.setCharAt(i + 1, charTable[row2][col1]);
            }
        }
        return sb.toString();
    }

    private static String decode(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i += 2) {
            char a = sb.charAt(i);
            char b = sb.charAt(i + 1);
            int row1 = positions[a - 'A'].y;
            int row2 = positions[b - 'A'].y;
            int col1 = positions[a - 'A'].x;
            int col2 = positions[b - 'A'].x;
            if (row1 == row2) {
                sb.setCharAt(i, charTable[row1][(col1 + 4) % 5]);
                sb.setCharAt(i + 1, charTable[row2][(col2 + 4) % 5]);
            } else if (col1 == col2) {
                sb.setCharAt(i, charTable[(row1 + 4) % 5][col1]);
                sb.setCharAt(i + 1, charTable[(row2 + 4) % 5][col2]);
            } else {
                sb.setCharAt(i, charTable[row1][col2]);
                sb.setCharAt(i + 1, charTable[row2][col1]);
            }
        }
        return sb.toString();
    }
}
