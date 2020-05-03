package opennlp.tools.lemmatizer.lang.lt;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;

public class Lemmatizer extends LemmatizerME {
    private static final Logger LOGGER = Logger.getLogger(Lemmatizer.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-lemmatizer.bin";

    public Lemmatizer() {
        super(loadDefaultModel());
    }

    public Lemmatizer(LemmatizerModel model) {
        super(model);
    }

    private static LemmatizerModel loadDefaultModel() {
        LemmatizerModel model = null;
        try (InputStream modelIn = Lemmatizer.class.getResourceAsStream(DEFAULT_MODEL_PATH)) {
            model = new LemmatizerModel(modelIn);
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load default lemmatizer model: " + DEFAULT_MODEL_PATH, e);
        }
        return model;
    }

}
