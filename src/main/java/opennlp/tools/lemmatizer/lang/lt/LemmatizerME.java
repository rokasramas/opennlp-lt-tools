package opennlp.tools.lemmatizer.lang.lt;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.lemmatizer.LemmatizerModel;

public class LemmatizerME extends opennlp.tools.lemmatizer.LemmatizerME {
    private static final Logger LOGGER = Logger.getLogger(LemmatizerME.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-lemmatizer.bin";

    public LemmatizerME() {
        super(loadDefaultModel());
    }

    public LemmatizerME(LemmatizerModel model) {
        super(model);
    }

    private static LemmatizerModel loadDefaultModel() {
        LemmatizerModel model = null;
        try (InputStream modelIn = LemmatizerME.class.getResourceAsStream(DEFAULT_MODEL_PATH)) {
            model = new LemmatizerModel(modelIn);
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load default lemmatizer model: " + DEFAULT_MODEL_PATH, e);
        }
        return model;
    }

}
