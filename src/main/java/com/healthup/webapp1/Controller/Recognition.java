package com.healthup.webapp1.Controller;

import com.healthup.webapp1.Model.Type;
import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1")
public class Recognition
{
    @Autowired  // during spring boot startup
    private StanfordCoreNLP stanfordCoreNLP; // to use the pipeline class to get the NER

    @PostMapping
    @RequestMapping(value = "/ner")
   public Set<String> ER(@RequestBody final String input, @RequestParam final Type type) // accepts the input and type (enum) // method that returns list
     {
         CoreDocument coreDocument = new CoreDocument(input); // the text stored here i.e the text to be analysed
         stanfordCoreNLP.annotate(coreDocument);
         List<CoreLabel> coreLabels = coreDocument.tokens(); //returns the list of core labels

         return new HashSet<>(collectList(coreLabels,type)); //set is used just to avoid redundancy
     }

     private List<String> collectList(List<CoreLabel> coreLabels, final Type type) // to extract a particular type
     {
         return coreLabels    //from java-8 API
                 .stream()
                 .filter(coreLabel -> type.getName().equalsIgnoreCase(coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class)))
                 .map(CoreLabel::originalText)
                 .collect(Collectors.toList());

     }

}


