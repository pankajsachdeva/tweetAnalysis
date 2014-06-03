import java.io.File;
import java.io.IOException;

import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.classify.LMClassifier;
import com.aliasi.corpus.ObjectHandler;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.Compilable;
import com.aliasi.util.Files;

/**
*
*/
public class Trainer 
{

	public static void main(String[] args) 
	{

		try {
			Trainer.trainModel();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}


}

public static void trainModel()throws IOException, ClassNotFoundException 
{

	File trainDir;
	String[] categories;
	LMClassifier classifier;
	trainDir = new File("Location of training data");
	categories = trainDir.list();
	int nGram = 7; //the nGram level, any value between 7 and 12 works
	classifier = DynamicLMClassifier.createNGramProcess(categories,nGram);

	for (int i = 0; i < categories.length; ++i) {
		String category = categories[i];
		Classification classification = new Classification(category);
		File file = new File(trainDir, categories[i]);
		File[] trainFiles = file.listFiles();
		for (int j = 0; j < trainFiles.length; ++j) {
			File trainFile = trainFiles[j];
			String review = Files.readFromFile(trainFile, "ISO-8859-1");
			Classified classified = new Classified(review, classification);
			((ObjectHandler) classifier).handle(classified); 
		}
		System.out.println("Current Folder: " + (i+1));
	}
	AbstractExternalizable.compileTo((Compilable) classifier, new File("output file classifier/classifier.txt"));
	
}

}
