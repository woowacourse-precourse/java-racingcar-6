package domain;

import java.util.List;
public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void runRace(int numberOfTries) {
        for (int i = 0; i < numberOfTries; i++) {
            raceOnce();
            printRoundResult();
        }
    }
}