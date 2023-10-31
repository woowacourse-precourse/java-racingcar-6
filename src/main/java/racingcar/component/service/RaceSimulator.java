package racingcar.component.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.component.domain.Car;

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

    public void simulate(List<Car> cars, int duration) {
        System.out.println("\n실행 결과");
        while (duration-- > 0) {
            oneLoop(cars);
        }
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
