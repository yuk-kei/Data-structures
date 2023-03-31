package trie;

public class Trie {
    private TrieNode root; //Root Node

    //Constructor
    Trie(){
        root = new TrieNode();
    }
    //Function to get the index of a character 't'
    public int getIndex(char t){
        return t - 'a';
    }

    //Function to insert a key,value pair in the Trie
    public void insert(String key,int value){}

    //Function to search given key in Trie
    public boolean search(String key){ return false;}

    //Function to delete given key from Trie
    public boolean delete(String key){ return false;}
}
