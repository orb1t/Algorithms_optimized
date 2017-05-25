import java.util.*;

/**
 * Created by Jerry on 07-05-2017.
 */
 class FireWall {

    static class TrieNode {
        char letter;
        Map<Character, TrieNode> map = new TreeMap<>();
        //        TrieNode trieNodeList[] = new TrieNode[26];
        int blockedNode;
        int unBlockedNode;
        boolean isComplete;

        public TrieNode(char letter) {
            this.letter = letter;
        }

        public int insertWord(String str, TrieNode root, boolean isBlock) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                TrieNode trieNode = root.map.get(chars[i]);
                if (root.isComplete &&root.map.size() == 0 && root.blockedNode > 0 && !isBlock)
                    return -1;

                if (trieNode == null) {
                    TrieNode node = new TrieNode(chars[i]);
                    root.map.put(chars[i], node);
                    root = node;
                } else {
                    root = root.map.get(chars[i]);

                }
                if (isBlock)
                    root.blockedNode++;
                else
                    root.unBlockedNode++;
            }
            root.isComplete = true;

            if (root.map.size() != 0 && root.blockedNode > 0 && root.unBlockedNode > 0 )
                return -1;

            return 0;
        }

        public void getWords(TrieNode root, List<String> result) {

            Set<Map.Entry<Character, TrieNode>> entries = root.map.entrySet();
            boolean flag = true;
            for (Map.Entry<Character, TrieNode> entry : entries) {
                flag = flag && entry.getValue().blockedNode == 0;
            }

            if (flag) {
                System.out.println(0);
                return;
            }

            for (Map.Entry<Character, TrieNode> entry : entries) {
                printAllWords(entry.getValue(), "" + entry.getKey(), result);
            }

            System.out.println(result.size());

            for (String s : result) {
                System.out.println(s);
            }
        }
    }


    public static void printAllWords(TrieNode root, String str, List<String> result) {

        if (root.blockedNode == 0)
            return;

        if (root.blockedNode > 0 && root.unBlockedNode == 0) {
            result.add(str);
        } else if (root.blockedNode > 0 && root.unBlockedNode > 0) {
            Set<Map.Entry<Character, TrieNode>> entries = root.map.entrySet();
            for (Map.Entry<Character, TrieNode> entry : entries)
                printAllWords(entry.getValue(), str + (char) entry.getKey(), result);
        }


    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        TrieNode root = new TrieNode(' ');
        int i = 0;

        while (testCases-- > 0) {
            String strings = scanner.next();
            String site = scanner.next();
            if (strings.equals("+"))
                i += root.insertWord(site, root, false);
            else
                i += root.insertWord(site, root, true);
        }
        if (i != 0) {
            System.out.println(-1);
            return;
        }
        root.getWords(root, new ArrayList<String>());
    }
}
