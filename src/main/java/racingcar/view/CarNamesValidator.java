package racingcar.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNamesValidator implements InputValidator {
    private Pattern pattern;

    public CarNamesValidator() {
        pattern = Pattern.compile("^([a-zA-Z0-9]{1,5},)*[a-zA-Z0-9]{1,5}$");
    }

    @Override
    public void validate(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid Format: names should be 1~5 characters, divided by comma.");
        }
    }
}
