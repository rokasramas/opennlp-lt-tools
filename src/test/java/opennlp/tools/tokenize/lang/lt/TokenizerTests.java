package opennlp.tools.tokenize.lang.lt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class TokenizerTests {
    private Tokenizer tokenizer = new Tokenizer();

    TokenizerTests() throws IOException {
    }

    @Test
    void tokenizeSimpleSentences() {
        assertArrayEquals(
                new String[]{"Antradienį", "apmąstykite", "savo", "tikslus", "."},
                tokenizer.tokenize("Antradienį apmąstykite savo tikslus.")
        );
        assertArrayEquals(
                new String[]{"Prisijungia", "ir", "rašo", ":", "„", "Miau", ",", "miau", "...", "“"},
                tokenizer.tokenize("Prisijungia ir rašo: „Miau, miau...“")
        );
        assertArrayEquals(
                new String[]{
                        "Tai", "girdėdavosi", "visoje", "ekspedicijos", "stovykloje",
                        "(", "teisingiau", "–", "„", "lageryje", "“", ")", "."},
                tokenizer.tokenize(
                        "Tai girdėdavosi visoje ekspedicijos stovykloje (teisingiau – „lageryje“).")
        );
        assertArrayEquals(
                new String[]{
                        "Aukštaūgis", "tikrai", "nežais", "trečiadienį", "Eurolygos", "B", "grupės",
                        "mače", "su", "Kauno", "„", "Žalgiriu", "“", "."},
                tokenizer.tokenize(
                        "Aukštaūgis tikrai nežais trečiadienį Eurolygos B grupės mače su Kauno „Žalgiriu“.")
        );
        assertArrayEquals(
                new String[]{
                        "Tačiau", ",", "matyt", ",", "taip", "susiklostė", "aplinkybės", ",", "kad", "tuo", "laiku",
                        "neatsirado", "pedagogų", ",", "kurie", "sugebėtų", "įžiebti", "aistrą", "šiam", "pomėgiui",
                        ",", "veikiau", ",", "atvirkščiai", ",", "atbaidė", "."},
                tokenizer.tokenize(
                        "Tačiau, matyt, taip susiklostė aplinkybės, kad tuo laiku neatsirado pedagogų, " +
                                "kurie sugebėtų įžiebti aistrą šiam pomėgiui, veikiau, atvirkščiai, atbaidė.")
        );

    }

}