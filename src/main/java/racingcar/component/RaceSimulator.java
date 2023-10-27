package racingcar.component;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RaceSimulator {
    private Printer printer;
    private RaceSimulator(Printer printer) {
        this.printer = printer;
    }

    private static RaceSimulator raceSimulator;

    public static RaceSimulator getRaceSimulator(Printer printer) {
        if (raceSimulator == null) {
            raceSimulator = new RaceSimulator(printer);
        }
        return raceSimulator;
    }

    private void oneLoop(List<Car> cars) {
        for (Car car : cars) {
            if (canGo()) {
                car.go();
            }
        }
        printer.printCurrent(cars);
    }

    private boolean canGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
