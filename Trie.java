
public class Trie{
	
	TrieNode root;
	private int size = 0;
	
	Trie(){
		this.root = new TrieNode(false);
	}
	
	   /**
     * Method add
     * Creates new nodes consisting of characters that make up the given word.
     * @param word - The word to be stored in the trie as nodes of characters.
     */
	public boolean add(String word){
		if(word == null){
			return false;
		}
		if(contains(word)){
			return false;
		}
		//If the root was made null before with the clear method, will create a new TrieNode to be the root that
		//isn't null;
		if(root == null){
			root = new TrieNode(false);
			
		}
		word = word.toLowerCase();
		TrieNode currentNode = root;
		int charIndex = 0;
		while(charIndex < word.length()){
			//Checks to see that the arrayIndex is between 0 and 26. Gets the index of the
			//character of the word and stores it as the appropriate child of the root.
			int arrayIndex = word.charAt(charIndex) - 'a';
			if(arrayIndex < 0 || arrayIndex >= 26){
				return false;
			}
			//If the contents of the currentNode are null, create a new TrieNode with the
			//designation false to show that the node isn't the end of a word.
			if(currentNode.array[arrayIndex] == null){
				currentNode.array[arrayIndex] = new TrieNode(false);
				
			}
			//Sets the newly created Node as the current Node and moves on to the next
			//letter of the word.
			currentNode = currentNode.array[arrayIndex];
			charIndex++;
		}
			//Returns True since you've reached the end of the word successfully. Add 1 to size.
			currentNode.markAsWord();
			size++;
			return currentNode.isWord();
		}
	
	   /**
     * Method contains
     * Checks to see if the word is in the trie.
     * @param word - The word that will be looked for in the trie.
     */
	public boolean contains(String word){
		if(word == null){
			return false;
		}
		//If the root was made null before with the clear method, will know that the prefix is no longer in the trie.
		if(root == null){
			return false;
		}
		TrieNode currentNode = root;
		int charIndex = 0;
		
		while((currentNode != null) && (charIndex < word.length())){
			//Checks to see that the arrayIndex is between 0 and 26. Gets the index of the
			//character of the word and stores it as the appropriate child of the root.
			int arrayIndex = word.charAt(charIndex) - 'a';
			if(arrayIndex < 0 || arrayIndex >= 26){
				return false;
			}
			//Sets the child of the root as the current node and, as long as the child isn't
			//null, continues the while loop operation.
			currentNode = currentNode.array[arrayIndex];
			charIndex++;
		}
			//Once it reaches the last character of the word, checks to see that the last node
			//isn't null and that it has been marked as the last letter of a word. Returns
			//true if this is the case.
			if(currentNode != null && currentNode.isWord()){
				return true;
			}
			
			return false;
	}
	
	   /**
     * Method containsPrefix
     * Checks to see if the prefix is in the trie.
     * @param word - The prefix that will be looked for in the trie.
     */
	public boolean containsPrefix(String prefix){
		if(prefix == null){
			return false;
		}
		//If the root was made null before with the clear method, will know that the prefix is no longer in the trie.
		if(root == null){
			return false;
		}
		TrieNode currentNode = root;
		int charIndex = 0;
		
		while((currentNode != null) && (charIndex < prefix.length())){
			//Checks to see that the arrayIndex is between 0 and 26. Gets the index of the
			//character of the word and stores it as the appropriate child of the root.
			int arrayIndex = prefix.charAt(charIndex) - 'a';
			if(arrayIndex < 0 || arrayIndex >= 26){
				return false;
			}
			//Sets the child of the root as the current node and, as long as the child isn't
			//null, continues the while loop operation.
			currentNode = currentNode.array[arrayIndex];
			charIndex++;
		}
		//Once it reaches the last character of the word, checks to see that the last node
		//isn't null and DOESN'T check to see if it's the last letter of a word. Returns
		//true if this is the case.
			if(currentNode != null){
				return true;
			}			
			return false;
	}
	
	   /**
     * Method size
     * Returns the number of words in the trie
     * @return - returns the numberical amount of words in int size.
     */
	public int size(){
		return size;
		}
	
	/*   /**
     * Method clear
     * Deletes all nodes in the trie.
    
	public void clear(){
		TrieNode currentNode = root;		
		for(int i = 0; i < 26; i++){
			currentNode = currentNode.array[i];
			if(currentNode != null){
				currentNode = null;
				currentNode = root;
			}
			else{
				currentNode = root;
			}
			
			
		}
		size = 0;
	}
	*/
	   /**
  * Method clear
  * Sets the root to null. Because this cuts off the connection of the root to the rest of the
  * trie, the Java Garbage Collector will get rid off the unconnected data.
  */
	public void clear(){
	root = null;
	size = 0;
	System.out.println("The trie is cleared");
	}
	
	public static void main(String[]args){
		Trie trie = new Trie();
		System.out.println(trie.add("a"));
		System.out.println(trie.add("arm"));
		System.out.println(trie.add("art"));
		System.out.println(trie.add("123"));
		System.out.println(trie.add(" "));
		System.out.println(trie.containsPrefix("ar"));
		System.out.println(trie.containsPrefix("yo"));
		System.out.println(trie.contains("ar"));
		System.out.println(trie.contains("arm"));
		System.out.println(trie.size());
		trie.clear();
		System.out.println(trie.containsPrefix("ar"));
		System.out.println(trie.contains("ar"));;
		System.out.println(trie.add("arm"));
		System.out.println(trie.containsPrefix("ar"));
		System.out.println(trie.contains("arm"));
		System.out.println(trie.size());
	}
}




