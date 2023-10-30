package racingcar.preprocess;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isCarNameOverFiveCharacters(List<String> carNameList) {
        return carNameList.stream()
                .allMatch(carName -> carName.length() <= 5);
    }

    public static boolean validateDelimiter(List<String> carNameList) {
        String specialCharacters = "[^,]+";
        Pattern pattern = Pattern.compile(specialCharacters);

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