package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Repeat;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;
    private Repeat repeat;
    private int repeatNum;
    CarListController carListController;
    CarNamesController carNamesController;
    RaceController raceController;

    public RacingGame() {
        this.carListController = new CarListController();
        this.carNamesController = new CarNamesController();
    }
    public void playRacingGame() {
        initRacingGameInput();

        OutputView.printResult();
        while(repeatNum > 0) {
            cars.raceCars();
            repeatNum--;
        }
//        cars.findWinner();
    }

    private void initRacingGameInput() {
        List<String> names = carNamesController.getCarNames();
        this.cars = carListController.createCars(names);
        this.repeat = new Repeat(InputView.inputRepeat());
        this.repeatNum = repeat.getRepeatNum();
    }
}
