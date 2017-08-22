
public class Palindrome {

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindromeSmart("212212"));

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

    public boolean isPalindromeSmart(String word) {

        System.out.println("Word " + word);
        String reverted = new StringBuilder(word).reverse().toString();
        System.out.println("Reverted : " + reverted);

        if (word.equals(reverted)) {
            return true;
        }
        return false;

    }
}
