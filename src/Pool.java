import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.lang.Math;


import javax.naming.spi.DirectoryManager;

import java.awt.image.ReplicateScaleFilter;
import java.io.File;
import java.io.IOException;

public class Pool {
	public Map<String,DocumentClass> document_classes;
	public long number_of_doc ;
	
	public Pool(){
        document_classes = new HashMap(); //docment la 1 dictionary
        number_of_doc = 0;
	}

    public void learn(String directory,String classname){
        DocumentClass x = new DocumentClass();
        //dir = os.listdir(directory);
        File dir = new File(directory);

        for (String file : dir.list()){
            Document d = new Document();
            //ham print
            System.out.println(directory + "/" + file);
            d.read_document(directory + "/" +  file);
        }
        
        //operator?? trong 2 Doc Class voi nhau
        x = x + d;
        long numberfile = dir.length();
        x.setNumberOfDocs(numberfile);
        document_classes.put(classname, x);
        //print(x)
        number_of_doc += numberfile;
    }

    
    public Map<String, Float> probability(String document){
    	
        Map<String,Float> prob_list = new HashMap();
        
        for (String dclass : document_classes.keySet()){
            float prob = probability(document, dclass);
            prob_list.put(dclass,prob);
            }
        //sort cao ->thap
        prob_list.sort(key = lambda x: x[1], reverse = True); 
        
        return prob_list;
    }

    public float probability(String document,String dclass){
        //if dclass:
        Document d = new Document();
        try {
			d.read_document(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        DocumentClass doc_class = document_classes.get(dclass);

        long Nc = doc_class.numberOfDocs();

        float LogPc =  (float) Math.log(Nc / number_of_doc);

        float sumLogPTkC = 0;
        for (String word : d.bag_of_words.keySet()){
        	float TctK = 0;
            if (doc_class.bag_of_words.containsKey(word)){
            	TctK = doc_class.bag_of_words.get(word);
            }
            
            float P_TkC= (TctK+1)/(float)(doc_class.number_of_words + doc_class.len());

            sumLogPTkC += Math.log(P_TkC);
        }
        LogPc += sumLogPTkC;
        return LogPc;
        //else:
            //prob_list = []
            //for dclass in self.__document_classes:
                //prob = self.probability(document, dclass)
                //prob_list.append([dclass,prob])
            //prob_list.sort(key = lambda x: x[1], reverse = True)
            //return prob_list
        
    }
	
    
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String[] DClasses = {"clinton",  "lawyer",  "math",  "medical",  "music",  "sex"};

		String base = "/NLP/learn/";
		Pool p = new Pool();
		for (String classname : DClasses){
		    p.learn(base + classname, classname);
		}



		base = "/NLP/test/";
		for (String classname : DClasses ){
		    //dir = os.listdir(base + classname)
			File dir = new File(base+classname);
			for (String file : dir.list() ){
		        Map res = p.probability(base + classname + "/" + file);
		        
		        //can 1 ham chuyen res thanh string, toi viet ma gia str(res)
		        System.out.println(classname + ": " + file + ": " + str(res));
			}
		}

	}
	
	

}
