package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.service.Exception;
import racingcar.view.OutputView;

public class GameController {

    private final RacingGame game = new RacingGame();

    public void play() {
        setCar();
        setRaceCount();
        startRace();
    }

    private void setCar() {
        Exception.checkCarName(InputView.inputCarName());
        Car.carList = new ArrayList<>();
        for (String name : Exception.carNames) {
            Car.carList.add(new Car(name));
        }
    }

    private void setRaceCount() {
        game.setRaceCount(Exception.checkRaceCount(InputView.inputRaceCount()));
    }

    private void startRace() {
        OutputView.printRaceResultMessage();
        game.startRaceCount();
    }
}
