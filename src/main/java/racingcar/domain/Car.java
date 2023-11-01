package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String VALID_NAME_PATTERN = "[a-zA-Z0-9가-힣]*";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void move() {
        if (shouldMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 한 글자 이상이어야 합니다");
        }

        if (name.trim().length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }

        Pattern pattern = Pattern.compile(VALID_NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("자동차 이름은 영문자, 숫자, 한글만 포함할 수 있습니다.");
        }
    }

    private boolean shouldMove() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= MOVE_THRESHOLD;
    }
}
