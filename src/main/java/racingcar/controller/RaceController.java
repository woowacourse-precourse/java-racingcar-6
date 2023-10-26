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
        String s = inputView.getParticipant();
        ArrayList<String> names = validateNames(s); //TO-DO
        names.forEach(e -> race.addCar(new Car(e)));

        String num = inputView.getTryCount();
        int repeatCount = validateCount(num);

        for (int i = 0; i < repeatCount; i++) {
            simulateTurn();
        }

        ArrayList<String> winners = race.getWinner();
        outputView.printResult(winners);
    }

    void simulateTurn() {
        race.simulateTurn();
        race.getCarList().forEach(c -> outputView.printCurrent(c.getName(), c.getPos()));
    }
}
