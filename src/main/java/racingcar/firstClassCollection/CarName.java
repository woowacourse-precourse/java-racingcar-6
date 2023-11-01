package racingcar.firstClassCollection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarName {
    private static final int CAR_NAME_LENGTH_MAX = 5;
    String name;

    public CarName(String name) {
        checkValidCarName(name);
        this.name = name;
    }

    private void checkValidCarName(String name) {
        checkBeyondLengthRange(name);
        checkZeroLength(name);
        checkHasSpecialCharacter(name);
    }

    private void checkBeyondLengthRange(String name) {
        if (name.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("이름 최대길이를 초과");
        }
    }

    private void checkZeroLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름 길이가 0");
        }
    }

    private void checkHasSpecialCharacter(String name) {
        Pattern pattern = Pattern.compile("[^가-힣a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException("특수문자가 포함되어있음");
        }
    }

    public String getName() {
        return name;
    }
}
