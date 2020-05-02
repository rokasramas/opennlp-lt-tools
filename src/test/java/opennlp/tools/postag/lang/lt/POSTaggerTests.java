package opennlp.tools.postag.lang.lt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class POSTaggerTests {
    private final POSTagger POS_TAGGER = new POSTagger();

    @Test
    void getPOSTags() {
        assertArrayEquals(
                new String[]{
                        "PUNCT", "ADV", "VERB", "PART", "PRON", "CCONJ", "NOUN",
                        "ADP", "PROPN", "ADJ", "INTJ", "SCONJ", "NUM", "X", "SYM"
                },
                POS_TAGGER.getAllPosTags()
        );
    }

    @Test
    void getPOSTagsFromTokens() {
        assertArrayEquals(
                new String[]{
                        "ADV", "VERB", "PART", "NOUN", "PUNCT", "CCONJ", "ADV", "ADJ", "NOUN", "NOUN", "PUNCT"
                },
                POS_TAGGER.tag(new String[]{
                        "Kitaip", "būsi", "ne", "dama", ",", "o", "tik", "paprasto", "partsekretoriaus", "žmona", "."
                })
        );
    }

}
