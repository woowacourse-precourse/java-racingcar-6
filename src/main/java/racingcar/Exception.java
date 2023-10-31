package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exception {

    private static final int CAR_MAX_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "5글자가 넘어 갑니다.";
    private static final String INPUT_FORMAT_ERROR = "올바른 입력이 아닙니다.";
    private static final String REGEX = "^[a-zA-Z가-힣,]*$";

    public void lengthCheck(String carName) {
        String[] carNameArray = carName.split(",");
        for (String name : carNameArray) {
            if (name.length() > CAR_MAX_LENGTH) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
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

