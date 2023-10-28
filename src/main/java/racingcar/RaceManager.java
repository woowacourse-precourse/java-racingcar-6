package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    List<Car> raceCarList = new ArrayList<>();
    private int attempts = 0;

    private void runRace() {
        for (int i = 0; i < attempts; i++) {
            runRaceRound();
        }
    }

    private void runRaceRound() {
        for (Car car : raceCarList) {
            car.moveOnRandomChance();
        }
        // TODO: OutputView.showResult();
    }
}
