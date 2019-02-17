package com.vedantsharma.nlp;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Properties;

/**
 * Created by vedant sharma on 29-01-2019.
 */
public class Pipeline {
    private static Properties properties;

    private static String propertiesName = "tokenize, ssplit";  // calling this pipeline based in the feature or annotations

    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline() {

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    public static StanfordCoreNLP getPipeline() {
        if (stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }

        return stanfordCoreNLP;
    }
}
