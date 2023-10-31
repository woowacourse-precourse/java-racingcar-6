package basis;

import static constant.Constant.STOP_SYMBOL;
import static constant.ErrorMessage.NOT_POSITIVE_NUMBER_INPUT_CASE_MESSAGE;

import java.util.LinkedHashMap;
import validation.UserInputValidator;

public class Converter {
    UserInputValidator userInputValidator = new UserInputValidator();

    public int wordToInt(String word) {
        try {
            int wordToIntResult = Integer.parseInt(word);
            userInputValidator.checkPositiveNumber(wordToIntResult);
            return wordToIntResult;
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