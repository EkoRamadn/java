package hash;

import animasi.Animtext;

public class HillCipherHash {

    static int mod(int n, int m) {
        return ((n % m) + m) % m;
    }

    static int charToNum(char c) {
        if (Character.toUpperCase(c) == 'Z')
            return 0;
        return (Character.toUpperCase(c) - 'A') + 1;
    }

    static char numToChar(int n) {
        int modded = mod(n, 26);
        return (char) (modded == 0 ? 'Z' : (modded - 1 + 'A'));
    }

    public static int[][] getInvers(int[][] matrix) {
        int[][] adj = getAdjoin(matrix);
        int det = getDet(matrix);

        int[][] invers = new int[3][3];
        for (int i = 0; i < invers.length; i++) {
            for (int j = 0; j < invers.length; j++) {
                invers[i][j] = 1 / det * adj[i][j];
            }
        }

        return invers;
    }

    public static int[][] getAdjoin(int[][] matrix) {
        int[][] adj = new int[3][3];
        adj[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]);
        adj[1][0] = -(matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
        adj[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);

        adj[0][1] = -(matrix[0][1] * matrix[2][2] - matrix[0][2] * matrix[2][1]);
        adj[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]);
        adj[2][1] = -(matrix[0][0] * matrix[2][1] - matrix[0][1] * matrix[2][0]);

        adj[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]);
        adj[1][2] = -(matrix[0][0] * matrix[1][2] - matrix[0][2] * matrix[1][0]);
        adj[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);

        return adj;
    }

    public static String encryp(String input, int[][] keyMatrix) {
        if (keyMatrix.length != 3 || keyMatrix[0].length != 3) {
            Animtext.charAnim("Key matrix harus 3x3", 15);
        }

        String cleanInput = input.toUpperCase().replaceAll("[^A-Z]", "");
        int blockSize = keyMatrix.length;

        while (cleanInput.length() % blockSize != 0) {
            cleanInput += 'X';
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cleanInput.length(); i += blockSize) {
            int[] block = new int[blockSize];

            for (int j = 0; j < blockSize; j++) {
                block[j] = charToNum(cleanInput.charAt(i + j));
            }

            for (int row = 0; row < blockSize; row++) {
                int sum = 0;
                for (int col = 0; col < blockSize; col++) {
                    sum += keyMatrix[row][col] * block[col];
                }
                result.append(numToChar(sum));
            }
        }

        return result.toString();
    }

    static int getDet(int[][] m) {
        int det = m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
        return det;
    }

    static int modInverse(int a, int m) {
        a = mod(a, m);
        for (int x = 1; x < m; x++) {
            if (mod(a * x, m) == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException("Tidak ada invers modulo. Determinan dan 26 tidak coprime");
    }

    public static String decrypt(String input, int[][] keyMatrix) {
        int blockSize = keyMatrix.length;
        int[][] invers = getInvers(keyMatrix);

        String cleanInput = input.toUpperCase().replaceAll("[^A-Z]", "");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cleanInput.length(); i += blockSize) {
            int[] block = new int[blockSize];

            for (int j = 0; j < blockSize; j++) {
                block[j] = charToNum(cleanInput.charAt(i + j));
            }

            for (int row = 0; row < blockSize; row++) {
                int sum = 0;
                for (int col = 0; col < blockSize; col++) {
                    sum += invers[row][col] * block[col];
                }
                result.append(numToChar(sum));
            }
        }

        return result.toString();
    }

    public static void vertifyMyPass(String myPass, String hashPass, int[][] keyMatrik) {
        String cleanPass = myPass.toUpperCase();
        while (cleanPass.length() % 3 != 0) {
            cleanPass += 'X';
        }

        String hash = decrypt(hashPass, keyMatrik);

        if (cleanPass.equals(hash)) {
            System.out.println("this vertify");
        } else {
            System.out.println("not vertify");
        }
    }

    // public static String decrypt(String cipherText, int[][] keyMatrix) {
    // return vertify(cipherText, keyMatrix);
    // }
}
