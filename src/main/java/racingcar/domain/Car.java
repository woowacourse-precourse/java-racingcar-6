package racingcar.domain;

import racingcar.util.RaceNumberGenerator;

public class Car {

    private static final int MIN_MOVE_RACE_NUMBER = 4;

    private final String name;

    private String position;

    public Car(String name) {
        this.name = name;
        position = "";
    }

    public Car(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPositionLength() {
        return position.length();
    }

    public void moveOrStop(RaceNumberGenerator raceNumberGenerator) {

        int randomNumber = raceNumberGenerator.generator();
        if (randomNumber >= MIN_MOVE_RACE_NUMBER) {
            position += "-";
        }
    }
}
