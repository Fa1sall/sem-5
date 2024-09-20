import java.util.Arrays;
import java.util.Scanner;

public class SDES{
    private int[] key = new int[10];
    private int[] k1 = new int[8];
    private int[] k2 = new int[8];

    public SDES(String inputKey) {
        generateKeys(inputKey);
    }

    private void generateKeys(String inputKey) {
        for (int i = 0; i < 10; i++) {
            key[i] = Character.getNumericValue(inputKey.charAt(i));
        }
        key = permute(key, new int[]{2, 4, 1, 6, 3, 9, 0, 8, 7, 5});

        key = leftShift(key, 1);

        k1 = permute(key, new int[]{5, 2, 6, 3, 7, 4, 9, 8});

        key = leftShift(key, 2);

        k2 = permute(key, new int[]{5, 2, 6, 3, 7, 4, 9, 8});
    }

    private int[] permute(int[] key, int[] permutation) {
        int[] permutedKey = new int[permutation.length];
        for (int i = 0; i < permutation.length; i++) {
            permutedKey[i] = key[permutation[i]];
        }
        return permutedKey;
    }

    private int[] leftShift(int[] key, int shifts) {
        int[] shiftedKey = new int[key.length];
        for (int i = 0; i < key.length / 2; i++) {
            shiftedKey[i] = key[(i + shifts) % (key.length / 2)];
            shiftedKey[i + key.length / 2] = key[(i + shifts) % (key.length / 2) + key.length / 2];
        }
        return shiftedKey;
    }

    public int[] getK1() {
        return k1;
    }

    public int[] getK2() {
        return k2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 10-bit key: ");
        int key = scanner.nextInt();
        SDES keyGen = new SDES(String.valueOf(key));
        System.out.println("K1: " + Arrays.toString(keyGen.getK1()));
        System.out.println("K2: " + Arrays.toString(keyGen.getK2()));
    }
}
