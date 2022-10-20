package utils;

import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JSONConverter {

    private final JSONParser parser;

    public JSONConverter() {
        this.parser = new JSONParser();
    }

    public Object getObjectFromJSON(String filePath) {
        try {
            return parser.parse(new FileReader(filePath));
        } catch (Exception e) {
            return new Error(e);
        }
    }
}
