package trie;

import java.util.Arrays;

public class NumWords {
    public static int totalWords(TrieNode root){
        int res = 0;

        if(root.isEndWord){
            res ++;
        }

        for(TrieNode curr : root.children){
            if(curr != null){
                res += totalWords(curr);
            }
        }
        return res;
    }

    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie
        Trie t = new Trie();

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        System.out.println(totalWords(t.getRoot()));
    }
}
