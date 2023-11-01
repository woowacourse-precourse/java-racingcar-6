package racingcar.controller;

import java.util.List;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<String> carNameList = inputView.getCarName();
        int trialNum = inputView.getTrialNum();
        race = new Race(trialNum, carNameList);

        play();
        finish();
    }

    private void play() {
        List<Integer> driveCountList;
        List<String> carNameList = race.makeCarNameList();

        outputView.printResult();
        while (!race.isFinish()) {
            race.runRace();
            driveCountList = race.makeCarDriveCountList();
            outputView.printDrive(carNameList, driveCountList);
        }
    }

    private void finish() {
        List<String> winners = race.findWinner();
        if (winners.size() == 1) {
            outputView.printOneWinner(winners.get(0));
        } else {
            outputView.printWinners(winners);
        }
    }

}
