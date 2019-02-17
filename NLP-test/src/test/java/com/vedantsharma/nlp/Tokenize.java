package com.vedantsharma.nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.apache.xpath.SourceTree;

import java.util.List;

/**
 * Created by vedant sharma on 29-01-2019.
 */
public class Tokenize {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline(); //get a singleton pipeline object

        String text = "hi! I'm Vedant Sharma. Nice to meet you"; // place to hold the string

        CoreDocument coreDocument = new CoreDocument(text); // takes string as an argument in order to create a document

        stanfordCoreNLP.annotate(coreDocument); //does not return anything and annotates the core document

        List<CoreLabel> coreLabelList = coreDocument.tokens(); //tokens method return list of core labels. stored in a reference variables list of core variables

        //iterate the above list to tokenize it

        for (CoreLabel coreLabel : coreLabelList) {
            System.out.println(coreLabel.originalText());
        }
    }
}
