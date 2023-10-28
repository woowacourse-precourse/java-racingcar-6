package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {

    List<Car> raceCarList = new ArrayList<>();

    private void runRaceRound() {
        for (Car car : raceCarList) {
            car.moveOnRandomChance();
        }
        // TODO: OutputView.showResult();
    }
}
