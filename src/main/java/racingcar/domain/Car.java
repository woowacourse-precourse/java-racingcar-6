package racingcar.domain;

public class Car {
    private String name;
    private int movedCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.movedCount = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
