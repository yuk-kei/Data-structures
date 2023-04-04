package trie;

public class Trie {
    private TrieNode root; //Root Node

    //Constructor
    Trie(){
        root = new TrieNode();
    }
    //Function to get the index of a character 'c'
    public int getIndex(char c){
        return c - 'a';
    }

    //Function to insert a key,value pair in the Trie
    public void insert(String key){
        if(key.isEmpty()){
            System.out.println("Insert failed. Error: empty string");
        }

        key = key.toLowerCase();
        TrieNode curr = this.root;

        for(int i = 0; i < key.length(); i++){
            int index = getIndex(key.charAt(i));
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.markAsLeaf();
    }

    //Function to search given key in Trie
    public boolean search(String key){
        if(key.isEmpty()){
            return false;
        }
        key = key.toLowerCase();
        TrieNode curr = this.root;

        for(int i = 0; i < key.length(); i++){
            int index = getIndex(key.charAt(i));
            if(curr.children[index] == null){
                return  false;
            }
            curr = curr.children[index];
        }

        return curr.isEndWord;
    }

    //Function to delete given key from Trie
    public boolean delete(String key){

    }
}
