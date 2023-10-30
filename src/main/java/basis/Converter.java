package basis;

import static constant.ErrorMessage.EMPTY_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.INVALID_INPUT_CASE_MESSAGE;
import static constant.ErrorMessage.NOT_NUMBER_INPUT_CASE_MESSAGE;

import java.util.LinkedHashMap;
import validation.UserInputValidator;

public class Converter {
    public int wordToInt(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_CASE_MESSAGE);
        }
    }

    public LinkedHashMap<String, String> splitAndAddToMap(String Name) { // ["k1",v1,v2]
        try {
            String[] parts = tokenizeByComma(Name);
            return getCarNameHashMap(parts);
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(INVALID_INPUT_CASE_MESSAGE);
        }
    }

    private String[] tokenizeByComma(String entireString) {
        return entireString.split(",");
    }

    private LinkedHashMap<String, String> getCarNameHashMap(String[] parts) {
        LinkedHashMap<String, String> carNameHashMap = new LinkedHashMap<>();
        for (String part : parts) {
            if (part.isBlank()) {
                throw new IllegalArgumentException(EMPTY_NAME_CASE_MESSAGE);
            }
            carNameHashMap.put(part, "");
            UserInputValidator.checkNameLength(part);
        }
        return carNameHashMap;
    }
}