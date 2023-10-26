package racingcar.domain;

public class Car {
    private static final int CAR_NAME_UPPER_LIMIT = 5;
    private static final int CAR_DEFAULT_LOCATION = 0;
    private final Engine engine = new Engine();
    private final String name;
    private int location;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.location = CAR_DEFAULT_LOCATION;
    }

    public void race(int moveTrials) {
        for (int i = 0; i < moveTrials; i++) {
            tryToMove();
        }
    }

    private void tryToMove() {
        if (engine.tryToTurnOn()) {
            location++;
        }
    }

    private void validateName(String name) {
        try {
            name.charAt(CAR_NAME_UPPER_LIMIT);
        } catch (StringIndexOutOfBoundsException e) {
            return;
        }

        throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다");
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
