package racingcar.exception.car_racing_game;

import java.util.List;

public class NotUniqueCarNameException extends IllegalArgumentException {

    public NotUniqueCarNameException(final List<String> keyList) {
        super(keyList + "에 중복된 이름이 있습니다.");
    }
}
