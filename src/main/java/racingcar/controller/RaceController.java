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
        inputRacerNames();
        inputMoveNumber();
        repeatMove(racers, moveNumber);
        printFinalWinner();
    }

    private void repeatMove(List<Racer> racers, int moveNumber) {
        for (int move = 0; move < moveNumber; move++) {
            for (Racer racer : racers) {
                racer = StateMaker.getGoOrStop(racer);
                racer = RaceReferee.increaseGoMark(racer);
            }
            OutputView.printMoveResult(racers);
        }
    }

    private void inputRacerNames() {
        OutputView.printInputRacersNameMessage();
        this.carNames = InputView.readRacersName();
        racersNames = RacerManager.seperateRacersName(carNames);
        InputValidator.validateRacersName(racersNames);
        racers = RacerManager.createRacers(racersNames);
    }

    private void inputMoveNumber() {
        OutputView.printInputMoveNumberMessage();
        moveNumber = InputView.readMoveNumber();
    }

    private void printFinalWinner() {
        String winners = WinnerDecider.getWinner(racers);
        OutputView.printWinner(winners);
    }
}