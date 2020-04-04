package opennlp.tools.tokenize.lang.lt;

import java.io.InputStream;
import java.io.IOException;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Tokenizer extends TokenizerME {
    private static String modelResourcePath = "/models/lt-token.bin";

    public Tokenizer() throws IOException {
        super(getModel());
    }

    private static TokenizerModel getModel() throws IOException {
        InputStream is = Tokenizer.class.getResourceAsStream(modelResourcePath);
        TokenizerModel model = new TokenizerModel(is);
        is.close();
        return model;
    }

}
