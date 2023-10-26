package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 길이의 범위를 벗어났습니다.");
        }
    }
}
