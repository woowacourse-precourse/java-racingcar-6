package racingcar.component;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RaceSimulator {
    private RaceSimulator() {}

    private static RaceSimulator raceSimulator;

    public static RaceSimulator getRaceSimulator() {
        if (raceSimulator == null) {
            raceSimulator = new RaceSimulator();
        }
        return raceSimulator;
    }

    private void oneLoop(List<Car> cars) {
        for (Car car : cars) {
            if (canGo()) {
                car.go();
            }
        }
    }

    private boolean canGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
