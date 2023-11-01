package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.constant.GameMessage;

import java.util.regex.Pattern;

/**
 * 자동차 이름과 이동 거리를 가지고 있는 클래스
 */
public class Car {
    private String name;
    private int dist;

    public Car() {
    }

    public Car(String name) {
        validateCarName(name);

        this.name = name;
    }

    public Car(String name, int dist) {
        this(name);
        this.dist = dist;
    }

    public String getName() {
        return name;
    }

    public int getDist() {
        return dist;
    }

    private void validateCarName(String name) {
        // 자동차 이름이 길이 제한을 초과했을 경우 예외 발생
        if (name.length() > GameMessage.CAR_NAME_LENGTH_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_OVER);
        }
        // 자동차 이름이 공백일 경우 예외 발생
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_BLANK);
        }
        // 자동차 이름에 영어/한글/숫자 외의 문자가 입력되면 예외 발생
        if (!Pattern.matches(GameMessage.CAR_NAME_STRING_PATTERN, name)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_SPECIAL_SYMBOL);
        }
    }
}
