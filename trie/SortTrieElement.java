package trie;

import java.util.ArrayList;
import java.util.Arrays;

public class SortTrieElement {


    public static ArrayList<String> sortArray(String[] arr) {
        ArrayList<String> result = new ArrayList<String>();

        Trie trie = new Trie();
        for(int  x = 0; x < arr.length; x ++){
            trie.insert(arr[x]);
        }

        char[] word = new char[20];
        getWords(trie.getRoot(),result,0,word);
        return result;
    }

    private static void getWords(TrieNode root, ArrayList<String> res, int level, char[] str){
        StringBuffer tmp = new StringBuffer();

        if (root.isEndWord) {
            for(int i = 0; i < level; i ++){
                tmp.append(str[i]);
                res.add(tmp.toString());
            }

            res.add(tmp.toString());
        }


        for(int i = 0; i< 26; i++){
            if(root.children[i] != null){
                str[level] = (char)(i + 'a');
                getWords(root.children[i], res, level + 1, str);
            }
        }
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = sortArray(keys);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
