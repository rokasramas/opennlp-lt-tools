package opennlp.tools.tokenize.lang.lt;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.tokenize.TokenizerModel;

public class TokenizerME extends opennlp.tools.tokenize.TokenizerME {
    private static final Logger LOGGER = Logger.getLogger(TokenizerME.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-token.bin";

    public TokenizerME() {
        super(loadDefaultModel());
    }

    public TokenizerME(TokenizerModel model) {
        super(model);
    }

    private static TokenizerModel loadDefaultModel() {
        TokenizerModel model = null;
        try (InputStream modelIn = TokenizerME.class.getResourceAsStream(DEFAULT_MODEL_PATH)) {
            model = new TokenizerModel(modelIn);
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load default tokenizer model: " + DEFAULT_MODEL_PATH, e);
        }
        return model;
    }

}
