package racingcar.view;

import static racingcar.view.InputView.inputAttemptsCount;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isCarNameOverFiveCharacters(List<String> carNameList) {
        boolean fiveCharacters = true;
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                fiveCharacters = false;
                break;
            }
        }
        return fiveCharacters;
    }

    public static boolean validateDelimiter(List<String> carNameList) {
        boolean validateDelimiter = true;

        String specialCharacters = "[^\\\\w,]+";
        Pattern p = Pattern.compile(specialCharacters);
        for (String carName : carNameList) {
            Matcher m = p.matcher(carName);
            if (!m.matches()) {
                validateDelimiter = false;
                break;
            }
        }
        return validateDelimiter;
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
