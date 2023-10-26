package racingcar.controller;

import java.util.ArrayList;
import racingcar.module.Car;
import racingcar.module.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    Race race = new Race();

    public void start() {
        final ArrayList<String> winners;
        final int repeatCount;

        InputView.getParticipant()
                .forEach(e -> race.addCar(new Car(e)));

        repeatCount = InputView.getTryCount();
        for (int i = 0; i < repeatCount; i++) {
            simulateTurn();
        }

        winners = race.getWinner();
        OutputView.printResult(winners);
    }

    void simulateTurn() {
        race.simulateTurn();

        for (Car c : race.getCarList()) {
            OutputView.printCurrent(c.getName(), c.getPos());
        }
    }
}
