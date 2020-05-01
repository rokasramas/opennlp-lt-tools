package opennlp.tools.tokenize.lang.lt;

import java.io.InputStream;
import java.io.IOException;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Tokenizer extends TokenizerME {
    private static final String defaultModelPath = "/models/lt-token.bin";

    public Tokenizer() throws IOException {
        super(getDefaultModel());
    }

    public Tokenizer(TokenizerModel model) {
        super(model);
    }

    private static TokenizerModel getDefaultModel() throws IOException {
        InputStream is = Tokenizer.class.getResourceAsStream(Tokenizer.defaultModelPath);
        TokenizerModel model = new TokenizerModel(is);
        is.close();
        return model;
    }

}
