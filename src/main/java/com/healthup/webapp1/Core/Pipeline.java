package com.healthup.webapp1.Core;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service  // in order to inject the stanfordcoreNLP in recognition class method
public class Pipeline // singleton class where instance of stanford core NLP is used
{
    private static Properties properties;
    private static String Properties_Name = "tokenize, ssplit, pos, lemma, ner";
    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline()
    {

    }

    static  // used to create the instance of the properties
    {
        properties = new Properties();
        properties.setProperty("annotators", Properties_Name);
    }

    @Bean(name = "stanfordCoreNLP")  //help in creating instance
    public static StanfordCoreNLP getInstance()   // method to create instances on singleton basis.
    {
        if(stanfordCoreNLP == null)
        {
            stanfordCoreNLP = new StanfordCoreNLP(Properties_Name);
        }
        return stanfordCoreNLP;
    }
}
