package trie;

import java.util.ArrayList;
import java.util.Arrays;

public class TrieWords {
    //Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList< String > result, int level, char[] str) {
        // use this as helper function
        if(root.isEndWord){
            StringBuffer tmp = new StringBuffer();
            for(int i = 0; i < level; i++ ){
                tmp.append(str[i]);
            }
            result.add(tmp.toString());
        }
        for(int i = 0; i < 26; i++){
            if(root.children[i] != null){
                str[level] = (char) (i + 'a');
                getWords(root.children[i], result, level + 1, str);
            }
        }

    }
    public static ArrayList < String > findWords(TrieNode root) {
        ArrayList < String > result = new ArrayList < String > ();
        // write your code here
        getWords(root, result, 0, new char[20]);
        return result;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = findWords(t.getRoot());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
