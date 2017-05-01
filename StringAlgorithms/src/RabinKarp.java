/**
 * Created by Jerry on 30-04-2017.
 */
public class RabinKarp {
    int prime = 97;

    public int findSubstring(char[] text, char[] pattern) {
        int patternHash = initialHash(pattern, pattern.length);
        int textHash = initialHash(text, pattern.length);
        for (int i = 0; i <= text.length - pattern.length; i++) {
            if (patternHash == textHash && checkMatch(text, pattern, i)) {
                return i;
            } else {
                textHash = calculateHash(text, i + 1, textHash, pattern.length);
            }
        }
        return -1;
    }


    private int initialHash(char[] text, int patternLength) {

        int hash = 0;
        for (int i = 0; i < patternLength; i++) {
            hash += text[i] * Math.pow(prime, i);
        }
        return hash;
    }

    private int calculateHash(char[] text, int startIndex, int oldHash, int patternLength) {
        int newHash = oldHash - text[startIndex - 1];
        newHash = newHash / prime;
        newHash += text[startIndex + (patternLength - 1)] * Math.pow(prime, patternLength - 1);
        return newHash;
    }

    private boolean checkMatch(char[] text, char[] pattern, int startIndex) {

        for (int i = startIndex, j = 0; i <= startIndex + (pattern.length - 1); i++, j++)
            if (text[i] != pattern[j])
                return false;
        return true;
    }


    public static void main(String[] args) {
        String text = "aabbbbabbbababbaaa";
        String pattern = "aaa";
        RabinKarp rabinKarp = new RabinKarp();
        System.out.print(rabinKarp.findSubstring(text.toCharArray(), pattern.toCharArray()));

    }
}
