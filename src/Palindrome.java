
public class Palindrome {

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("212212"));
    }

    public boolean isPalindrome(String word) {

        char[] charWord = word.toCharArray();
        int charWordLength = charWord.length;

        for (int i = 0; i < charWordLength / 2; i++) {

            if (charWord[i] != charWord[word.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
