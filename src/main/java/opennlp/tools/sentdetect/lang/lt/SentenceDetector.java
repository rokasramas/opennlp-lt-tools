package opennlp.tools.sentdetect.lang.lt;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class SentenceDetector extends SentenceDetectorME {
    private static final Logger LOGGER = Logger.getLogger(SentenceDetector.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-sent.bin";

    public SentenceDetector() {
        super(loadDefaultModel());
    }

    public SentenceDetector(SentenceModel model) {
        super(model);
    }

    private static SentenceModel loadDefaultModel() {
        SentenceModel model = null;
        try (InputStream modelIn = SentenceDetector.class.getResourceAsStream(DEFAULT_MODEL_PATH)) {
            model = new SentenceModel(modelIn);
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load default sentence detector model: " + DEFAULT_MODEL_PATH, e);
        }
        return model;
    }

}
