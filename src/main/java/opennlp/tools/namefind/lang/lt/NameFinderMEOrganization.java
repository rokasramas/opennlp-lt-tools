package opennlp.tools.namefind.lang.lt;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.namefind.TokenNameFinderModel;

public class NameFinderMEOrganization extends opennlp.tools.namefind.NameFinderME {
    private static final Logger LOGGER = Logger.getLogger(NameFinderMEOrganization.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-ner-organization.bin";

    public NameFinderMEOrganization() {
        super(loadDefaultModel());
    }

    public NameFinderMEOrganization(TokenNameFinderModel model) {
        super(model);
    }

    private static TokenNameFinderModel loadDefaultModel() {
        TokenNameFinderModel model = null;
        try (InputStream modelIn = NameFinderMEOrganization.class.getResourceAsStream(DEFAULT_MODEL_PATH)) {
            model = new TokenNameFinderModel(modelIn);
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load organization NER model: " + DEFAULT_MODEL_PATH, e);
        }
        return model;
    }

}
