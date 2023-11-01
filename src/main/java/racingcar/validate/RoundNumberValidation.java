package racingcar.validate;

import java.util.regex.Pattern;

public class RoundNumberValidation implements UserInputValidation<String>{
    @Override
    public boolean validate(String data) {
        return Pattern.matches("^[1-9][0-9]*$", data);
    }
}
