class main {
    public static void main(String[] args) {
        String plainText = "CRYPTOGRAPHY";
        int key = 3;
        String cipherText = cipherText(plainText, key);
        System.out.println(cipherText);
      //  String decipherText = decipherText(cipherText,key);
      //  System.out.println(decipherText);
    }
    //ENCRYPTION
    static String cipherText(String plainText, int key) {
        if (key <= 1) return plainText;
        char[][] rails = new char[key][plainText.length()];
        int rail = 0;
        int direction = 1; // 1 down, -1 up

        for (int i = 0; i < plainText.length(); i++) {
            rails[rail][i] = plainText.charAt(i);

            if (rail == 0) {
                direction = 1;
            } else if (rail == key - 1) {
                direction = -1;
            }
            rail += direction;
        }

        String cipher = "";
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < plainText.length(); j++) {
                if (rails[i][j] != '\0') {
                    cipher += rails[i][j];
                }
            }
        }
        return cipher;
    }
    //DECRYPTION
//    static String decipherText( String cipherText, int key){
//
//    }
}
