package racingcar.model;

import java.util.List;

public class Race {
    private int numberOfRace;
    private final Generator generator;
    private final static String TOO_MUCH_NUMBER_OF_RACE = "너무 많은 회수를 입력하였습니다.";
    private final static int REFERENCE_NUMBER = 4;

    private Race(int numberOfRace, Generator generator) {
        validateNumberOfRace(numberOfRace);
        this.numberOfRace = numberOfRace;
        this.generator = generator;
    }

    public static Race from(int numberOfRace, Generator generator) {
        return new Race(numberOfRace, generator);
    }

    private void validateNumberOfRace(int numberOfRace) {
        if (numberOfRace > 100) {
            throw new IllegalArgumentException(TOO_MUCH_NUMBER_OF_RACE);
        }
    }

    public void runSingleRace(List<Car> cars) {
        cars.stream()
                .filter(car -> generator.generateRandomNumber() >= REFERENCE_NUMBER)
                .forEach(Car::moveForward);
        this.numberOfRace--;
    }

    public boolean isRunning() {
        return this.numberOfRace > 0;
    }
}
