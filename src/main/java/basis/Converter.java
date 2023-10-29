package basis;

import java.util.LinkedHashMap;
import java.util.Map;
import validation.UserInputValidator;

public class Converter {
    public int wordToInt(String word) {
        return Integer.parseInt(word);
    }

    public Map<String, String> splitAndAddToMap(String Name) { // ["k1",v1,v2]
        Map<String, String> hashMap = new LinkedHashMap<>();
        String[] parts = tokenizeByComma(Name);
        for (String part : parts) {
            hashMap.put(part, "");
            UserInputValidator.checkNameLength(part);
        }
        return hashMap;
    }

    private String[] tokenizeByComma(String entireString) {
        return entireString.split(",");
    }
}