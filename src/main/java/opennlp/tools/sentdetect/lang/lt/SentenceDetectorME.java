package opennlp.tools.sentdetect.lang.lt;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.sentdetect.SentenceModel;

public class SentenceDetectorME extends opennlp.tools.sentdetect.SentenceDetectorME {
    private static final Logger LOGGER = Logger.getLogger(SentenceDetectorME.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-sent.bin";

    public SentenceDetectorME() {
        super(loadDefaultModel());
    }

    public SentenceDetectorME(SentenceModel model) {
        super(model);
    }

    private static SentenceModel loadDefaultModel() {
        SentenceModel model = null;
        try (InputStream modelIn = SentenceDetectorME.class.getResourceAsStream(DEFAULT_MODEL_PATH)) {
            model = new SentenceModel(modelIn);
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load default sentence detector model: " + DEFAULT_MODEL_PATH, e);
        }
        return model;
    }

}
