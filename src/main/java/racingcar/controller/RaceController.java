package racingcar.controller;

import java.util.ArrayList;
import racingcar.module.Car;
import racingcar.module.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Race race = new Race();

    public void start() {
        ArrayList<String> names = inputView.getParticipant();
        names.forEach(e -> race.addCar(new Car(e)));

        int repeatCount = inputView.getTryCount();
        for (int i = 0; i < repeatCount; i++) {
            simulateTurn();
        }

        ArrayList<String> winners = race.getWinner();
        outputView.printResult(winners);
    }

    void simulateTurn() {
        race.simulateTurn();

        for (Car c : race.getCarList()) {
            outputView.printCurrent(c.getName(), c.getPos());
        }
    }
}
