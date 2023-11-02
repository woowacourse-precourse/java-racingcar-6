package racingcar.validator;

import static racingcar.global.GameSymbols.CAR_NAME_SEPARATOR;

public class CarNameValidationUtil {

    public static String cleanInput(String userInput) {
        userInput = removeWhiteSpace(userInput);
        return removeDuplicateSeparator(userInput);
    }

    private static String removeWhiteSpace(String userInput) {
        userInput = userInput.replace(" ", "");
        return userInput;
    }

    private static String removeDuplicateSeparator(String userInput) {
        String separator = CAR_NAME_SEPARATOR.getValue();
        String pattern = separator + "+";
        userInput = userInput.replaceAll(pattern, separator);
        return userInput;
    }
}
