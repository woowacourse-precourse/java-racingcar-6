package basis;

import java.util.LinkedHashMap;
import java.util.Map;
import validation.UserInputValidator;

public class Converter {
    public Map<String, String> putHashMap(String carName) {
        Map<String, String> hashMap = new LinkedHashMap<>();
        String[] parts = tokenizeByComma(carName);
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