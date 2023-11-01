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
                throw new IllegalArgumentException("이름을 5자리 이하로 입력해주십시오.");
            }
        }
    }
}
