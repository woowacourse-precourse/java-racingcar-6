package racingcar.domain;

import java.util.Map;

public class Cars {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_EXCESS_ERROR_MESSAGE = "자동차 이름의 길이가 5를 초과했습니다.";

    /* 자동차 이름을 key(String)로 가지고 전진 횟수를 value(Integer)로 가진다. */
    private final Map<String, Integer> cars;


    public Cars(Map<String, Integer> cars) {
        for (String name : cars.keySet()) {
            verifyCarNameLength(name);
        }
        this.cars = cars;
    }

    private void verifyCarNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCESS_ERROR_MESSAGE);
        }
    }
}
