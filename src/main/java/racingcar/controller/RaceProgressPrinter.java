package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.ConsoleView;

public class RaceProgressPrinter {
    private ConsoleView view;

    public RaceProgressPrinter() {
        view = new ConsoleView();
    }

    public void printRaceResult(RacingCar[] cars) {
        for (RacingCar car : cars) {
            StringBuilder result = new StringBuilder(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                    result.append("-");
            }
            view.printMessage(result.toString());
            result.setLength(0);
        }
    }
}
