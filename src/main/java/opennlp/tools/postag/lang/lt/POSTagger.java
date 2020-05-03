package opennlp.tools.postag.lang.lt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.postag.POSModel;

public class POSTagger extends POSTaggerME {
    private static final Logger LOGGER = Logger.getLogger(POSTagger.class.getName());
    private static final String DEFAULT_MODEL_PATH = "/models/lt-pos.bin";
    private static final String TABLE_PATH = "/lt-pos-table.txt";
    static final HashMap<String, String> POS_TABLE = loadUniversalPOSTable();

    public POSTagger() {
        super(loadDefaultModel());
    }

    public POSTagger(POSModel model) {
        super(model);
    }

    public static String[] toUniversalTags(String[] tags) {
        String[] universalTags = new String[tags.length];
        for (int i = 0; i < tags.length; i++) {
            universalTags[i] = POS_TABLE.get(tags[i]);
        }
        return universalTags;
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

    private static HashMap<String, String> loadUniversalPOSTable() {
        HashMap<String, String> table = new HashMap<>();
        try (InputStream is = POSTagger.class.getResourceAsStream(TABLE_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while (reader.ready()) {
                String[] vals = reader.readLine().split("\t");
                table.put(vals[0], vals[1]);
            }
        } catch (NullPointerException | IOException e) {
            LOGGER.log(Level.WARNING, "Failed to load universal POS table: " + TABLE_PATH, e);
        }
        return table;
    }

}
