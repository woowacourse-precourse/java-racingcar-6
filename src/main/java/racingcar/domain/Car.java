package racingcar.domain;


import racingcar.utils.GameRules;

public class Car {
    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = GameRules.START_POSITION.getValue();
    }

    public static Car createCar(String name) {
        isNotNull(name);
        isOverSize(name);
        return new Car(name);
    }

    private static void isNotNull(final String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isOverSize(final String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void go() {
        int randomNumber = NumberGenerator.generateNumber();
        if (randomNumber >= GameRules.GO_CONDITION.getValue()) {
            this.position++;
        }
    }

    public boolean isWinner(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
