public class vigenereCipher {

    public static void main(String[] args) {
        String message = "war will start at 5 am";
        String key = "key";

        String encrypted = encrypt(message.toLowerCase(), key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Original  : " + message);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);
    }

    static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        key = key.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isLetter(c)) {
                char k = key.charAt(keyIndex % key.length());
                char e = (char) ((c - 'a' + k - 'a') % 26 + 'a');
                result.append(e);
                keyIndex++;
            } else {
                result.append(c); // keep space or digit
            }
        }
        return result.toString();
    }

    static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        key = key.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isLetter(c)) {
                char k = key.charAt(keyIndex % key.length());
                char d = (char) ((c - k + 26) % 26 + 'a');
                result.append(d);
                keyIndex++;
            } else {
                result.append(c); // keep space or digit
            }
        }
        return result.toString();
    }

    static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
