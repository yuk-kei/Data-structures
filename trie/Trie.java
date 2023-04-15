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

    public TrieNode getRoot() {
        return root;
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
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Error: Null key or Empty trie");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }

    private boolean deleteHelper(String key, TrieNode curr, int length, int level){
        boolean deletedSelf = false;
        if(curr == null){
            System.out.println("Error: Key does not exist");
            return deletedSelf;
        }
        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if(level == length){
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if(!hasChildren(curr)){
                curr = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                curr.unMarkAsLeaf();
                deletedSelf = false;
            }

        } else{
            TrieNode childNode = curr.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                //Making children pointer also null: since child is deleted
                curr.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currentNode is part of another key
                //and hence we can not delete this node, and it's parent path nodes
                if (curr.isEndWord){
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children, then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (hasChildren(curr)){
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else{
                    curr = null;
                    deletedSelf = true;
                }
            }
            else
            {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    private boolean hasChildren(TrieNode curr){
        for(int i = 0; i < curr.children.length; i++){
            if(curr.children[i] != null) {
                return true;
            }
        }
        return  false;
    }


}
