package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exception {

    private static final int CAR_MAX_LENGTH = 5;
    public void ErrorCheck(String carName) {

    public void lengthCheck(String carName) {
        String[] carNameArray = carName.split(",");
        for (String name: carNameArray) {
            if (name.length() > CAR_MAX_LENGTH) {
                throw new IllegalArgumentException("5글자 넘어감");
            }
        }
    }

    public void stringCompile(String carName) {
        final Pattern compile = Pattern.compile(REGEX);
        final Matcher matcher = compile.matcher(carName);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
        }
    }


}

