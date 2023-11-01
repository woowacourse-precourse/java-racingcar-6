package racingcar.domain;

import java.util.Map;

public class Car {
    private final Map<String, Integer> name;

    public Car(Map<String, Integer> name) {
        validateSize(name);
        this.name = name;
    }

    private void validateSize(Map<String, Integer> name) {
        for (String key : name.keySet()) {
            if (key.length() > 5) {
                throw new IllegalArgumentException("5글자가 넘는 이름은 입력하실 수 없습니다!");
            }
        }
    }
}
