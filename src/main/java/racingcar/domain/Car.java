package racingcar.domain;

public class Car {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private String name;
    private int forwardStep;

    public Car(String name, int forwardStep) {
        this.name = name;
        this.forwardStep = forwardStep;
    }

    public String getName() {
        return name;
    }

    public int getForwardStep() {
        return forwardStep;
    }

    public static Car of(String name) {
        validateCarName(name);
        return new Car(name, 0);
    }

    private static void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }

        if (carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하이어야 합니다.");
        }
    }

    public void moveForward() {
        forwardStep++;
    }
}
