// Java program to generate a random AlphaNumeric String
// using Math.random() method and implement one-time pad encryption and decryption

public class oneTimePadding {
    public static void main(String[] args)
    {
        String plainText = "War is going to start at dawn";


        // Convert plain text to uppercase
        plainText = plainText.toUpperCase();
        System.out.println("Plain Text -> " + plainText);

        // Generate key
        int keyLength = plainText.length();
        String key = getRandom(keyLength);
        System.out.println("Key -> " + key);

        // Encrypt
        String cipherText = getCipherText(plainText, key);
        System.out.println("Cipher Text -> " + cipherText);

        // Decrypt
        String decryptedText = decipherText(cipherText, key);
        System.out.println("Decrypted Text -> " + decryptedText);
    }

    // Function to generate a random string of length n
    static String getRandom(int n)
    {
        String totalChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(totalChar.length() * Math.random());
            sb.append(totalChar.charAt(index));
        }

        return sb.toString();
    }

    // Function to encrypt plain text using key
    static String getCipherText(String plainText, String key){
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ptChar = plainText.charAt(i);
            char keyChar = key.charAt(i);

            if (ptChar >= 'A' && ptChar <= 'Z') {
                int ptIndex = ptChar - 'A';
                int keyIndex = keyChar - 'A';
                int cipherIndex = (ptIndex + keyIndex) % 26;
                char cipherChar = (char) ('A' + cipherIndex);
                cipher.append(cipherChar);
            } else {
                cipher.append(ptChar);
            }
        }
        return cipher.toString();
    }

    // Function to decrypt cipher text using key
    static String decipherText(String cipherText, String key){
        StringBuilder plain = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char ctChar = cipherText.charAt(i);
            char keyChar = key.charAt(i);

            if (ctChar >= 'A' && ctChar <= 'Z') {
                int ctIndex = ctChar - 'A';
                int keyIndex = keyChar - 'A';
                int plainIndex = (ctIndex - keyIndex + 26) % 26;
                char plainChar = (char) ('A' + plainIndex);
                plain.append(plainChar);
            } else {
                plain.append(ctChar);
            }
        }
        return plain.toString();
    }
}
