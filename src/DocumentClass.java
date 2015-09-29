
public class DocumentClass extends Document {
	
	
	private long number_of_docs;
	
	
	
	public DocumentClass(){
        super();
        number_of_docs = 0;
	}
	
	//De nghi viet 1 operator o day
    //def __add__(self, other):
        //doc_class = DocumentClass()

        //doc_class._bag_of_words = {k: self._bag_of_words.get(k, 0) + other._bag_of_words.get(k, 0)
                                    //for k in self._bag_of_words.keys() | other._bag_of_words.keys()}
        //doc_class.__number_of_words = self._number_of_words + self._number_of_words
        //# doc_class.__number_of_docs = self.__number_of_docs + self.__number_of_docs

        //return doc_class

    public long numberOfDocs(){
        return number_of_docs;
    }
    public void setNumberOfDocs(long number){
        number_of_docs = number;

    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
