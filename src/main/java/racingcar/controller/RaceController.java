package racingcar.controller;

import racingcar.model.Racer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private String carNames;
    private int moveNumber;
    private List<String> racersNames;
    private List<Racer> racers;

    public void play() {
        OutputView.printInputRacersNameMessage();
        this.carNames = InputView.readRacersName();
        racersNames = RacerManager.seperateRacersName(carNames);
        InputValidator.validateRacersName(racersNames);
        racers = RacerManager.createRacers(racersNames);
        OutputView.printInputMoveNumberMessage();
        moveNumber = InputView.readMoveNumber();
    }
}
