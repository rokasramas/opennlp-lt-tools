package opennlp.tools.postag.lang.lt;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class POSTaggerTests {
    private final POSTagger POS_TAGGER = new POSTagger();

    @Test
    void equalPOSTable() {
        assertEquals(
                POSTagger.POS_TABLE.keySet(), new HashSet<>(Arrays.asList(POS_TAGGER.getAllPosTags()))
        );
    }

    @Test
    void getPOSTagsFromTokens() {
        assertArrayEquals(
                new String[]{
                        "prv.nelygin.", "įv.vns.N.", "dll.", "dkt.tikr.vyr.vns.V.", "skyr."
                },
                POS_TAGGER.tag(new String[]{
                        "Čia", "tau", "ne", "Paryžius", "."
                })
        );
    }

    @Test
    void getUniversalPOSTagsFromTokens() {
        assertArrayEquals(
                new String[]{
                        "ADV", "PRON", "PART", "PROPN", "PUNCT"
                },
                POSTagger.toUniversalTags(POS_TAGGER.tag(new String[]{
                        "Čia", "tau", "ne", "Paryžius", "."
                }))
        );
    }

}
