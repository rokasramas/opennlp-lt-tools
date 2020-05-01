package opennlp.tools.tokenize.lang.lt;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Tokenizer extends TokenizerME {
    private static final Logger LOGGER = Logger.getLogger(Tokenizer.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-token.bin";

    public Tokenizer() {
        super(loadDefaultModel());
    }

    public Tokenizer(TokenizerModel model) {
        super(model);
    }

    private static TokenizerModel loadDefaultModel() {
        TokenizerModel model = null;
        try (InputStream modelIn = Tokenizer.class.getResourceAsStream(DEFAULT_MODEL_PATH)) {
            model = new TokenizerModel(modelIn);
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load default tokenizer model: " + DEFAULT_MODEL_PATH, e);
        }
        return model;
    }

}
