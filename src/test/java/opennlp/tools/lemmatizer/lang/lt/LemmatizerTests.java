package opennlp.tools.lemmatizer.lang.lt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LemmatizerTests {
    private final Lemmatizer LEMMATIZER = new Lemmatizer();

    @Test
    void getLemmas() {
        assertArrayEquals(
                new String[]{
                        "kitaip", "būti", "ne", "dama", ",", "o", "tik", "paprastas", "partsekretorius", "žmona", "."
                },
                LEMMATIZER.lemmatize(
                        new String[]{
                                "Kitaip", "būsi", "ne", "dama", ",", "o", "tik", "paprasto", "partsekretoriaus", "žmona", "."
                        },
                        new String[]{
                                "prv.nelygin.", "vksm.asm.būs.2.vns.tiesiog.", "dll.", "dkt.mot.vns.V.",
                                "skyr.", "jng.", "prv.nelygin.", "bdv.vyr.vns.K.nelygin.", "dkt.vyr.vns.K.",
                                "dkt.mot.vns.V.", "skyr."
                        }
                )
        );
    }
}
