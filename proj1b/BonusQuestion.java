public class BonusQuestion {
    public static void main(String[] args) {
        int minLength = 4;
        Palindrome palindrome = new Palindrome();

        int maxCount = 0;
        int mostLetterCount = 0;
        String largestWord = "";
        int N = 0;

        for (int i = 0; i < 27; i++) {
            In in = new In("../library-sp19/data/words.txt");
            int count = 0;

            while (!in.isEmpty()) {
                String word = in.readString();
                CharacterComparator obn = new OffByN(i);

                if (word.length() >= minLength && palindrome.isPalindrome(word, obn)) {
                    //System.out.println(word);
                    if (word.length() > mostLetterCount) {
                        mostLetterCount = word.length();
                        largestWord = word;
                    }
                    count++;
                }
            }
            System.out.println("OffBy" + i + " count: " + count);
            if (count > maxCount) {
                maxCount = count;
                N = i;
            }
        }

        System.out.println("OffBy" + N + " has largest word count with " + maxCount + " total words.");
        System.out.println("Largest word is " + largestWord + " with " + mostLetterCount + " letters.");
    }
}
