package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
        this.name = name;
        this.position = 0;
    }
}
