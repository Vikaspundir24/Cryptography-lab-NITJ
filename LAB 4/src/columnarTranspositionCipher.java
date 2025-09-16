class ColumnarTranspositionCipher {
    public static void main(String[] args) {
        String plainText = "war is starting soon";
        int n = 9; // matrix size n x n

        if (n * n < plainText.length()) {
            System.out.println("Error: Matrix size too small for the given text.");
            return;
        }

        char[][] matrix = new char[n][n];

        // Fill the matrix row-wise with plainText and pad with 'X'
        int index = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (index < plainText.length()) {
                    matrix[row][col] = plainText.charAt(index);
                    index++;
                } else {
                    matrix[row][col] = 'X'; // padding
                }
            }
        }

        // Display the filled matrix
        System.out.println("Encryption Matrix:");
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        // Read the matrix column-wise to generate ciphertext
        StringBuilder cipherText = new StringBuilder();
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                cipherText.append(matrix[row][col]);
            }
        }

        System.out.println("Ciphertext:");
        System.out.println(cipherText.toString());

        // Deciphering
        char[][] decipherMatrix = new char[n][n];
        index = 0;

        // Fill the matrix column-wise with ciphertext
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                decipherMatrix[row][col] = cipherText.charAt(index++);
            }
        }

        // Read the matrix row-wise to get the plaintext back
        StringBuilder decryptedText = new StringBuilder();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                decryptedText.append(decipherMatrix[row][col]);
            }
        }

        System.out.println("Decrypted Text (with padding):");
        System.out.println(decryptedText.toString());

        // Removing 'X'
        String result = decryptedText.toString().replaceAll();

        System.out.println("Decrypted Text (without padding):");
        System.out.println(result);
    }
}
