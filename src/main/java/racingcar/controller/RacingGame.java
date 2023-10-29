package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.RepeatNum;
import racingcar.view.InputView;

public class RacingGame {
    private Cars cars;
    private RepeatNum repeatNum;
    CarListController carListController;
    CarNamesController carNamesController;

    public RacingGame() {
        this.carListController = new CarListController();
        this.carNamesController = new CarNamesController();
    }
    public void playRacingGame() {
        initRacingGameInput();
    }

    private void initRacingGameInput() {
        List<String> names = carNamesController.getCarNames();
        this.cars = carListController.createCars(names);
        this.repeatNum = new RepeatNum(InputView.inputRepeat());
    }
}
