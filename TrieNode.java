
public class TrieNode {
	boolean word;
	TrieNode[] array;
	
	TrieNode(boolean isWord){
		this.word = isWord;
		//An array that will hold all children of any "root" node.
		//26 because there are 26 letters in the alphabet.
		array = new TrieNode[26];
	}
	
	public void markAsWord(){
		this.word = true;
	}
	
	public boolean isWord(){
		return word;		
	}
}
