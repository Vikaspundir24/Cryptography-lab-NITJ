public class SubstitutionCipher {
    public static void main(String[] args) {
        String plainText = "war is going to start today at 5am";
        int key  = 2;
        System.out.println("Colonel there is a message for you : ");
        System.out.println(cipherText(plainText,key));

    }
    static String cipherText(String plainText, int key){
        String cipherText = "";
        for (int i = 0; i< plainText.length();i++){
            char eachText = (char)(((plainText.charAt(i) - 'a' + key)%26)+'a');
            cipherText += eachText;
        }

        return cipherText;
    }
    /*static String decipherText(String cipherText, int key){
        String plainText = "";
        for (int i=0; i< cipherText.length();i++){
            char eachText =  (cipherText.charAt(i) - 'a' - key)

        }
        return plainText;
    }*/
}