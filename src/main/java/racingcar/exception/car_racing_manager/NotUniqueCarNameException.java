package racingcar.exception.car_racing_manager;

import java.util.List;

public class NotUniqueCarNameException extends IllegalArgumentException {

    public NotUniqueCarNameException(final List<String> carNames) {
        super("입력하신 자동차 이름중에 중복된 이름이 있습니다. 입력하신 자동차 이름: " + carNames);
    }
}
