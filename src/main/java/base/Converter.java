package base;

import static constant.Constant.STOP_SYMBOL;
import static constant.ErrorMessage.NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE;

import java.util.LinkedHashMap;
import validation.UserInputValidator;

public class Converter {
    private final UserInputValidator userInputValidator;

    public Converter(UserInputValidator userInputValidator) {
        this.userInputValidator = userInputValidator;
    }

    public int wordToInt(String word) {
        try {
            int parsed = Integer.parseInt(word);
            userInputValidator.validatePositiveNumber(parsed);
            return parsed;
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE);
        }
    }

    public LinkedHashMap<String, String> splitAndAddToMap(String Name) {
        String[] parts = tokenizeByComma(Name);
        userInputValidator.validateInputCarNameCount(parts);
        return convertArrayToMap(parts);
    }

    private String[] tokenizeByComma(String entireString) {
        return entireString.split(",");
    }

    private LinkedHashMap<String, String> convertArrayToMap(String[] parts) {
        LinkedHashMap<String, String> carNameHashMap = new LinkedHashMap<>();
        for (String part : parts) {
            userInputValidator.validateInputCarName(part);
            carNameHashMap.put(part, STOP_SYMBOL);
        }
        return carNameHashMap;
    }
}