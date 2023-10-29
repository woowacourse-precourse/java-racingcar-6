package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final Race race;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(Race race, InputView inputView, OutputView outputView) {
        this.race = race;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        inputCarNames();
        inputGameCount();
    }

    private void inputCarNames() {
        String[] carNames = inputView.askCarNames().split(",");
        for (String carName : carNames) {
            race.add(new Car(carName));
        }
    }

    private void inputGameCount() {
        race.setGameCount(Integer.parseInt(inputView.askGameCount()));
    }
}
