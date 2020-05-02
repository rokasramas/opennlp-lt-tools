package opennlp.tools.postag.lang.lt;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.postag.POSModel;

public class POSTagger extends POSTaggerME {
    private static final Logger LOGGER = Logger.getLogger(POSTagger.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-pos.bin";

    public POSTagger() {
        super(loadDefaultModel());
    }

    public POSTagger(POSModel model) {
        super(model);
    }

    private static POSModel loadDefaultModel() {
        POSModel model = null;
        try (InputStream modelIn = POSTagger.class.getResourceAsStream(DEFAULT_MODEL_PATH)) {
            model = new POSModel(modelIn);
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load default POS tagger model: " + DEFAULT_MODEL_PATH, e);
        }
        return model;
    }

}
