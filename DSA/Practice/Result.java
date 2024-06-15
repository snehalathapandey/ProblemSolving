package DSA.Practice;

import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.joining;

class TreeNode {
    TreeNode[] children;
    boolean isEndOfWord;

    TreeNode() {
        children = new TreeNode[26]; // Assuming only lowercase English alphabets
        isEndOfWord = false;
    }
}
public class Result{
    static TreeNode root;

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */
    static boolean insert(String word) {
        TreeNode current = root;
        boolean prefixFound = false;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TreeNode();
            } else if (current.children[index].isEndOfWord) {
                // Prefix found
                prefixFound = true;
                break;
            }
            current = current.children[index];
        }

        // If word is a prefix of another word
        if (!prefixFound) {
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    // Prefix found
                    prefixFound = true;
                    break;
                }
            }
        }

        if (prefixFound) {
            return false; // Bad set
        } else {
            current.isEndOfWord = true;
            return true; // Good set
        }
    }

    @Test
    public void noPrefix() {
        List<String> words=Arrays.asList("ab","bc","cd");

        root = new TreeNode();
        boolean goodSet = true;

        for (String word : words) {
            if (!insert(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                goodSet = false;
                break;
            }
        }

        if (goodSet) {
            System.out.println("GOOD SET");
        }

    }




}
