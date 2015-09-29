import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Document {
	public int number_of_words;
	//public bag_of_words<String,Integer> bag_of_words = new bag_of_words<String,Integer>();
	public Map<String, Integer> bag_of_words;
	public Document(){
		bag_of_words = new HashMap<String, Integer>();
		number_of_words = 0;
	}
	
	
	
	
	public void read_document(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		String inputLine = null;
	    
	    //Map bag_of_words = new Hashtable();
	    while((inputLine = reader.readLine()) != null) {
	    	String[] words = inputLine.split("\\s+");
	    	// Ignore empty lines.
	    	if(inputLine.equals(""))
	    		continue;
	    	for(String word: words) {
	    		// Remove any commas and dots.
	    		word = word.replace(".", "");
	    		word = word.replace(",", "");
	    		//if(bag_of_words.containsKey(word)) {
	    			//Integer val = (Integer) bag_of_words.get(word);
	    			//bag_of_words.put(word, val + 1);
	    		//}
	    		//else
	    			//bag_of_words.put(word, 1);
	    		add_word(word);
	    	}
	    }
	    reader.close();
	    // Printing all words stored in the map.
	    //for(String key: bag_of_words.keySet()){
	    	//System.out.println(key + ": " + bag_of_words.get(key));
	    	//reader.close();
	    //}
	}

    //public void read_document(self, filename):

        //try:
            //text = open(filename, "r", encoding='utf-8').read()
        //except UnicodeDecodeError:
            //text = open(filename, "r", encoding='latin-1').read()
        //text = text.lower()
        //words = re.split("[^\wäöüÄÖÜß]*", text)  # what re module?


        //for word in words:
            //if word != '':
                //# self._words_and_freq.add_word(word)
                //self.add_word(word)

    public void add_word(String word) {
        //""" A word is added in the bag_of_words __bag_of_words"""
        //self._number_of_words += 1
        //if word in self._bag_of_words:
            //self._bag_of_words[word] += 1
        //else:
            //self._bag_of_words[word] = 1
    	number_of_words += 1;
    	if(bag_of_words.containsKey(word)) {
			Integer val = (Integer) bag_of_words.get(word);
			bag_of_words.put(word, val + 1);
		}
		else{
			bag_of_words.put(word, 1);
		}
    }
   

    public int len(){
        //""" Returning len of bag of word. It mean number of defirent words"""

        return bag_of_words.size();
    }
    
    public static void main(String[] args){
		Document doc = new Document();
		// Printing all words stored in the map.
	    for(String key: doc.bag_of_words.keySet()){
	    	System.out.println(key + ": " + doc.bag_of_words.get(key));
	    	//reader.close();
	    }
	}
    
    //def __str__(self):

        //return "Number: " + str(self._number_of_words) + "\nBag:" + str(self._bag_of_words)
}
