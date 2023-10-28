package racingcar.view;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.model.Car;

public class Validator {
    private static final List<String> carNameList = Car.getCarName();

    private static boolean isCarNameOverFiveCharacters() {
        boolean fiveCharacters = true;
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                fiveCharacters = false;
            }
        }
        return fiveCharacters;
    }

    private static boolean validateDelimiter() {
        boolean validateDelimiter = true;

        String specialCharacters = "[^\\\\w,]+";
        Pattern p = Pattern.compile(specialCharacters);
        for (String carName : carNameList) {
            Matcher m = p.matcher(carName);
            if (m.find()) {
                validateDelimiter = false;
            }
        }

        return validateDelimiter;
    }
}
