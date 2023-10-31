package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
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

        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }

        Pattern pattern = Pattern.compile("[a-zA-Z0-9가-힣]*");
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("자동차 이름은 영문자, 숫자, 한글만 포함할 수 있습니다.");
        }
    }

    private boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
