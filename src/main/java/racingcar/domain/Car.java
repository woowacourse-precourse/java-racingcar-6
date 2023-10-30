package racingcar.domain;

public class Car {
    private String name;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름 형식이 잘못되었습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
