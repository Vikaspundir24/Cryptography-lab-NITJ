class railFenceCipher {

    public static void main(String[] args) {
        String message = "war will start at 5 am";
        int rails = 3;

        String encrypted = encrypt(message.toLowerCase(), rails);
        String decrypted = decrypt(encrypted, rails);

        System.out.println("Original  : " + message);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);
    }

    static String encrypt(String text, int rails) {
        StringBuilder[] rail = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) rail[i] = new StringBuilder();

        int r = 0;
        boolean down = true;

        for (char c : text.toCharArray()) {
            rail[r].append(c);
            if (r == 0) down = true;
            else if (r == rails - 1) down = false;
            r += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rail) result.append(sb);
        return result.toString();
    }

    static String decrypt(String text, int rails) {
        int len = text.length();
        boolean[][] marker = new boolean[rails][len];

        int r = 0;
        boolean down = true;
        for (int i = 0; i < len; i++) {
            marker[r][i] = true;
            if (r == 0) down = true;
            else if (r == rails - 1) down = false;
            r += down ? 1 : -1;
        }

        char[][] railMatrix = new char[rails][len];
        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < len; j++) {
                if (marker[i][j]) {
                    railMatrix[i][j] = text.charAt(index++);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        r = 0;
        down = true;
        for (int i = 0; i < len; i++) {
            result.append(railMatrix[r][i]);
            if (r == 0) down = true;
            else if (r == rails - 1) down = false;
            r += down ? 1 : -1;
        }

        return result.toString();
    }
}
