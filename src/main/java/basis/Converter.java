package basis;

import static constant.ErrorMessage.NOT_NUMBER_INPUT_CASE_MESSAGE;

import java.util.LinkedHashMap;
import validation.UserInputValidator;

public class Converter {
    UserInputValidator userInputValidator;

    public int wordToInt(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_CASE_MESSAGE);
        }
    }

    public LinkedHashMap<String, String> splitAndAddToMap(String Name) {
        String[] parts = tokenizeByComma(Name);
        return convertArrayToMap(parts);
    }

    private String[] tokenizeByComma(String entireString) {
        return entireString.split(",");
    }

    private LinkedHashMap<String, String> convertArrayToMap(String[] parts) {
        LinkedHashMap<String, String> carNameHashMap = new LinkedHashMap<>();
        for (String part : parts) {
            UserInputValidator.validateInput(part);
            carNameHashMap.put(part, "");
        }
        return carNameHashMap;
    }
}