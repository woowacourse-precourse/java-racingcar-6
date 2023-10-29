package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.constant.GameMessage;

/**
 * 자동차 이름과 이동 거리를 가지고 있는 클래스
 */
public class Car {
    private String name;
    private int dist;

    public Car() {

    }

    public Car(String name) {
        name = name.trim();
        checkCarNameCondition(name);

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

    public void setDist(int dist) {
        this.dist = dist;
    }

    private void checkCarNameCondition(String name) {
        // 자동차 이름이 길이 제한을 초과했을 경우 예외 발생
        if (name.length() > GameMessage.CAR_NAME_LENGTH_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_OVER_ERR_MESSAGE);
        }
        // 자동차 이름이 공백일 경우 예외 발생
        if (name.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_BLANK_ERR_MESSAGE);
        }
    }
}
