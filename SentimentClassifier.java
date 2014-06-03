import java.io.File;
import java.io.IOException;

//import com.aliasi.classify.Classification;
//import com.aliasi.classify.Classified;
import com.aliasi.classify.ConditionalClassification;
//import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.classify.LMClassifier;
//import com.aliasi.corpus.ObjectHandler;
import com.aliasi.util.AbstractExternalizable;
//import com.aliasi.util.Compilable;
//import com.aliasi.util.Files;


public class SentimentClassifier {

	String[] categories;
	LMClassifier lmc;

	public SentimentClassifier() {
	
	try {
		lmc= (LMClassifier) AbstractExternalizable.readObject(new File("path to the classifier/1/classifier.txt"));
		categories = lmc.categories();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
		e.printStackTrace();
	}

	}

	public String classify(String text) {
	ConditionalClassification classification = lmc.classify(text);
	return classification.bestCategory();
	}
	
}
