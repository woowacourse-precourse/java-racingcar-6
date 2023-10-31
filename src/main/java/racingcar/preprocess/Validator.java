package racingcar.preprocess;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ALLOWED_CHARACTERS_PATTERN = "[^,]+";

    public static boolean isCarNameOverFiveCharacters(List<String> carNameList) {
        return carNameList.stream()
                .allMatch(carName -> carName.length() <= MAX_CAR_NAME_LENGTH);
    }

    public static boolean validateDelimiter(List<String> carNameList) {
        Pattern pattern = Pattern.compile(ALLOWED_CHARACTERS_PATTERN);

        return carNameList.stream()
                .allMatch(carName -> pattern.matcher(carName).matches());
    }

    public static boolean isEmpty(List<String> carNameList) {
        return !carNameList.isEmpty();
    }

    public static boolean isNonNumericInput(String inputAttemptsCount) {
        boolean isNumeric = true;
        try {
            Integer.parseInt(inputAttemptsCount);
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        return isNumeric;
    }
}