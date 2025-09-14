class caesarCipher {

    public static void main(String[] args) {

        String text = "War is going to start today at 3AM !";
        int key = 4;


        text = text.toUpperCase();

        String encryptedText = encrypt(text, key);
        System.out.println("Original Text (Uppercase): " + text);
        System.out.println("Encrypted Text: " + encryptedText);


        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted Text (Uppercase): " + decryptedText);
    }


    public static String encrypt(String plainText, int key) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                char c = (char) (((ch - 'A' + key) % 26) + 'A');
                cipherText.append(c);
            } else {
                cipherText.append(ch);
            }
        }

        return cipherText.toString();
    }


    public static String decrypt(String cipherText, int key) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);


            if (ch >= 'A' && ch <= 'Z') {
                char c = (char) (((ch - 'A' - key + 26) % 26) + 'A');
                plainText.append(c);
            } else {
                plainText.append(ch);
            }
        }

        return plainText.toString();
    }
}
