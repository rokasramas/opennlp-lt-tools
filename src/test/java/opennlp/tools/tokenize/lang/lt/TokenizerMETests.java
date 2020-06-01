package opennlp.tools.tokenize.lang.lt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TokenizerMETests {
    private final TokenizerME TOKENIZER = new TokenizerME();

    @Test
    void tokenizeSimpleSentences() {
        assertArrayEquals(
                new String[]{"Antradienį", "apmąstykite", "savo", "tikslus", "."},
                TOKENIZER.tokenize("Antradienį apmąstykite savo tikslus.")
        );
        assertArrayEquals(
                new String[]{"Prisijungia", "ir", "rašo", ":", "„", "Miau", ",", "miau", "...", "“"},
                TOKENIZER.tokenize("Prisijungia ir rašo: „Miau, miau...“")
        );
        assertArrayEquals(
                new String[]{
                        "Tai", "girdėdavosi", "visoje", "ekspedicijos", "stovykloje",
                        "(", "teisingiau", "–", "„", "lageryje", "“", ")", "."},
                TOKENIZER.tokenize(
                        "Tai girdėdavosi visoje ekspedicijos stovykloje (teisingiau – „lageryje“).")
        );
        assertArrayEquals(
                new String[]{
                        "Aukštaūgis", "tikrai", "nežais", "trečiadienį", "Eurolygos", "B", "grupės",
                        "mače", "su", "Kauno", "„", "Žalgiriu", "“", "."},
                TOKENIZER.tokenize(
                        "Aukštaūgis tikrai nežais trečiadienį Eurolygos B grupės mače su Kauno „Žalgiriu“.")
        );
        assertArrayEquals(
                new String[]{
                        "Tačiau", ",", "matyt", ",", "taip", "susiklostė", "aplinkybės", ",", "kad", "tuo", "laiku",
                        "neatsirado", "pedagogų", ",", "kurie", "sugebėtų", "įžiebti", "aistrą", "šiam", "pomėgiui",
                        ",", "veikiau", ",", "atvirkščiai", ",", "atbaidė", "."},
                TOKENIZER.tokenize(
                        "Tačiau, matyt, taip susiklostė aplinkybės, kad tuo laiku neatsirado pedagogų, " +
                                "kurie sugebėtų įžiebti aistrą šiam pomėgiui, veikiau, atvirkščiai, atbaidė.")
        );

    }

}