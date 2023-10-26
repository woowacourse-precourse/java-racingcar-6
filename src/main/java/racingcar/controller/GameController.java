package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.service.Exception;

public class GameController {
    public void play() {
        setCar();
        setRaceCount();
    }

    private void setCar() {
        Exception.checkCarName(InputView.inputCarName());
        Car.carList = new ArrayList<>();
        for (String name : Exception.carNames) {
            Car.carList.add(new Car(name));
        }
    }

    private void setRaceCount() {
        RacingGame game = new RacingGame(Exception.checkRaceCount(InputView.inputRaceCount()));
    }
}
