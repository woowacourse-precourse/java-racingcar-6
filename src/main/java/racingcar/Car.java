package racingcar;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        // validateName(name);
        this.name = name;
    }

    private void validateFuel(int fuel) {
        if (fuel < 0 || fuel > 9) {
            throw new IllegalArgumentException("연료는 0 이상 9 이하의 값이어야 합니다.");
        }
    }
}
