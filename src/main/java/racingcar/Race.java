package racingcar;

import static racingcar.Driving.raceWinner;

public class Race {
    public static void startRace(String[] carNames, int numberOfAttempts) {
        MyCar[] cars = CarFactory.production(carNames);
        raceWinner(numberOfAttempts, cars);
    }
}
